package app;

public class Board{

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
                if(r==0)
                {

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