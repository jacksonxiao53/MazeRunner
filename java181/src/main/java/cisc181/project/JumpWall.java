package cisc181.project;

public class JumpWall implements Action<MazeTypeGame> {
    private PlayerPiece player;
    private int row;
    private int col;
    public JumpWall (PlayerPiece player, int row, int col) {
        this.player = player;
        this.row = row;
        this.col = col;
    }
    //three getter methods
    //no input parameter and return each field
        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
        public PlayerPiece getPlayer(){
            return player;
    }


    public boolean isValid(MazeTypeGame game) {
        if ((player.getRow() == row+1 || player.getRow() == row-1 || player.getRow() == row) && ( player.getCol() == col+1 || player.getCol() == col-1 || player.getCol() == col)) {
            if (row == 0 && col == 3) {
                return true;
            } else {
                return game.getGameBoard().isInBounds(row, col) &&
                        game.getTurnPlayer() == player &&
                        game.getGameBoard().getPiece(row, col).equals(new GamePiece('X')) &&
                        player.getJumpPiece().getQuantity() >= 1;
            }
        }
        else{
            return false;
        }
    }

    //update the game when a player place a piece on the board
    //change the turn
    //take in a TicTacToeTypeGame game, return nothing
    public void update(MazeTypeGame game) {
        player.getJumpPiece().setQuantity(-1);
        game.setPiece(row, col, player);
        game.changeTurn();
        game.setRound(0.5);


    }
    @Override
    public String toString() {
        int quantity = player.getJumpPiece().getQuantity();
        return ("Player " + player +" moved his piece to "+ row +"," +col + " and has " + quantity + " jump pieces left.");
    }
}
