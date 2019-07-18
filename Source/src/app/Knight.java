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
	
	public boolean checkMove(int rowarg, int colarg, Board board) 
	{
		if(rowarg>=0 && rowarg<=7 && colarg>=0 && colarg<=7)
		{
			if(Math.abs(rowarg-row)==2 && Math.abs(colarg-col)==1)
			{
				if(rowarg>row)	//for forward movement
				{
					int temp1=row;
					for(;temp1<rowarg;temp1++)		//for checking the path
					{
						if(board.pieces[temp1][col]!=null)
						{
							return false;
						}
					}
				}
				else if(rowarg<row)		//for backward movement
				{
					int temp1=row;
					for(;temp1>=rowarg;temp1--)		//for checking the path
					{
						if(board.pieces[temp1][col]!=null)
						{
							return false;
						}
					}
				}
				else		//in case of any unexpected error/condition
				{
					return false;
				}
				if(board.pieces[rowarg][colarg]==null)		//for empty space
				{
					return true;
				}
				else if(board.pieces[rowarg][colarg]!=null && board.pieces[row][col].color==board.pieces[rowarg][colarg].color)		//for same team piece
				{
					return false;
				}
				else if(board.pieces[rowarg][colarg]!=null && board.pieces[row][col].color!=board.pieces[rowarg][colarg].color)		//for opponent team piece
				{
					return true;
				}
				else		//in case of any unexpected condition/error
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
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
