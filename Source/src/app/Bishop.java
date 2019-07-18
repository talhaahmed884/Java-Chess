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
		if(rowarg>=0 && rowarg<=7 && colarg>=0 && colarg<=7)
		{
			int temp1=row,temp2=col;
			boolean check=false;
			if(rowarg>row)		//for forward movement
			{
				if(colarg>col)		//for right movement
				{
					for(;temp1<=rowarg && temp2<=colarg;temp1++,temp2++)		//checking for the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)		//if path is true
						{
							check=true;
						}
						else if(temp1==rowarg && temp2!=colarg || temp1!=rowarg && temp2==colarg)		//false path condition
						{
							return false;
						}
						else		//checking the path is empty
						{
							continue;
						}
					}
					int temp3=row+1,temp4=col+1;
					for(;temp3<rowarg && temp4<colarg;temp3++,temp4++)
					{
						if(board.pieces[row][col]==board.pieces[temp3][temp4])
						{
							continue;
						}
						else if(board.pieces[temp3][temp4]!=null)
						{
							check=false;
						}
						else
						{
							continue;
						}
					}
				}
				else if(colarg<col)		//for left movement
				{
					for(;temp1<=rowarg && temp2>=colarg;temp1++,temp2--)		//checking for the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)		//if path is true
						{
							check=true;
						}
						else if(temp1==rowarg && temp2!=colarg || temp1!=rowarg && temp2==colarg)		//false path condition
						{
							return false;
						}
						else
						{
							continue;
						}
					}
					int temp3=row+1,temp4=col+1;
					for(;temp3<rowarg && temp4>colarg;temp3++,temp4--)
					{
						if(board.pieces[row][col]==board.pieces[temp3][temp4])
						{
							continue;
						}
						else if(board.pieces[temp3][temp4]!=null)
						{
							check=false;
						}
						else
						{
							continue;
						}
					}
				}
			}
			else if(rowarg<row)		//for backward movement
			{
				if(colarg>col)		//for right movement
				{
					for(;temp1>=rowarg && temp2<=colarg;temp1--,temp2++)		//checking for the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)		//if path is true
						{
							check=true;
						}
						else if(temp1==rowarg && temp2!=colarg || temp1!=rowarg && temp2==colarg)		//false path condition
						{
							return false;
						}
						else		//checking the path is empty
						{
							continue;
						}
					}
					int temp3=row,temp4=col;
					for(;temp3>rowarg && temp4<colarg;temp3--,temp4++)
					{
						if(board.pieces[row][col]==board.pieces[temp3][temp4])
						{
							continue;
						}
						else if(board.pieces[temp3][temp4]!=null)
						{
							check=false;
						}
						else
						{
							continue;
						}
					}
				}
				else if(colarg<col)		//for left movement
				{
					for(;temp1>=rowarg && temp2>=colarg;temp1--,temp2--)		//checking for the validity of the moves
					{
						if(temp1==rowarg && temp2==colarg)		//if path is true
						{
							check=true;
						}
						else if(temp1==rowarg && temp2!=colarg || temp1!=rowarg && temp2==colarg)		//false path condition
						{
							return false;
						}
						else
						{
							continue;
						}
					}
					int temp3=row,temp4=col;
					for(;temp3>rowarg && temp4>colarg;temp3--,temp4--)
					{
						if(board.pieces[row][col]==board.pieces[temp3][temp4])
						{
							continue;
						}
						else if(board.pieces[temp3][temp4]!=null)
						{
							check=false;
						}
						else
						{
							continue;
						}
					}
				}
			}
			else		//in case of any unexpected error/condition
			{
				return false;
			}
			if(check==true)
			{
				if(board.pieces[rowarg][colarg]==null)		//empty space
				{
					return true;
				}
				else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color==board.pieces[row][col].color)	//same team piece
				{
					return false;
				}
				else if(board.pieces[rowarg][colarg]!=null && board.pieces[rowarg][colarg].color!=board.pieces[row][col].color)		//opponent team piece
				{
					return true;
				}
				else		//in case of any unexpected error/condition
				{
					return false;
				}
			}
			else		//in case of any unexpected condition/error
			{
				return false;
			}
		}
		else	//in case of values out of bounds of the board
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