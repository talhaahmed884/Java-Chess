package app;

public abstract class Piece {
    
    protected boolean isdead;                   // FOR KILLED PIECES
    protected int row, col;                         // BOARD POSITIONS x == columns and y == rows
    public int color;                           // 0 FOR BLACK && 1 FOR WHITE

    public Piece(int rowarg, int colarg, int colorarg)          // PARAMETERIZED
    {
        this.row = rowarg;
        this.col = colarg;
        this.color = colorarg;
    }

    public Piece(Piece obj)                                 // COPY
    {
        this.row = obj.row;
        this.col = obj.col;
        this.color = obj.color;
    }

    public void killPiece()                                                 
    {
        this.isdead = true;
    }

    public abstract boolean checkMove(int xarg, int yarg, Board board);
    
    public abstract void drawPiece();

}