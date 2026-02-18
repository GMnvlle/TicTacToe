/**
 * Board class defines board as a 2D array
 * Determines the winner of a game
 * Takes inputted moves and assigns them to board
 * Determines whether or not the board is full, a spot is taken, and if a move is valid
 */
public class Board
{
    /**
     * Instance variables
     */
    String[][] board;
    private static final int SIZE = 3;
    
    /**
     * Board constructor
     */
    public Board(){
        board = new String[SIZE][SIZE];
    }
    
    /**
     * Accessor for the board
     * @return String[][] the current board being used
     */
    public String[][] getBoard(){
        return board;
    }
    
    /**
     * Acessor for the size of the board
     * (note that the board is SIZE*SIZE and not the SIZE itself)
     * @return int the size of the board
     */
    public int getSize(){
        return SIZE;
    }
    
    /**
     * Method that takes a move and assigns a symbol to the corresponding part of the board
     * @param move - the current player's move
     * @param symbol - the current player's assigned symbol
     */
    public void makeMove(int move, String symbol) {
        move--;
        int c=move/3;
        int r=move%3;
        board[c][r]=symbol;
    }
    
    /**
     * Determines the winner of the game
     * Checks all possible ways of winning and returns the winner's symbol
     * @return String the winner's symbol
     */
    public String determineWinner(){
        String winnerSymbol = null;
        for(int i=0;i<SIZE;i++){
            String start = board[i][0];
            if(start!=null){
                for(int j=1;j<SIZE;j++){
                    if(start.equals(board[i][j])){
                        winnerSymbol = board[i][j];
                    }
                    else{
                        winnerSymbol = null;
                    }
                }
            }
        }
        if(winnerSymbol==null){
            for(int i=0;i<SIZE;i++){
                String start = board[0][i];
                if(start!=null){
                    for(int j=1;j<SIZE;j++){
                        if(start.equals(board[j][i])){
                            winnerSymbol = board[j][i];
                        }
                        else{
                            winnerSymbol = null;
                        }
                    }
                }
            }
        }
        if(board[0][0]!=null&&winnerSymbol==null){
            boolean allMatch = true;
            for(int i=1;i<SIZE;i++){
                if(!board[0][0].equals(board[i][i])){
                    allMatch = false;
                }
            }
            if (allMatch){
                winnerSymbol = board[0][0];
            }
        }
        if(board[0][SIZE-1]!=null&&winnerSymbol==null){
            boolean allMatch = true;
            for(int i=1;i<SIZE;i++){
                if(!board[0][SIZE-1].equals(board[i][SIZE-1-i])){
                    allMatch = false;
                }
            }
            if (allMatch){
                winnerSymbol = board[0][SIZE-1];
            }
        }
        return winnerSymbol;
    }
    
    /**
     * Determines whether or not the board is full
     * @return boolean whether or not the board is full
     */
    public boolean isBoardFull() {
        for(String[] row:board){
            for(String s:row){
                if(s==null){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Determines whether or not the spot of the move has been taken
     * @return boolean whether or not the spot is taken
     */
    private boolean isSpotTaken(int move){
        move--;
        int c=move/3;
        int r=move%3;
        if(board[c][r]!=null){
            return true;
        }
        return false;
    }
    
    /**
     * Determines whether or not the player's move is valid
     * It has to be between 1 and the size of the board and the spot can't be taken
     * @return boolean whether or not the move is valid
     */
    public boolean isValidMove(int move){
        if(move>=1&&move<=SIZE*SIZE&&!isSpotTaken(move)){
            return true;
        }
        return false;
    }
}
