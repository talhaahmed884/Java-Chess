package app;

public class Board
{

    public Piece[][] pieces;

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
    }

    public void resetBoard()
    {

        int[] rows = {0, 1,  6, 7};
        for(int r : rows)
        {
            for(int c=0; c < 8; c++)
            {
                if(r==0 && c==0)
                {
                	pieces[r][c] = new Rook(r, c, 0);
                }
                else if(r==0 && c==7)
                {
                	pieces[r][c] = new Rook(r, c, 0);
                }
                else if(r==0 && c==1)
                {
                	pieces[r][c] = new Knight(r, c, 0);
                }
                else if(r==0 && c==6)
                {
                	pieces[r][c] = new Knight(r, c, 0);
                }
                else if(r == 1)
                {
                    pieces[r][c] = new Pawn(r, c, 0);
                }
                else if(r==0 && c==2)
                {
                	 pieces[r][c] = new Bishop(r, c, 0);
                }
                else if(r==0 && c==5)
                {
                	 pieces[r][c] = new Bishop(r, c, 0);
                }
                else if(r==0 && c==3)
                {
                	pieces[r][c] = new King(r, c, 0);
                }
                else if(r ==6)
                {
                    pieces[r][c] = new Pawn(r, c , 1);
                }
                else if(r == 7 && c==0)
                {
                	pieces[r][c] = new Rook(r, c, 1);
                }
                else if(r==7 && c==7)
                {
                	pieces[r][c] = new Rook(r, c, 1);                	
                }
                else if(r==7 && c==1)
                {
                	pieces[r][c] = new Knight(r, c, 1);
                }
                else if(r==7 && c==6)
                {
                	pieces[r][c] = new Knight(r, c, 1);
                }
                else if(r==7 && c==2)
                {
                	 pieces[r][c] = new Bishop(r, c, 1);
                }
                else if(r==7 && c==5)
                {
                	 pieces[r][c] = new Bishop(r, c, 1);
                }
                else if(r==7 && c==3)
                {
                	pieces[r][c] = new King(r, c, 1);
                }
                else			//in case of any errors
                {
                	
                }
            }
        }


    }

    public void printBoard()
        {
            for(int i=0; i < 8; i++)         /// ROW LOOP
            {
                for(int j=0; j < 8; j++)        /// COLUMN LOOP
                {
                    if(pieces[i][j] != null)        /// IF PIECE PRESENT
                    {
                        pieces[i][j].drawPiece();
                    }
                    else
                    {
                        System.out.printf(" - ");
                    }
                }

                System.out.print('\n');
            }
        }

}