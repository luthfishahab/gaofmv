package gaforfunctionoptimization2;

// @author Muhammad Luthfi Shahab

public class Population {
    Solution[] solution;
    
    public Population(int n, boolean bool){
        solution = new Solution[n];
        if(bool){
            for(int i = 0; i < n; i++){
                Solution newSolution = new Solution();
                saveSolution(i, newSolution);
            }
        }
    }
    
    public void saveSolution(int index, Solution solusiBaru){
        solution[index] = solusiBaru;
    }
    
    public Solution getSolution(int index){
        return solution[index];
    }
    
    public Solution getFittest(){
        Solution fittest = solution[0];
        for(int i = 0; i < solution.length; i++){
            if(getSolution(i).getFitness() < fittest.getFitness()){
                fittest = getSolution(i);
            }
        }
        return fittest;
    }
    
    public int size() {
        return solution.length;
    }
}