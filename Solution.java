package gaforfunctionoptimization2;

// @author Muhammad Luthfi Shahab

public class Solution {
    double x[] = new double[Library.getNumOfVariable()];
    //double fitness = 0;
    double fitness = -1;
    
    // constructor
    public Solution(){
        for(int i = 0; i < x.length; i++){
            x[i] = Math.random()*20-10;
        }
    }
    
    public Solution(double a[], double f){
        x = a.clone();
        fitness = f;
    }
    
    public void setX(int i, double a){
        double b = x[i];
        x[i] = a;
        fitness += Library.getFunction(a) - Library.getFunction(b);
    }
    
    public void setFitness(double a) {
        fitness = a;
    }
    
    public double[] getX(){
        return x;
    }
    
    public double getX(int i){
        return x[i];
    }
    
    public double f(){
        double result = 0;
        for(int i = 0; i < x.length; i++){
            result += Library.getFunction(x[i]);
        }
        return result;
    }
    
    public double getFitness(){
        //if(fitness == 0){
        if(fitness == -1){
            fitness = f();
        }
        return fitness;
    }
    
    public void printX(){
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i] + "\t");
        }
        System.out.println();
    }
    
    public void printFitness(){
        System.out.println(getFitness());
    }
}