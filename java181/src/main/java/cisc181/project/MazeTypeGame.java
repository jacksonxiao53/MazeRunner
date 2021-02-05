package cisc181.project;
import java.lang.Math;
public class MazeTypeGame extends Game {
    private GameBoard newBoard;
    private PlayerPiece turnPlayer;
    private PlayerPiece notTurnPlayer;
    private double round;

    //Constructor that accepts newBoard, turnSymbol, and notTurnSymbol
    public MazeTypeGame(){
        newBoard = new GameBoard();
        turnPlayer = new PlayerPiece('1');
        notTurnPlayer = new PlayerPiece('2');
        round = 1.0;
    }

    //Return the game board
    public GameBoard getGameBoard() {
        return newBoard;
    }

    // Return turnPlayer
    public PlayerPiece getTurnPlayer() {
        return turnPlayer;
    }

    // Return notTurnPlayer
    public PlayerPiece getNotTurnPlayer() {
        return notTurnPlayer;
    }

    //Sets the game board
    public void setGameBoard(GameBoard gameBoard) {
        this.newBoard = gameBoard;
    }
    // Sets turnPlayer
    public void setTurnPlayer(PlayerPiece turnPlayer){
        this.turnPlayer = turnPlayer;
    }

    //Sets notTurnPlayer
    public void setNotTurnPlayer(PlayerPiece notTurnPlayer){
        this.notTurnPlayer = notTurnPlayer;
    }
    //Returns round
    public double getRound() {
        return round;
    }

    //Sets round
    public void setRound(double update) {
        this.round += update;
    }


    public void changeTurn() {
        PlayerPiece current = turnPlayer;
        turnPlayer = notTurnPlayer;
        notTurnPlayer = current;
    }

    public void setPiece(int newRow, int newCol, PlayerPiece piece) {
        char[][] baseBoard = {
                {'E', 'E', 'E', 'F', 'E', 'E', 'E'},
                {'X', 'X', 'E', 'E', 'E', 'X', 'X'},
                {'E', 'J', 'E', 'X', 'E', 'J', 'E'},
                {'X', 'E', 'X', 'E', 'X', 'E', 'X'},
                {'X', 'E', 'X', 'E', 'X', 'E', 'X'},
                {'E', 'X', 'E', 'X', 'E', 'X', 'E'},
                {'X', '1', 'X', 'X', 'X', '2', 'X'}
        };
        int currentRow = piece.getRow();
        int currentCol = piece.getCol();
        newBoard.setPiece(newRow,newCol,piece);
        if (baseBoard[currentRow][currentCol] == 'X'){
            newBoard.setPiece(currentRow, currentCol, new GamePiece('X'));
        }
        else{
            newBoard.setPiece(currentRow, currentCol, new GamePiece('E'));
        }
        piece.setRow(newRow);
        piece.setCol(newCol);
        if (baseBoard[newRow][newCol] == 'J'){
            piece.getJumpPiece().setQuantity(1);
            System.out.println("You gained one extra jump piece!");
        }
    }

    public boolean isWinner(PlayerPiece piece) {
        if (newBoard.getPiece(0, 3).equals(piece)) {
            piece.setIsWinner(true);
            return true;
        } else {
            return false;
        }
    }


    public boolean isEnd() {
        if (isWinner(turnPlayer) || isWinner(notTurnPlayer) && (round % 1 == 0.0)) {
            return true;
        } else {
            return false;
        }
    }

    public String getStatus() {
        if (isEnd()) {
            if (turnPlayer.getIsWinner() == true && notTurnPlayer.getIsWinner() == true) {
                return "It is a draw!";
            }
            else if (isWinner(turnPlayer)){
                return "Player " + turnPlayer.getSymbol() + " wins!";
            } else {
                return "Player " + notTurnPlayer.getSymbol() + " wins!";
            }
        } else {
            return "\nPlayer " + turnPlayer.getSymbol() + "'s turn\n";
        }
    }

    public int randomRowChange(){
        int randomRow = (int)(Math.random()*7);
        return randomRow;
    }

    public int randomColumnChange(){
        int randomColumn = (int)(Math.random()*7);
        return randomColumn;
    }



    @Override
    public String toString() {
        String status =   newBoard.toString();
        status += "\n" + getStatus();
        return status;
    }

}

