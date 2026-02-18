/**
 * Game class sets up board and assigns values to players
 * It plays the game, displays the board, and determines if the game is over
 */
public class Game
{
    /**
     * Instance variables
     */
    private Board gameBoard;
    private Player player1;
    private InteractivePlayer player2;
    
    /**
     * Game constructor
     */
    public Game(){
        gameBoard = new Board();
        player1 = new Player("X");
        player2 = new InteractivePlayer("O");
    }
    
    /**
     * Plays the game
     * While the game hasn't ended, it takes turns getting moves from each player
     * After each move, it will display the board
     * Once the game has ended, it will check which player has won or if nobody won
     * It then displays the outcome
     */
    public void play(){
        System.out.println("Welcome to Tic-Tac-Toe!");

        displayBoard();
        System.out.println("\n\n\n");

        boolean gameOver = false;
        while (!gameOver){
            // execute the user's turn
            int move1 = player1.getMove(gameBoard);
            gameBoard.makeMove(move1, player1.getSymbol());

            displayBoard();
            System.out.println("\n\n\n");

            gameOver = isGameOver();

            if (!gameOver){
                // execute the cpu's turn
                int move2 = player2.getMove(gameBoard);
                gameBoard.makeMove(move2, player2.getSymbol());

                displayBoard();
                System.out.println("\n\n\n");

                gameOver = isGameOver();
            }
        }
        System.out.println("Game over.");
        String winner = gameBoard.determineWinner();
        if (winner == "X") {
            System.out.println("X won!");
        } else if (winner == "O") {
            System.out.println("O won!");
        } else {
            System.out.println("Cat game.");
        }
    }
    
    /**
     * Displays the board
     */
    private void displayBoard(){
        String[][] board = gameBoard.getBoard();
        int size = gameBoard.getSize();
        String result = "";
        for (int row = 0; row < size; row++){
            for (int col = 0; col < size; col++){
                if (board[row][col] == null){
                    result += "   ";
                }
                else{ 
                    result += " " + board[row][col] + " ";
                }
                if (col < size-1){
                    result += "|";
                }
            }
            if (row < size-1){
                result += "\n-----------\n";
            }
        }
        System.out.println(result);
    }

    /**
     * Determines whether or not the game is over
     * @return boolean whether or not the game is over
     */
    private boolean isGameOver(){
        // two scenarios: either someone gets 3 in a row or the board fills up
        boolean fullBoard = gameBoard.isBoardFull();
        String winner = gameBoard.determineWinner();

        if (fullBoard || winner != null){
            return true;
        }
        else{
            return false;
        }
    }
}
