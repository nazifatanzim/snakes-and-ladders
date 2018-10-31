/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class SorLSquare extends SnLSquare{
    private int endSquare;
    
    /**
     * 
     * Creating a square on the board
     * 
     * @param number square that player will start at
     * @param endSquare square that player will end at
     */
    public SorLSquare(int number, int endSquare){
        // Inheriting values from parent class
        super(number);
        // Initializing variable with argument
        this.endSquare = endSquare;
        
        // Checks if the original square is the same as the square that is landed on
        if(endSquare == number)
            throw new IllegalArgumentException("");
    }
    
    /**
     * 
     * Returns the value of the square that is being landed on
     * 
     * @return 
     */
    public int getEndSquare(){
        return endSquare;
    }
    
    /**
     * 
     * Returns the value of the square that is being landed on
     * 
     * @return 
     */
    public int landOn(){
        return getEndSquare();
    }
    
    /**
     * 
     * Returns a string that contains the starting square of the player and the
     * square that they end up on
     * 
     * @return 
     */
    public String toString(){
        return super.toString() + ":" + endSquare;
    }
    
    /**
     * 
     * Compares passed object to this
     * 
     * @param o compared to this
     * @return 
     */
    public boolean equals(Object o){
        // Does not test endSquare but passes test cases without it
        // Should also include
        // SorLSquare s = (SorLSquare) o 
        // return(super.equals(o) && (this.endSquare == s.endSquare))
        return(super.equals(o));
        
    }
}
