package gaforfunctionoptimization2;

// @author Muhammad Luthfi Shahab

public class GeneticAlgorithm {
    private static final int t = 5;
    
    // average crossover
    public static Solution crossover(Solution ortu1, Solution ortu2){
        Solution anak1 = new Solution(ortu1.getX(), ortu1.getFitness());
        
        for(int i = 0; i < Library.getNumOfVariable(); i++){
            double x = anak1.getX(i);
            double f = anak1.getFitness();
            anak1.setX(i,(ortu1.getX(i) + ortu2.getX(i))/2);
            if(anak1.getFitness() > f){
                anak1.setX(i, x);
                anak1.setFitness(f);
            }
        }
        
        return anak1;
    }
    
    //buat method mutasi
    private static void mutation(Solution solusi){
        double solusi2[] = solusi.getX().clone();
        for(int i = 0; i < Library.getNumOfVariable(); i++){
            double f = solusi.getFitness();
            solusi.setX(i, solusi.getX(i)+((Math.random()-0.5)/Library.getGeneration()));
            if(solusi.getFitness() > f){
                solusi.setX(i, solusi2[i]);
                solusi.setFitness(f);
            }
        }
    }
    
    //seleksi turnamen
    private static Solution tournamentSelection(Population pop){
        Population seleksiturnamen = new Population(t, false);
        for(int i = 0; i < t; i++){
            int acak = (int)(Math.random()*pop.size());
            seleksiturnamen.saveSolution(i, pop.getSolution(acak));
        }
        Solution fittest = seleksiturnamen.getFittest();
        return fittest;
    }
    
    //lakukan operasi algoritma genetika (melakukan evolusi)
    public static Population evolve(Population pop) {
        int a = 2*pop.size();
        int b = pop.size();

        Population newPopulation = new Population(pop.size(), false);
        
        // crossover, kemudian di masukkan ke newPopulation
        for (int i = 0; i < newPopulation.size(); i++) {
            Solution parent1 = tournamentSelection(pop);
            Solution parent2 = tournamentSelection(pop);
            Solution child = crossover(parent1, parent2);
            newPopulation.saveSolution(i, child);
        }
        
        // mutasi solusi baru yang didapat dari crossover
        for (int i = 0; i < newPopulation.size(); i++) {
            mutation(newPopulation.getSolution(i));
        }

        // populasi lama dan populasi baru digabung
        Population newPopulation2 = new Population(a, false);

        for (int i = 0; i < pop.size(); i++) {
            newPopulation2.saveSolution(i, pop.getSolution(i));
        }

        for (int i = 0; i < pop.size(); i++) {
            newPopulation2.saveSolution((b+i), newPopulation.getSolution(i));
        }

        // diurutkan berdasarkan fitness terbaik
        for (int i = 0; i < a; i++){
            int k = i;
            Solution fittest = newPopulation2.getSolution(i);
            for (int j = i+1; j < a; j++) {
                if (fittest.getFitness() >= newPopulation2.getSolution(j).getFitness()) {
                    fittest = newPopulation2.getSolution(j);
                    k = j;
                }
            }
            newPopulation2.saveSolution(k, newPopulation2.getSolution(i));
            newPopulation2.saveSolution(i, fittest);
        }
        
        // yang sama dibuang
        Population newPopulation3 = new Population(b, false);
        int m = 0;
        newPopulation3.saveSolution(0, newPopulation2.getSolution(0));

        for (int i = 1; i < b; i++){
            if (newPopulation2.getSolution(i).getFitness() != newPopulation3.getSolution(m).getFitness()){
                m++;
                newPopulation3.saveSolution(m, newPopulation2.getSolution(i));
            }
        }
        
        // jika ada yang dibuang, ditambah dengan solusi acak baru
        if ((m+1) != b){
            for (int i = m+1; i < b; i++){
                Solution acak = new Solution();
                newPopulation3.saveSolution(i, acak);
            }
        }

        return newPopulation3;
    }
}
