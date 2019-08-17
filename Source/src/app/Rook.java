package app1;



public class Rook extends Piece
{

	public Rook(int rowarg, int colarg, int colorarg)
	{
		super(rowarg,colarg,colorarg);

		if(colorarg == 0)
        loadSprite(DEFAULTfp + ROOKfn[0]);
        
        else if(colorarg == 1)
        loadSprite(DEFAULTfp + ROOKfn[1]);
	}
	
	Rook(Rook obj)
	{
		super(obj);			//Copy constructor for class piece
	}
	
	public boolean checkMove(int rowarg, int colarg, Board board) 
	{
		
		if(rowarg>row && colarg==col && rowarg<=7)		//for forward movement
		{
			int temp1=row+1;
			for(;temp1<rowarg;temp1++)		//for checking the path
			{
				if(board.pieces[temp1][col]!=null)
				{
					return false;
				}
			}
			if(board.pieces[rowarg][colarg]==null)		//empty space
			{
				return true;
			}
			else if(board.pieces[rowarg][colarg]!=null && board.pieces[row][col].color==board.pieces[rowarg][colarg].color)		//same team piece
			{
				return false;
			}
			else if(board.pieces[rowarg][colarg]!=null && board.pieces[row][col].color!=board.pieces[rowarg][colarg].color)		//opponent team piece
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(rowarg<row && colarg==col && rowarg>=0)		//for backward movement
		{
			int temp1=row-1;
			for(;temp1>rowarg;temp1--)		//for checking the path
			{
				if(board.pieces[temp1][col]!=null)
				{
					return false;
				}
			}
			if(board.pieces[rowarg][colarg]==null)		//empty space
			{
				return true;
			}
			else if(board.pieces[rowarg][colarg]!=null && board.pieces[row][col].color==board.pieces[rowarg][colarg].color)		//same team piece
			{
				return false;
			}
			else if(board.pieces[rowarg][colarg]!=null && board.pieces[row][col].color!=board.pieces[rowarg][colarg].color)		//opponent team piece
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(rowarg==row && colarg>col && colarg<=7)		//for right movement
		{
			int temp1=col+1;
			for(;temp1<colarg;temp1++)		//for checking the path
			{
				if(board.pieces[row][temp1]!=null)
				{
					return false;
				}
			}
			if(board.pieces[rowarg][colarg]==null)		//empty space
			{
				return true;
			}
			else if(board.pieces[row][colarg]!=null && board.pieces[row][col].color==board.pieces[rowarg][colarg].color)	//same team piece
			{
				return false;
			}
			else if(board.pieces[row][colarg]!=null && board.pieces[row][col].color!=board.pieces[rowarg][colarg].color)	//opponent team piece
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else if(rowarg==row && colarg<col && colarg>=0)		//for left movement
		{
			int temp1=col-1;
			for(;temp1>colarg;temp1--)		//for checking the path
			{
				if(board.pieces[row][temp1]!=null)
				{
					return false;
				}
			}
			if(board.pieces[row][colarg]==null)			//empty space
			{
				return true;
			}
			else if(board.pieces[row][colarg]!=null && board.pieces[row][col].color==board.pieces[row][colarg].color)		//for same team piece
			{
				return false;
			}
			else if(board.pieces[row][colarg]!=null && board.pieces[row][col].color!=board.pieces[row][colarg].color)		//for opponent team piece
			{
				return true;
			}
			else
			{
				return false;
			}

		}
		else		//in case of values out of bounds of the board
		{
			return false;
		}
	}

}
