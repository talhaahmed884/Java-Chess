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
	
	public boolean checkMove(int xarg, int yarg, Board board) 
	{
		if(this.color==0)
		{
			
			/*for(int a=row,b=col;a>=xarg && b<=yarg;)
			{
				a-=1;b+=1;
				if(a==xarg && b==yarg)
				{
					for(int c=row,d=col;c>=xarg && d<=yarg;)
					{
						c-=1;d+=1;
						if(board.pieces[c][d]!=null && board.pieces[c][d].color==0)
						{
							return false;
						}
						else if(board.pieces[c][d]!=null && board.pieces[c][d].color==1)
						{
							board.pieces[c][d].isdead=true;
						}
					}
					return true;
				}*/
			}
			
			
			/*if(board.pieces[xarg][yarg]==null)
			{
				
			}
			else
			{
				return false;
			}*/
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
