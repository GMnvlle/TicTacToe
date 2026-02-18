/**
 * Player class defines the player as a non-playable that randomly selects a move
 */
import java.util.Random;
public class Player
{
    /**
     * Instance Variable
     */
    private String symbol;
    
    /**
     * Player constructor
     * @param s - player's corresponding symbol
     */
    public Player(String s){
        symbol = s;
    }
    
    /**
     * Accessor for player's symbol
     * @return String the player's assigned symbol
     */
    public String getSymbol(){
        return symbol;
    }
    
    /**
     * Gets a randomized move from player
     * Possible moves are between 1 and the size of the board
     * @param b - the current board being used
     * @return int player's randomized move
     */
    public int getMove(Board b) {
        Random rng = new Random();
        int num = rng.nextInt(b.getSize()*b.getSize())+1;
        while(!b.isValidMove(num)){
            num = rng.nextInt(b.getSize()*b.getSize())+1;
        }
        return num;
    }
}