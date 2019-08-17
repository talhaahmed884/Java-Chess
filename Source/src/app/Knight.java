package app1;


public class Knight extends Piece
{

	public Knight(int rowarg, int colarg, int colorarg)
	{
		super(rowarg,colarg,colorarg);

		if(colorarg == 0)
        loadSprite(DEFAULTfp + KNIGHTfn[0]);
        
        else if(colorarg == 1)
        loadSprite(DEFAULTfp + KNIGHTfn[1]);
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
		 	else if(Math.abs(rowarg-row)==1 && Math.abs(colarg-col)==2)
		 	{
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
}
		
	
