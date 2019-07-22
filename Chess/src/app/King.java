package app;

public class King  extends Piece
{
	protected boolean checkmate;
	
	public King(int rowarg, int colarg, int colorarg) 
	{
		super(rowarg,colarg,colorarg);
		
		if(colorarg == 0)
        loadSprite(DEFAULTfp + KINGfn[0]);
        
        else if(colorarg == 1)
        loadSprite(DEFAULTfp + KINGfn[1]);
	}
	
	King(King obj)
	{
		super(obj);			//copy constructor for class piece
	}
	
	public boolean checkMove(int rowarg, int colarg, Board board) 
	{
		if(rowarg>=0 && rowarg<=7 && colarg>=0 && colarg<=7)
		{
			if(Math.abs(row-rowarg)==1 && col==colarg || Math.abs(col-colarg)==1 && row==rowarg)
			{
				if(board.pieces[rowarg][colarg]==null)		//empty space
				{
					return true;
				}
				else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==board.pieces[row][col].color)			//same team piece
				{
					return false;
				}
				else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color!=board.pieces[row][col].color)			//opponent team piece
				{
					return true;
				}
				else		//in case of unexpected condition/error
				{
					return false;
				}
			}
			else		//in case of unexpected condition/error
			{
				return false;
			}
		}
		else		//in case of any unexpected condition/error
		{
			return false;
		}
	}	
	
	public boolean isUnderCheck(Board board){
		
		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				if (board.pieces[k][l] != null) {
					if (board.pieces[k][l].color != this.color) {
						if (board.pieces[k][l].checkMove(this.row , this.col, board)) {
							return true;
						}
					}
				}
			}
		}
										
		return false;
	}
	
}