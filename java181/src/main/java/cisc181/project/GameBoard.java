package cisc181.project;

public class GameBoard {
    //set up fields
    private GamePiece[][] gameBoard;
    //constructor, build the already set up board
    public GameBoard(){
        gameBoard = new GamePiece[7][7];
        // iterate over the entire array and assign a new EMPTY gamepiece to each space
        for (int row =0; row < gameBoard.length; row++){
            for (int col = 0; col < gameBoard[row].length; col++){
                gameBoard[row][col] = new GamePiece(GamePiece.EMPTY);
            }
        }
        //set up the wall pieces
        for (int col = 0; col<gameBoard[0].length;col++){
            gameBoard[6][col] = new GamePiece(GamePiece.WALL);
        }
        for (int col = 1; col<gameBoard[0].length;col=col+2){
            gameBoard[5][col] = new GamePiece(GamePiece.WALL);
        }
        for (int col = 0; col<gameBoard[0].length;col=col+2){
            gameBoard[4][col] = new GamePiece(GamePiece.WALL);
        }
        for (int col = 0; col<gameBoard[0].length;col=col+2){
            gameBoard[3][col] = new GamePiece(GamePiece.WALL);
        }
        for (int col = 1; col<gameBoard[0].length;col=col+2){
            gameBoard[2][col] = new GamePiece(GamePiece.JUMP);//jump piece
        }
        gameBoard[2][3] = new GamePiece(GamePiece.WALL);
        gameBoard[1][0] = new GamePiece(GamePiece.WALL);
        gameBoard[1][1] = new GamePiece(GamePiece.WALL);
        gameBoard[1][5] = new GamePiece(GamePiece.WALL);
        gameBoard[1][6] = new GamePiece(GamePiece.WALL);
        gameBoard[0][3] = new GamePiece(GamePiece.FINISH_LINE); //finish line
        //playerPiece
        gameBoard[6][1] = new PlayerPiece('1');
        gameBoard[6][5] = new PlayerPiece('2');
    }
    //a getter method
    //no input, return a board (2D array)
    public GamePiece[][] getBoard(){return gameBoard;}
    //get the GamePiece object on the board at specific location
    //input the index of row and col
    //return the GamePiece object on that location
    public GamePiece getPiece(int rowNum, int colNum){
        return gameBoard[rowNum][colNum];
    }
    //set a GamePiece object on the bord at specific location
    //input the index of row and col and the symbol
    //no return
    public void setPiece (int rowNum, int colNum, GamePiece symbol){
        gameBoard[rowNum][colNum]=symbol;
    }
    //check if the location is on the board
    public boolean isInBounds(int row, int column) {
        return row >= 0 && column >= 0 &&
                row < getBoard().length &&
                column < getBoard()[row].length;
    }
    //printout the board
    public void printBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print("" + gameBoard[i][j].getSymbol() + '\t');
            }
            System.out.println();
        }
    }
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                buffer.append(gameBoard[i][j] + " ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

}




