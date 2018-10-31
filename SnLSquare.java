/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class SnLSquare {

    private int number;

    /**
     *
     * Initializes number to value passed
     *
     * @param number position of the square that player will be positioned at
     */
    public SnLSquare(int number) {
        this.number = number;
    }

    /**
     *
     * Returns the square number
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * Returns the square number
     *
     * @return
     */
    public int landOn() {
        return getNumber();
    }

    /**
     *
     * Returns the number of the square as a string
     *
     * @return
     */
    @Override
    public String toString() {
        return "" + number;
    }

    /**
     *
     * Comparing the passed object to this
     *
     * @param o compared to this
     * @return
     */
    @Override
    public boolean equals(Object o) {
        // Checks if object is the same tyoe of this class
        if (o == this) {
            return true;
        }

        // Checks object is null
        if (o == null) {
            return false;
        }

        // Checks if object class is the same as this class
        if (this.getClass() != o.getClass()) {
            return false;
        }

        // Checks if instance variables equal
        SnLSquare s = (SnLSquare) o;
        return (this.number == s.number);
    }
}
