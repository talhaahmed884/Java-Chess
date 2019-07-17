package app;

public class Bishop extends Piece
{	
	public Bishop(int rowarg, int colarg, int colorarg) 
	{
		super(rowarg,colarg,colorarg);
	}
	
	Bishop(Bishop obj)
	{
		super(obj);			//copy constructor for class piece
	}
	
	public boolean checkMove(int rowarg, int colarg, Board board) 
	{
		if(color==0)		//for black pieces small b
		{
			if(rowarg>row && rowarg<=7)			//for forward movement
			{
				if(colarg>col && colarg<=7)		//for right movement
				{
					int temp1=row,temp2=col;
					for(;temp1<=rowarg && temp2<=colarg;temp1++,temp2++)	// for checking validity of move
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for opponent piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)
						{
							return false;
						}
						else		//in case of unknown condition
						{
							continue;
						}
					}
				}
				else if(colarg<col && colarg>=0)		//for left movement
				{
					int temp1=row,temp2=col;
					for(;temp1<=rowarg && temp2>=colarg;temp1++,temp2--)	// for checking validity of move
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for opponent piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)		//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)		//false move
						{
							return false;
						}
						else		//in case of unknown condition
						{
							continue;
						}
					}
				}
				else			//in case of values out of bounds of the board
				{
					return false;
				}
			}
			else if(rowarg<row && rowarg>=0)		//for backward movement
			{
				if(colarg>col && colarg<=7)		//for right movement
				{
					int temp1=row,temp2=col;
					for(;temp1>=rowarg && temp2<=colarg;temp1--,temp2++)	//for checking the validity of move
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for same team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for opponent team piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)			//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)			//false move
						{
							return false;
						}
						else			// for unknown condition occurrence
						{
							continue;
						}
					}
				}
				else if(colarg<col && colarg>=0)		//for left movement
				{
					int temp1=row,temp2=col;
					for(;temp1>=rowarg && temp2>=colarg;temp1--,temp2--)	//for checking the validity of move
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for same team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for opponent team piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)			//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)			//false move
						{
							return false;
						}
						else			// for unknown condition occurrence
						{
							continue;
						}
					}
				}
				else			//in case of values out of bounds of the board
				{
					return false;
				}
			}
			else		//in case values out of bounds of the board
			{
				return false;
			}
		}
		else if(color==1)		//for white pieces large B
		{
			if(rowarg<row && rowarg>=0)		//for forward movement
			{
				if(colarg>col && colarg<=7)	//for right movement
				{
					int temp1=row,temp2=col;
					for(;temp1>=rowarg && temp2<=colarg;temp1--,temp2++)	//for checking the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for same team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for opponent team piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)		//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)		//false move
						{
							return false;
						}
						else		//in case of any unknown condition
						{
							continue;
						}
					}
				}
				else if(colarg<col && colarg>=0)		//for left movement
				{
					int temp1=row,temp2=col;
					for(;temp1>=rowarg && temp2>=colarg;temp1--,temp2--)	//for checking the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for same team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for opponent team piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)		//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)		//false move
						{
							return false;
						}
						else		//in case of any unknown condition
						{
							continue;
						}
					}
				}
				else			//in case of values out of bounds of the board
				{
					return false;
				}
			}
			else if(rowarg>row && rowarg<=7)		//for backward movement
			{
				if(colarg>col && colarg<=7)		//for right movement
				{
					int temp1=row,temp2=col;
					for(;temp1<=rowarg && temp2<=colarg;temp1++,temp2++)	//for checking the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for same team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for opponent team piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)		//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)		//false move
						{
							return false;
						}
						else		//in case of any unknown condition
						{
							continue;
						}
					}
				}
				else if(colarg<col && colarg>=0)		//for left movement
				{
					int temp1=row,temp2=col;
					for(;temp1<=rowarg && temp2>=colarg;temp1++,temp2--)	//for checking the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)
						{
							if(board.pieces[rowarg][colarg]==null)
							{
								return true;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==1)	//for same team piece
							{
								return false;
							}
							else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==0)	//for opponent team piece
							{
								return true;
							}
						}
						else if(temp1==rowarg && temp2!=colarg)		//false move
						{
							return false;
						}
						else if(temp1!=rowarg && temp2==colarg)		//false move
						{
							return false;
						}
						else		//in case of any unknown condition
						{
							continue;
						}
					}
				}
				else			//in case of values out of bounds of the board
				{
					return false;
				}
			}
			else			//in case of values out of bounds of the board
			{
				return false;
			}
		}
		return false;			//in case of any errors
	}
	public void drawPiece()
	{
		if(this.isdead)
		{
			System.out.print(" - ");
		}
		else if(this.color==0)			//0 is for Black
		{
			System.out.print(" b ");
		}
		else if(this.color==1)			// 1 is for White
		{
			System.out.print(" B ");
		}
		else
		{
			System.out.print(" ");		//in case of any errors
		}
	}
}
