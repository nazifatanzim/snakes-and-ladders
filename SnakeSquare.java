/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class SnakeSquare extends SorLSquare{
    /**
     * 
     * Creating the snake square
     * 
     * @param number square where the head of the snake will be
     * @param endSquare square that the player will end of on (snake tail)
     */
    public SnakeSquare(int number, int endSquare){
        // Inheriting values from parent class
        super(number,endSquare);
        
        // Checks if snake head below tail and throws an exception error
        if(endSquare > number)
            throw new IllegalArgumentException("Invalid Snake");
    }
    
    /**
     * 
     * Returns the value of the square that the player will land on
     * 
     * @return 
     */
    @Override
    public int landOn(){
        // Inheriting value from parent class
        return super.landOn();
    }
    
    /**
     * 
     * Indicates a snake square
     * Shows the square that is landed on originally minus the square that the
     * player will end up on
     * 
     * @return 
     */
    @Override
    public String toString(){
        return (super.getNumber()) + "-" + super.getEndSquare();
    }
    
    /**
     * 
     * Did not override equals method because the same instance variables that
     * are inherited are already being checked in the parent classes
     * 
     */
}
