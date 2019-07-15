package app;

public class Pawn extends Piece 
{

	public Pawn(int rowarg, int colarg, int colorarg)
	{
		super(rowarg,colarg,colorarg);
	}

	public boolean checkMove(int xarg, int yarg)
    {
    	row=yarg;
    	col=xarg;
    	return true;
    }
	
	public void killPiece()						//functionality of killing of a piece
	{
									
	}
    public void drawPiece()						//functionality for drawing the piece on canvas
    {
    
    }

}
