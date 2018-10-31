

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Date;
/**
 *
 * @author Nazifa Tanzim
 * 101074707
 */
public class Dice {
    private int[] die;
    private Random random = new Random();
    
    public Dice(){
        this(2);
    }
    
    /**
     * Constructs and rolls a number of dice
     * 
     * @param numDice 
     */
    public Dice(int numDice){
        if (numDice < 1)
            throw new IllegalArgumentException ("You need at least one die");
        
        this.die = new int[numDice];
        this.random = new Random(new Date().hashCode());
        roll();
    }
    
    /**
     * Randomly generates a value for each die between 1 and 6
     * 
     * @return sum of all values
     */
    public int roll(){
        int sum = 0;
        for(int i = 0; i < die.length; i++){
            die[i] = rollDie();
            sum += die[i];
        }
        return sum;
    }
    
    /**
     * Generates a random value between 1 and 6 for a single die
     * 
     * @return 
     */
    private int rollDie(){ 
        return random.nextInt(6) + 1;
    }
    
    /**
     * Returns a copy of all the values of each die in an array
     * 
     * @return 
     */
    public int[] getDieValues(){
        int[] copyDie = new int[die.length];
        
        for(int i = 0; i < die.length; i++){
            copyDie[i] = die[i];
        }
        
        return copyDie;
    }
    
    /**
     * Checks if any dice values are repeated
     * 
     * @return 
     */
    public boolean hasDoubles(){
        die = getDieValues();
        boolean doubles = false;
        
        for(int i = 0; i < die.length; i++){
            for(int j = 0; j<die.length; j++){
               if(die[i] == die[j]){
                   doubles = true;
               }
            }
        }
        return doubles;
    }
    
    /**
     * Returns a string containing all the dice values
     * 
     * @return 
     */
    @Override
    public String toString(){
        die = getDieValues();
        String s = new String();
        
        for(int i = 0; i < die.length; i++){
            s += this.die[i] + " ";
        }
        return s;
    }
}
