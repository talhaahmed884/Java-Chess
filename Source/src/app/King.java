package app1;

import java.awt.Graphics;
import java.io.IOException;

public class King extends Piece
{
	protected boolean checkmate;
	Sprite redsprite;
	public boolean isUnderCheck;
    Sprite whitecheckmate;
    Sprite blackcheckmate;

	
	public King(int rowarg, int colarg, int colorarg) 
	{
		super(rowarg,colarg,colorarg);
		
		if(colorarg == 0){
		loadSprite(DEFAULTfp + KINGfn[0]);

		try {
			redsprite = new Sprite(DEFAULTfp + KINGfn[2]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int x_offset = col * Game.square_size + 135;
		int y_offset = row * Game.square_size + 57;
		int boardlength =  Game.square_size;

		redsprite.move(x_offset , y_offset);
		redsprite.setScale(boardlength, boardlength);
		redsprite.setVisibility(true);
		}
        
        else if(colorarg == 1){
		loadSprite(DEFAULTfp + KINGfn[1]);
		
		try {
			redsprite = new Sprite(DEFAULTfp + KINGfn[3]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		int x_offset = col * Game.square_size + 135;
		int y_offset = row * Game.square_size + 57;
		int boardlength =  Game.square_size;

		redsprite.move(x_offset , y_offset);
		redsprite.setScale(boardlength, boardlength);
		redsprite.setVisibility(true);
		}
	}
	
	King(King obj)
	{
		super(obj);			//copy constructor for class piece
	}
	
	public boolean checkMove(int rowarg, int colarg, Board board) 
	{	
		
		if(rowarg>=0 && rowarg<=7 && colarg>=0 && colarg<=7)
		{
			if(Math.abs(row-rowarg)==1 && col==colarg || Math.abs(col-colarg)==1 && row==rowarg || Math.abs(row-rowarg)==1 && Math.abs(col-colarg)==1)
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
	
	public int handleCheck(Board board){
		
		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				if (board.pieces[k][l] != null) {
					if (board.pieces[k][l].color != this.color) {
						if (board.pieces[k][l].checkMove(this.row , this.col, board)) {
							isUnderCheck = true;
							return 1;
							
						}
					}
				}
			}
		}
		
		isUnderCheck = false;
		return 0;
	}
	
	

	public boolean isCheckMate(Board board) throws IOException
	{
		boolean checkmove [] = new boolean [8];		//for storing the valid movements for king
		int count=0;
		
		//for checking the valid moves of the king under check
		if(!board.pieces[row][col].checkMove(row+1, col, board))
		{
			checkmove[0]=false;
		}
		else
		{
			checkmove[0]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row, col+1, board))
		{
			checkmove[1]=false;
		}
		else
		{
			checkmove[1]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row+1, col+1, board))
		{
			checkmove[2]=false;
		}
		else
		{
			checkmove[2]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row+1, col-1, board))
		{
			checkmove[3]=false;
		}
		else
		{
			checkmove[3]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row-1, col+1, board))
		{
			checkmove[4]=false;
		}
		else
		{
			checkmove[4]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row-1, col-1, board))
		{
			checkmove[5]=false;
		}
		else
		{
			checkmove[5]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row-1, col,board))
		{
			checkmove[6]=false;
		}
		else
		{
			checkmove[6]=true;
			count++;
		}
		if(!board.pieces[row][col].checkMove(row, col-1, board))
		{
			checkmove[7]=false;
		}
		else
		{
			checkmove[7]=true;
			count++;
		}
		
		
		boolean attack[] = new boolean [8];
		
		//for finding the x and y of opponent pieces around the king
		for (int k = 0; k < 8; k++) 
		{
			for (int l = 0; l < 8; l++) 
			{
				if (board.pieces[k][l] != null) 
				{				
					if (board.pieces[k][l].color != this.color) 
					{
						if(checkmove[0])
						{
							if (board.pieces[k][l].checkMove(this.row+1 , this.col, board))	
							{
								//antiposx[count1]=k;
								//antiposy[count1]=l;
								//count1++;
								attack[0]=true;
							}
						}
						if(checkmove[1])
						{
							if (board.pieces[k][l].checkMove(this.row , this.col+1, board))	
							{
								attack[1]=true;
							}
						}
						if(checkmove[2])
						{
							if (board.pieces[k][l].checkMove(this.row+1 , this.col+1, board))	
							{
								attack[2]=true;
							}
						}
						if(checkmove[3])
						{
							if (board.pieces[k][l].checkMove(this.row+1 , this.col-1, board))	
							{
								attack[3]=true;
							}
						}
						if(checkmove[4])
						{
							if (board.pieces[k][l].checkMove(this.row-1 , this.col+1, board))	
							{
								attack[4]=true;
							}
						}
						if(checkmove[5])
						{
							if (board.pieces[k][l].checkMove(this.row-1 , this.col-1, board))	
							{
								attack[5]=true;
							}
						}
						if(checkmove[6])
						{
							if (board.pieces[k][l].checkMove(this.row-1 , this.col, board))	
							{
								attack[6]=true;
							}
						}
						if(checkmove[7])
						{
							if (board.pieces[k][l].checkMove(this.row , this.col-1, board))	
							{
								attack[7]=true;
							}
						}
					}
				}
			}
		}
		
		
		
		//check if any same piece can block the checkmate
		
		
		boolean protect[] = new boolean [8];
		for (int k = 0; k < 8; k++) 
		{
			for (int l = 0; l < 8; l++) 
			{
				if (board.pieces[k][l] != null) 
				{				
					if (board.pieces[k][l].color == this.color)
					{
						if(!(board.pieces[k][l] instanceof King))
						{
							if(checkmove[0])
							{
								if (board.pieces[k][l].checkMove(this.row+1 , this.col, board))	
								{
									protect[0]=true;
								}
							}
							if(checkmove[1])
							{
								if (board.pieces[k][l].checkMove(this.row , this.col+1, board))	
								{
									protect[1]=true;
								}
							}
							if(checkmove[2])
							{
								if (board.pieces[k][l].checkMove(this.row+1 , this.col+1, board))	
								{
									protect[2]=true;
								}
							}
							if(checkmove[3])
							{
								if (board.pieces[k][l].checkMove(this.row+1 , this.col-1, board))	
								{
									protect[3]=true;
								}
							}
							if(checkmove[4])
							{
								if (board.pieces[k][l].checkMove(this.row-1 , this.col+1, board))	
								{
									protect[4]=true;
								}
							}
							if(checkmove[5])
							{
								if (board.pieces[k][l].checkMove(this.row-1 , this.col-1, board))	
								{
									protect[5]=true;
								}
							}
							if(checkmove[6])
							{
								if (board.pieces[k][l].checkMove(this.row-1 , this.col, board))	
								{
									protect[6]=true;
								}
							}
							if(checkmove[7])
							{
								if (board.pieces[k][l].checkMove(this.row , this.col-1, board))	
								{
									protect[7]=true;
								}
							}
						}
					}					
				}
			}
		}		
		
		
		//check if checkmate has occured
		int count2=0,count4=0;
		for(int a=0;a<8;a++)
		{
			if(attack[a])
			{
				count2++;
			}
		}
		for(int a=0;a<8;a++)
		{
			if(protect[a])
			{
				count4++;
			}
		}
		
		if(count==count2 && count4==0)
		{
			checkmate=true;
			toggleCheckmate();
			return checkmate;			
		}
		else
		{
			checkmate=false;
			return checkmate;
		}
	}
	
	
	public void drawPiece(Graphics g){
        
        if(!this.isdead)
        {      
			if(isUnderCheck == true)
			{
				redsprite.paint(g);
			}
			else
			{     
				sprite.paint(g);
			}
			if(checkmate)
			{
				if(color==0)		//for black
				{
					blackcheckmate.paint(g);
				}	
				else if(color==1)		//for white
				{
					whitecheckmate.paint(g);
				}
			}
		}
    }
	
    //for checmate message display
    
    void toggleCheckmate() throws IOException
    {
    	if(checkmate==true)
    	{
        	int x_offset = 0;
            int y_offset = 0;
            int boardlengthx = 800;
            int boardlengthy=600;
        	if(color==0)		//for black
        	{
            	blackcheckmate = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\whitecheckmate.bmp");
            	blackcheckmate.move(x_offset,y_offset);
            	blackcheckmate.setScale(boardlengthx, boardlengthy);
            	blackcheckmate.setVisibility(false);    		
        	}
        	else if(color==1)		//for white
        	{
            	whitecheckmate = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\blackcheckmate.bmp");
            	whitecheckmate.move(x_offset,y_offset);
            	whitecheckmate.setScale(boardlengthx, boardlengthy);
            	whitecheckmate.setVisibility(true);
        	}
    	}
    	return;
    }
}