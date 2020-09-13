package gaforfunctionoptimization2;

// @author Muhammad Luthfi Shahab

public class Library {
    private static int numOfVariable;
    private static int numOfSolution;
    private static double generation;
    private static int typeOfFunction;
    
    public static void setNumOfVariable(int a) {
        numOfVariable = a;
    }
    
    public static int getNumOfVariable() {
        return numOfVariable;
    }
    
    public static void setNumOfSolution(int a) {
        numOfSolution = a;
    }
    
    public static int getNumOfSolution() {
        return numOfSolution;
    }
    
    public static void setGeneration(int a) {
        generation = a;
    }
    
    public static double getGeneration() {
        return generation;
    }
    
    public static void setTypeOfFunction(int a) {
        typeOfFunction = a;
    }
    
    public static int getTypeOfFunction() {
        return typeOfFunction;
    }
    
    public static double getFunction(double x) {
        double d = 0;
        // Alpine
        if(typeOfFunction == 5) {
            d = Math.abs(x*Math.sin(x)+0.1*x);
        }
        // Step
        else if(typeOfFunction == 4) {
            d = (int)(Math.abs(x));
        }
        // Quintic
        else if(typeOfFunction == 3) {
            d = Math.abs(x*x*x*x*x-3*x*x*x*x+4*x*x*x+2*x*x-10*x-4);
        }
        // Schumer Steiglitz
        else if(typeOfFunction == 2) {
            d = x*x*x*x;
        }
        // Sphere
        else if(typeOfFunction == 1) {
            d = x*x;
        }
        return d;
    }
    
    public static double getSumFunction(double x[]) {
        double sum = 0;
        for(int i = 0; i < x.length; i++) {
            sum += getFunction(x[i]);
        }
        return sum;
    }
}