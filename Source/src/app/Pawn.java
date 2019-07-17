package app;

public class Pawn extends Piece
{

    public boolean can_enpassant;       // BOOL HANDLED BY BOARD UPON MOVE AND USED BY CHECKMOVE FOR VALIDATION 

    Pawn(int rowarg, int colarg, int colorarg)
    {
        super(rowarg, colarg, colorarg);     // PARAMETERIZED CONSTRUCTOR OF PIECE
        can_enpassant = false;         		 // EN PASSANT IMPOSSIBLE IN START POSITION
    }
    Pawn(Pawn obj)
    {
        super(obj);                     // COPY CONSTRUCTOR OF CLASS PIECE
        this.can_enpassant=obj.can_enpassant;
    }

    public void drawPiece()
    {
        
        if(this.isdead)
        {             // IF DEAD, PRINT "-"
        System.out.printf(" - "); 
        }
        else if(color == 0)
        {         // IF BLACK
        System.out.printf(" p ");
        }
        else if(color ==1)
        {          // IF WHITE
        System.out.printf(" P "); 
        }
        else
        {                        // TO PRINT NOTHING INSTEAD OF CRASHING IN CASE OF A BUG
        System.out.printf("   ");
        }
    }

    public boolean checkMove(int rowarg, int colarg, Board board)
    {
        if(rowarg>=0 && rowarg<=7 && colarg>=0 && colarg<=7)		//in case of values out of bounds of board
        {
        	if(this.color == 0)
            {      ///// FOR BLACK i.e small p
                if(board.pieces[rowarg][colarg] == null)   /// IF TARGET POSITION EMPTY
                {
                    if( colarg == col && rowarg - row == 2 && row == 1) 
                    {
                    	return true;   /// IF MOVES TWO SPACES FROM BEGINNING
                    }
                    else if (colarg == col && rowarg - row == 1)
                    {
                    	return true;         /// ONE FORWARD
                   	}
                    else return false;
                }
                else if(board.pieces[rowarg][colarg] != null && board.pieces[rowarg][colarg].color == 1)   // IF TARGET POSITION HAS WHITE PIECE
                {
                    if( Math.abs(colarg - col) == 1 && rowarg - row == 1) return true;   //CROSS KILL
                    else return false;
                }
            }
            else if(this.color == 1)
            {      ///// FOR WHITE i.e big P  - LOL pp
                if(board.pieces[rowarg][colarg] == null)
                {
                    if( colarg == col && row - rowarg == 2 && row == 6 ) return true;   /// IF MOVES TWO SPACES FROM BEGINNING
                    else if (colarg == col && row - rowarg == 1) return true;         /// ONE FORWARD
                    else return false;
                }
                else if(board.pieces[rowarg][colarg] != null && board.pieces[rowarg][colarg].color == 0)  /// IF TARGET POSITION HAS BLACK PIECE
                {
                    if( Math.abs(colarg - col) == 1 && rowarg - row == 1) return true;   // CROSS KILL
                    else return false;
                }
            } 
           	return false;		///// IN CASE OF AN UNEXPECTED CASE 
        }
        else
        {
        	return false;
        }
   }
}