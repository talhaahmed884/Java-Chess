package app;

import java.awt.Graphics;

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
	public void drawPiece(Graphics g) 				//Functionality for drawing the pieces on canvas
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