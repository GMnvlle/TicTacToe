/**
 * InteractivePlayer class inherits the Player class
 * Allows for user input
 */
import java.util.Scanner;
public class InteractivePlayer extends Player
{
    /**
     * Instance variable
     */
    private Scanner scan;
    
    /**
     * InteractivePlayer Constructor
     * (note that it inherits the Player constructor)
     * @param s - player's corresponding symbol
     */
    public InteractivePlayer(String s){
        super(s);
        scan = new Scanner(System.in);
    }
    
    /**
     * InteractivePlayer Constructor
     * (note that it inherits the Player constructor)
     * @param s - player's corresponding symbol
     * @param sc - the scanner object being used for this player
     */
    public InteractivePlayer(String s, Scanner sc){
        super(s);
        scan = sc;
    }
    
    /**
     * Accessor for the scanner object
     * @return Scanner the scanner object
     */
    public Scanner getScan(){
        return scan;
    }
    
    /**
     * Overrides the get move method to get the user's player input
     * Possible moves are between 1 and the size of the board
     * @param b - the current board being used
     * @return int player's randomized move
     */
    @Override
    public int getMove(Board b){
        System.out.println("Enter a valid number: ");
        int userInput = scan.nextInt();
        while(!b.isValidMove(userInput)){
            System.out.println("Not valid number");
            System.out.println("Enter a valid number: ");
            userInput = scan.nextInt();
        }
        return userInput;
    }
}
