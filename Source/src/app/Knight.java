package app;

public class Knight extends Piece
{

	public Knight(int rowarg, int colarg, int colorarg)
	{
		super(rowarg,colarg,colorarg);
	}

	public boolean checkMove(int xarg, int yarg) 
	{
		row=yarg;
		col=xarg;
		return true;
	}
	
	public void killPiece()					//functionality of killing of a piece
	{
		
	}
	
	public void drawPiece()					//funtionality of drawing of the piece on canvas
	{
		
	}
}
