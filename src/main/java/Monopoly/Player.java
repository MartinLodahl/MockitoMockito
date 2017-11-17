package Monopoly;

public class Player
{
    private int fvTot;
    private IDie die1, die2;
    private ISquare oldLoc, newLoc;
    private IPiece piece;
    private IBoard board;
    
    
    public Player(IDie die1, IDie die2, IPiece piece, IBoard board)
    {
        this.die1 = die1;
        this.die2 = die2;
        this.piece = piece;
        this.board = board;
    }
    
    public void takeTurn()
    {
        fvTot = 0;
        die1.roll();
        fvTot += die1.getFaceValue();
        die2.roll();
        fvTot += die2.getFaceValue();
        oldLoc = piece.getLocation();
        newLoc = board.getSquare(oldLoc, fvTot);
        piece.setLocation(newLoc);
    }
}
