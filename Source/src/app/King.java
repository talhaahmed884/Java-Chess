package app;

public class King  extends Piece
{

	public King(int rowarg, int colarg, int colorarg) 
	{
		super(rowarg,colarg,colorarg);
	}
	
	public boolean checkMove(int xarg, int yarg) 
	{
		row=yarg;
		col=xarg;
		return true;
	}
	
	public void killPiece() 				//funtionality for killing of the piece
	{
		
	}
	
	public void drawPiece() 				//funtionality for drawing the pieces on canvas
	{
		
	}
	
}
