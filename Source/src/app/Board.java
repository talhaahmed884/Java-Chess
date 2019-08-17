package app1;

import java.awt.*;
import java.io.IOException;

public class Board {

    public Piece[][] pieces;
    Sprite sprite;

     ///TO KEEP TRACK OF KINGS' POSITIONS. Third place for check.
	public int[] whitekingpos = {7, 4, 0};
    public int[] blackkingpos = {0, 4, 0};
    

    Board()
    {
        pieces = new Piece[8][8];
        for(int i = 0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {
                pieces[i][j] = null;          /// NULL FOR EMPTY SPACES
            }
        }

        try {
            sprite = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\board1.bmp");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x_offset = 0;
        int y_offset = 0;
        int boardlengthx = 800;
        int boardlengthy=600;

        sprite.move(x_offset, y_offset);
        sprite.setScale(boardlengthx, boardlengthy);
        sprite.setVisibility(true);
    }

    public void copyBoard(Board b)
    {
        for(int i = 0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {
                pieces[i][j] = null;          /// NULL FOR EMPTY SPACES
            }
        }

        for(int i=0; i < 8; i++)
        {
            for(int j =0; j < 8; j++)
            {
                if(b.pieces[i][j] != null)
                {
                            if(b.pieces[i][j] instanceof Pawn)
                            {
                                pieces[i][j] = new Pawn(i, j, b.pieces[i][j].color);
                            }
                            else if(b.pieces[i][j] instanceof Bishop)
                            {
                                pieces[i][j] = new Bishop(i, j, b.pieces[i][j].color);
                            }
                            else if(b.pieces[i][j] instanceof Queen)
                            {
                                pieces[i][j] = new Queen(i, j, b.pieces[i][j].color);
                            }
                            else if(b.pieces[i][j] instanceof King)
                            {
                                pieces[i][j] = new King(i, j, b.pieces[i][j].color);
                            }
                            else if(b.pieces[i][j] instanceof Knight)
                            {
                                pieces[i][j] = new Knight(i, j, b.pieces[i][j].color);
                            }
                            else if(b.pieces[i][j] instanceof Rook)
                            {
                                pieces[i][j] = new Rook(i, j, b.pieces[i][j].color);
                            }
                }
            }
        }
    }

    public void movePiece(int row, int col, int newrow, int newcol)
    {
        if(this.pieces[row][col] instanceof Pawn)
        {
            this.pieces[newrow][newcol] = new Pawn(newrow, newcol, this.pieces[row][col].color);
            this.pieces[row][col] = null;
        }
        else if(this.pieces[row][col] instanceof Bishop)
        {
            this.pieces[newrow][newcol] = new Bishop(newrow, newcol, this.pieces[row][col].color);
            this.pieces[row][col] = null;
        }
        else if(this.pieces[row][col] instanceof Queen)
        {
            this.pieces[newrow][newcol] = new Queen(newrow, newcol, this.pieces[row][col].color);
            this.pieces[row][col] = null;
        }
        else if(this.pieces[row][col] instanceof King)
        {
            if(this.pieces[row][col].color == 1){
                whitekingpos[0] = newrow; whitekingpos[1] = newcol;
            }
            else
            {
                blackkingpos[0] = newrow; blackkingpos[1] = newcol;
            }
            
            this.pieces[newrow][newcol] = new King(newrow, newcol, this.pieces[row][col].color);
            this.pieces[row][col] = null;
        }
        else if(this.pieces[row][col] instanceof Knight)
        {

            this.pieces[newrow][newcol] = new Knight(newrow, newcol, this.pieces[row][col].color);
            this.pieces[row][col] = null;
        }
        else if(this.pieces[row][col] instanceof Rook)
        {
            this.pieces[newrow][newcol] = new Rook(newrow, newcol, this.pieces[row][col].color);
            this.pieces[row][col] = null;
        }
    }
    public void resetBoard()
    {
        int[] rows = {0, 1,  6, 7};
        for(int r : rows)
        {
            for(int c=0; c < 8; c++)
            {
                if(r == 0)
                {   
                    pieces[r][c] = new Rook(r,c,0); c++;
                    pieces[r][c] = new Knight(r,c,0); c++;
                    pieces[r][c] = new Bishop(r,c, 0); c++;
                    //pieces[r][c] = new King(r,c, 0); c++;
                    pieces[r][c] = new Queen(r, c, 0); c++;
                    pieces[r][c] = new King(r,c, 0); c++;
                    pieces[r][c] = new Bishop(r,c, 0); c++;
                    pieces[r][c] = new Knight(r,c,0); c++;
                    pieces[r][c] = new Rook(r,c,0); c++;
                }
                else if(r == 1)
                {
                    pieces[r][c] = new Pawn(r, c, 0);
                }
                else if(r ==6)
                {
                    pieces[r][c] = new Pawn(r, c , 1);
                }
                else if(r == 7)
                {
                    pieces[r][c] = new Rook(r,c,1); c++;
                    pieces[r][c] = new Knight(r,c,1); c++;
                    pieces[r][c] = new Bishop(r,c, 1); c++;
                    //pieces[r][c] = new King(r,c, 1); c++;
                    pieces[r][c] = new Queen(r, c, 1); c++;
                    pieces[r][c] = new King(r,c, 1); c++;
                    pieces[r][c] = new Bishop(r,c, 1); c++;
                    pieces[r][c] = new Knight(r,c,1); c++;
                    pieces[r][c] = new Rook(r,c,1); c++;
                }
            }
        }


    }

   
    //for hiding all the pieces in case of checkmate
    public void hide()
    {
    	sprite.setVisibility(false);
    	for(int a=0;a<8;a++)
    	{
    		for(int b=0;b<8;b++)
    		{
    			if(pieces[a][b]!=null)
    			{
        			pieces[a][b].removeVisibility();
    			}
    		}
    	}
    }
    
    
    
    public void printBoard(Graphics g)
        {

            sprite.paint(g);
            
            for(int i=0; i < 8; i++)         /// ROW LOOP
            {
                for(int j=0; j < 8; j++)        /// COLUMN LOOP
                {
                    if(pieces[i][j] != null)        /// IF PIECE PRESENT
                    {
                        pieces[i][j].drawPiece(g); 
                    }
                    else
                    {
                       // System.out.printf(" - ");
                    }
                }

                //System.out.print('\n');
            }
            
        }

}