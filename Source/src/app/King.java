package app;

public class King  extends Piece
{

	protected boolean checkmate;
	
	public King(int rowarg, int colarg, int colorarg) 
	{
		super(rowarg,colarg,colorarg);
	}
	
	King(King obj)
	{
		super(obj);			//copy constructor for class piece
	}
	
	public boolean checkMove(int xarg, int yarg, Board board) 
	{
		row=yarg;
		col=xarg;
		return true;
	}
		
	public void drawPiece() 				//funtionality for drawing the pieces on canvas
	{
		if(this.isdead)
		{
			System.out.print(" - ");
		}
		else if(this.color==0)			//0 is for Black
		{
			System.out.print("|k ");
		}
		else if(this.color==1)			// 1 is for White
		{
			System.out.print("|K ");
		}
		else
		{
			System.out.print(" ");		//in case of any errors
		}	
	}
	
}
