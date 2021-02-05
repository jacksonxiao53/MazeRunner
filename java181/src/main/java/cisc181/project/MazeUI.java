package cisc181.project;
import java.util.Scanner;

public class MazeUI implements UserInput<MazeTypeGame> {
    private MazeTypeGame game;

    public MazeUI() {
        game = new MazeTypeGame();
    }

    public MazeTypeGame getGame() {
        return game;
    }

    public MovePieceByOne getUserNextMove(MazeTypeGame game) {
        Scanner scr = new Scanner(System.in);
        boolean validMove = false;
        MovePieceByOne move = null;
        int row;
        int col;

        while (!validMove) {
            System.out.println("Enter row index of your next move ");
            row = scr.nextInt();
            System.out.println("Enter column index of your next move:");
            col = scr.nextInt();
            move = new MovePieceByOne(game.getTurnPlayer(), row, col);
            validMove = move.isValid(game);
            if (!validMove) {
                System.out.println("Invalid Move - try again");
            }
        }
        return move;
    }

    public JumpWall getUserNextJump(MazeTypeGame game) {
        Scanner scr = new Scanner(System.in);
        boolean validMove = false;
        JumpWall move = null;
        int row;
        int col;
        while (!validMove) {
            System.out.println("Enter row index of your next jump:");
            row = scr.nextInt();
            System.out.println("Enter column index of your next jump:");
            col = scr.nextInt();
            move = new JumpWall(game.getTurnPlayer(), row, col);
            validMove = move.isValid(game);
            if (!validMove) {
                System.out.println("Invalid Move - try again");
            }
        }
        return move;
    }

    public static void main(String args[]) {
        MazeUI mazeRunner = new MazeUI();
        boolean gameEnded = false;
        MovePieceByOne nextMove;
        JumpWall nextJump;
        mazeRunner.getGame().getTurnPlayer().setRow(6);
        mazeRunner.getGame().getTurnPlayer().setCol(1);
        mazeRunner.getGame().getNotTurnPlayer().setRow(6);
        mazeRunner.getGame().getNotTurnPlayer().setCol(5);
        String jump;
        int randomRow;
        int randomCol;
        Scanner scnr = new Scanner(System.in);
        double round = mazeRunner.getGame().getRound();
        while (!mazeRunner.getGame().isEnd()) {
            randomRow = mazeRunner.getGame().randomRowChange();
            randomCol = mazeRunner.getGame().randomColumnChange();
            while (!mazeRunner.getGame().getGameBoard().getPiece(randomRow, randomCol).equals(new GamePiece('E'))) {
                randomRow = mazeRunner.getGame().randomRowChange();
                randomCol = mazeRunner.getGame().randomColumnChange();
            }
            mazeRunner.getGame().getGameBoard().setPiece(randomRow, randomCol, new GamePiece('X'));
            System.out.println("Placing random wall on row " + randomRow + " and column " + randomCol);
            // print status of game
            System.out.println(mazeRunner.getGame());
            if(mazeRunner.getGame().getTurnPlayer().getJumpPiece().getQuantity() >= 1){
                System.out.println("Do you want to jump? (yes or no)");
                jump = scnr.nextLine();
            }
            else{
                jump = "no";
            }

            if (jump.equals("no")) {
                // get the next move from the user
                nextMove = mazeRunner.getUserNextMove(mazeRunner.getGame());
                // print the next move
                System.out.println(nextMove);
                // perform the next move
                mazeRunner.getGame().performAction(nextMove);
            } else if (jump.equals("yes")) {
                nextJump = mazeRunner.getUserNextJump(mazeRunner.getGame());
                mazeRunner.getGame().performAction(nextJump);
                System.out.println(nextJump);
            } else {
                System.out.println("Invalid Move - try again");

            }
            System.out.println("Row: " + randomRow + " and column: " + randomCol + " is back to empty");
            if (!mazeRunner.getGame().getGameBoard().getPiece(randomRow,randomCol).equals(mazeRunner.game.getNotTurnPlayer())){
                mazeRunner.getGame().getGameBoard().setPiece(randomRow,randomCol,new GamePiece('E'));
            }
            mazeRunner.getGame().isWinner(mazeRunner.getGame().getNotTurnPlayer());
        }
        System.out.println(mazeRunner.getGame());
    }

}














