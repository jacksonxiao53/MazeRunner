package cisc181.project;

public class GamePiece {
    protected static final char EMPTY = 'E';
    protected static final char WALL = 'X';
    protected static final char FINISH_LINE = 'F';
    protected static final char JUMP = 'J';
    private char symbol;
    protected int row;
    protected int col;
    protected JumpPiece jumpPiece;

    // Constructor that has one parameter and sets the symbol
    public GamePiece(char symbol) {
        this.symbol = symbol;
    }

    // Method that returns symbol
    public char getSymbol() {
        return symbol;
    }

    // Method that returns a boolean representing whether the game piece is empty
    public boolean isEmpty() {
        if (symbol == 'E') {
            return true;
        } else {
            return false;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }

    //Overriding the toString method
    @Override
    public String toString() {
        return (Character.toString(symbol));
    }

    //Overriding the equals method and returns true if symbols are the same
    public boolean equals(GamePiece otherGamePiece) {
        return (this.symbol == otherGamePiece.symbol);
    }

    public JumpPiece getJumpPiece() {
        return jumpPiece;
    }
}
