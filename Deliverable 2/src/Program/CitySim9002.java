package Program;

import Domain.Validator;
import java.util.Random;

/**
 *
 * @author Jingyi Lin (jil173)
 */

public class CitySim9002 {  
        static int iteration = 5;
        static RandomNumber generator;
	
    public static void main(String[] args) {      
        int seed = 0;
        
        Visitor visitor = new Visitor();
        String nextVisitor = "";
        Location location = new Location();       
        String nextLocation = "";
        
        RandomNumber generatorVis = new RandomNumber(seed, iteration - 1);
        generator = new RandomNumber(seed, iteration);
        String[] visitorList = visitor.generateVisitorList(generatorVis);
        
        //  Validate input - should be an integer.
        if(!validArgument(args)){
            System.out.println("Please enter one integer argument, seed.");
            System.exit(0);
        } else {
            seed = Integer.parseInt(args[0]);
        }
        
        //  Begin output.
        System.out.println("Welcome to CitySim! Yor seed is " + seed + ".");            
           
        for(int i = 0; i < iteration; i++){
            nextVisitor = visitorList[i];
            System.out.println("Visitor " + (i + 1) + " is a " + nextVisitor + ".");
            nextLocation = location.getLocation(generator.generateNumber());
        	
            //  Ensure visitor not left in the first iteration.
            while(firstVisit(nextLocation)){
                nextLocation = location.getLocation(generator.generateNumber()); 
            }
            
            while(nextLocation !=  "left"){
                System.out.println("Visitor " + (i + 1) + " is going to " + nextLocation + "!");
                
                //  Check visitors' preferences.
                if(visitor.likeLoc(nextVisitor, nextLocation)){
                        System.out.println("Visitor " + (i + 1) + " did like " + nextLocation + ".");
                } else {
                        System.out.println("Visitor " + (i + 1) + " did not like " + nextLocation + ".");
                }

                nextLocation = location.getLocation(generator.generateNumber());
            }
        	
            System.out.println("Visitor " + (i + 1) + " has left the city.");
            System.out.println("***");
        }     
    } 
    
    //  Validate argument.
    public static boolean validArgument(String[] args){
        if(args.length != 1){
            return false;
        }
        try{
            Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {     //  Check whether the argument is an integer.
            return false;
        } catch (NullPointerException e) {     // Check whether the argument is null.
            return false;
        }
        return true;        
    }
    
    public static boolean firstVisit(String s){       
        if(s == "left"){
            return true;
        }
        return false;
    }
}

