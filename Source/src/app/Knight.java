package app;

public class Knight extends Piece
{

	public Knight(int rowarg, int colarg, int colorarg)
	{
		super(rowarg,colarg,colorarg);
	}
	
	public Knight(Knight obj)
	{
		super(obj);			//copy constructor for class piece
	}
	
	public boolean checkMove(int xarg, int yarg, Board board) 
	{
		row=yarg;
		col=xarg;
		return true;
	}
		
	public void drawPiece()
	{
		if(this.isdead)
		{
			System.out.print(" - ");
		}
		else if(this.color==0)			//0 is for Black
		{
			System.out.print(" k ");
		}
		else if(this.color==1)			// 1 is for White
		{
			System.out.print(" K ");
		}
		else
		{
			System.out.print(" ");		//in case of any errors
		}
	}
}
