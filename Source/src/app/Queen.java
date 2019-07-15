package app;

public class Queen extends Piece
{

	public Queen(int rowarg, int colarg, int colorarg) 
	{
		super(rowarg,colarg,colorarg);
	}
	
	public boolean checkMove(int xarg, int yarg) 
	{
		row=yarg;
		col=xarg;
		return true;
	}
	
	public void drawPiece()					//functionality of drawing of a piece on canvas
	{
		
	}
	
	public void killPiece()					//functionality for drawing the piece on canvas
	{
		
	}
}
