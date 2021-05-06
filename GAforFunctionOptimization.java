package gaforfunctionoptimization2;

// @author Muhammad Luthfi Shahab

public class GAforFunctionOptimization {

    public static void main(String[] args) {
        int typeOfFunction = 1;
        Library.setTypeOfFunction(typeOfFunction);
        
        // example of numOfVariable = 10, 100, 1000, 10000
        int numOfVariable = 10;
        Library.setNumOfVariable(numOfVariable);
        
        int jumlahsolusi = 100;
        int jumlahiterasi = 10000;
        
        Population pop = new Population(jumlahsolusi, true);
        
        for(int i = 1; i <= jumlahiterasi; i++){
            Library.setGeneration(i);
            pop = GeneticAlgorithm.evolve(pop);
            
            if(i%10 == 0) {
                double a = 0;
                for(int j = 0; j < pop.size(); j++) {
                    pop.getSolution(j).setFitness(a);
                }
            }
        }
        
        pop.getFittest().printX();
        double finalFitness = Library.getSumFunction(pop.getFittest().getX());
        System.out.println(finalFitness);
    }
}
