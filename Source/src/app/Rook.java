package app;

public class Rook extends Piece
{

	public Rook(int rowarg, int colarg, int colorarg)
	{
		super(rowarg,colarg,colorarg);
	}
	
	Rook(Rook obj)
	{
		super(obj);			//Copy constructor for class piece
	}
	
	public boolean checkMove(int xarg, int yarg, Board board) 
	{
		return false;		//in case of any errors
	}
	
	public void drawPiece()
	{
		if(this.isdead)
		{
			System.out.print(" - ");
		}
		else if(this.color==0)			//0 is for Black
		{
			System.out.print(" r ");
		}
		else if(this.color==1)			// 1 is for White
		{
			System.out.print(" R ");
		}
		else
		{
			System.out.print(" ");		//in case of any errors
		}
	}
	
}
