package cisc181.project;

public class PlayerPiece extends GamePiece {
    private JumpPiece jumpPiece;
    private boolean isWinner;

    public PlayerPiece(char symbol) {
        super(symbol);
        jumpPiece = new JumpPiece();
        isWinner = false;
    }

    public boolean getIsWinner() {
        return isWinner;
    }

    // Sets isWinner
    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }


    public JumpPiece getJumpPiece() {
        return jumpPiece;
    }
}

