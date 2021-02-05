package cisc181.project;

public class JumpPiece extends GamePiece {
    private int quantity;
    // Constructor
    public JumpPiece(){
        super('J');
        quantity = 1;
    }
    // Returns quantity
    public int getQuantity(){
        return quantity;
    }
    // Sets quantity
    public void setQuantity(int count){
        this.quantity = quantity + count;
    }




}
