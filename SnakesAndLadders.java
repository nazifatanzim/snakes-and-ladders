/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nazifa Tanzim
 */
public class SnakesAndLadders {
    // Declaring instance variables
    public static int NUM_PLAYERS;
    public static final int NUM_SQUARES = 100;

    private SnLSquare[] board;
    private int[] players;
    private Dice dice;

    public SnakesAndLadders() {
        // Creating default game using constructor chaining
        // Default number of players is 2
        this(2);
    }

    /**
     *
     * Initializes board, including snakes and ladders squares
     * Initializes player positions such that everyone starts at square 1
     * 
     * @param nPlayers number of players
     */
    public SnakesAndLadders(int nPlayers) {
        // Initializing variables
        NUM_PLAYERS = nPlayers;
        dice = new Dice();
        players = new int[NUM_PLAYERS];
        board = new SnLSquare[NUM_SQUARES];

        // Initializing board
        for (int i = 0; i < NUM_SQUARES; i++) {
            // Setting each square to its proper number
            board[i] = new SnLSquare(i + 1);
        }
        
        // Specifying which squares are ladder squares
        board[3] = new LadderSquare(4, 14);
        board[8] = new LadderSquare(9, 31);
        board[19] = new LadderSquare(20, 38);
        board[27] = new LadderSquare(28, 84);
        board[39] = new LadderSquare(40, 59);
        board[62] = new LadderSquare(63, 81);
        board[70] = new LadderSquare(71, 91);
        
        // Specifying which squares are snake squares
        board[16] = new SnakeSquare(17, 7);
        board[53] = new SnakeSquare(54, 34);
        board[61] = new SnakeSquare(62, 18);
        board[63] = new SnakeSquare(64, 60);
        board[86] = new SnakeSquare(87, 24);
        board[92] = new SnakeSquare(93, 73);
        board[94] = new SnakeSquare(95, 75);
        board[98] = new SnakeSquare(99, 78);

        // Initializing array that holds player moves
        for (int i = 0; i < NUM_PLAYERS; i++) {
            // Each player starts at position 1
            players[i] = 1;
        }
    }

    /**
     *
     * Completes a turn for a player
     * Repeats turn if doubles are rolled
     * Makes correction if players rolls a number that takes them off the board (past 100)
     * i.e. makes sure the paley only wins if they roll an exact value
     * 
     * @param player the player whose turn it is
     * @return
     */
    public boolean takeTurn(int player) {
        do {
            // Rolling the dice
            int n = dice.roll();

            // Printing the move
            System.out.println("Player " + player + " rolled " + n);
            
            // Moving the player
            players[player] += n;

            // Checks if player has rolled an exact value to get to 100 and makes
            // the appropriate correction
            if (players[player] > 100) {
                players[player] = (200 - players[player]);
            }

            // Keeping track of the position of the board
            int j = players[player] - 1;
            
            // Checks if player has landed on a snake square
            if (board[j] instanceof SnakeSquare) {
                // Updates player position
                players[player] = board[j].landOn();
                System.out.println("Oh No!");
            }
            // Checks if player has landed on a snake square and updates their position
            else if (board[j] instanceof LadderSquare) {
                // Updates player position
                players[player] = board[j].landOn(); 
                System.out.println("Yay!"); 
            }
        } while (!dice.hasDoubles()); // Loops through this when doubles have been rolled
        
        // Returns whether or not doubles were rolled
        return dice.hasDoubles();
    }

    /**
     * 
     * Checks if the player has won and returns true if they are
     *
     * @param player
     * @return
     */
    public boolean isPlayerWinner(int player) {
        // Checks if the player has landed on the final square
        if (this.getPlayerPosition(player) == 100) {
            return true;
        }
        return false;
    }

    /**
     * Checks position of all the players to see who won
     * Returns the player who won
     * Returns -1 if no one has won yet
     * 
     * @return
     */
    public int getWinner() {
        // Iterating through all the players
        for (int i = 0; i < NUM_PLAYERS; i++) {
            // Checking if the player has won
            if (this.isPlayerWinner(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     * Returns the player's position on the board
     *
     * @param player
     * @return
     */
    public int getPlayerPosition(int player) {
        return players[player];
    }

    /**
     * 
     * "Assembling" the board in a single string and returning it
     *
     * @return
     */
    @Override
    public String toString() {
        String s = new String();

        for (int i = 0; i < 100; i++) {
            // Adding a square to the board
            s += "|" + board[i];

            // Goes to the next line at the end of a row
            if ((i + 1) % 10 == 0) {
                s += "\n";
            }
        }
        return s;
    }

    /**
     * 
     * Creating a string of the positions of every player and returning it
     *
     * @return
     */
    public String toStringCurrentPositions() {
        // Declaring and initializing variables
        String[] s = new String[NUM_PLAYERS];
        String s2 = new String();

        // Iterating through every player
        for (int i = 0; i < NUM_PLAYERS; i++) {
            // Getting info of player i in a string srray
            s[i] = i + ":" + this.getPlayerPosition(i);
            
            // Adding player i info to string to be returned
            // i.e. combining everything into one line
            s2 += s[i] + " ";
        }
        return s2;
    }

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        // Declaring variables
        int num = 3; // Number of players
        int turn = 0; // Player who is starting
        
        // Creating new game
        SnakesAndLadders game = new SnakesAndLadders(num);

        // Printing the board
        System.out.println(game.toString());

        // Playing the game until someone has won
        while (game.getWinner() == -1) {
            // Player takes their turn
            game.takeTurn(turn);
            
            // Checks if there is a winner
            if(game.getWinner() == -1){
                // Outputs positions if there isn't a winner
                System.out.println(game.toStringCurrentPositions());
            }
            
            // Moves on to next player's turn
            turn++;
            
            // Starts another round of turns once everyone has gone
            if (turn == num) {
                turn = 0;
            }
        }

        // Outputting the winner
        System.out.println("Player " + game.getWinner() + " wins!");
    }
}
