package gaforfunctionoptimization2;

// @author Muhammad Luthfi Shahab

public class GAforFunctionOptimizationSemuaIDanJ {

    public static void main(String[] args) {
        for(int numOfVariable = 10; numOfVariable <= 100000; numOfVariable *= 10) {
            Library.setNumOfVariable(numOfVariable);
            
            for(int typeOfFunction = 1; typeOfFunction <= 5; typeOfFunction++) {
                Library.setTypeOfFunction(typeOfFunction);

                int jumlahsolusi = 100;
                int jumlahiterasi = 10000;
                
                long startTime = System.nanoTime();
                
                Population pop = new Population(jumlahsolusi, true);

                for(int i = 1; i <= jumlahiterasi; i++){
                    Library.setGeneration(i);
                    pop = GeneticAlgorithm.evolve(pop);

                    if(i%10 == 0) {
                        //double a = 0;
                        double a = -1;
                        for(int j = 0; j < pop.size(); j++) {
                            pop.getSolution(j).setFitness(a);
                        }
                    }
                }
                
                long endTime = System.nanoTime();
                
                long totalTime = (endTime - startTime)/1000;
                totalTime /= 1000;
                totalTime /= 1000;
                
                double finalFitness = Library.getSumFunction(pop.getFittest().getX());
                System.out.println("Function\t" + typeOfFunction + "\tNumOfVariable\t" + numOfVariable + "\tFitness\t" + finalFitness + "\tWaktu\t" + totalTime);
            }
        }
    }
}