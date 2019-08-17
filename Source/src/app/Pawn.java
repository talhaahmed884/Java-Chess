package app1;


public class Pawn extends Piece {

    public boolean can_enpassant;       // BOOL HANDLED BY BOARD UPON MOVE AND USED BY CHECKMOVE FOR VALIDATION 

    Pawn(int rowarg, int colarg, int colorarg)
    {
        super(rowarg, colarg, colorarg);    // PARAMETERIZED CONSTRUCTOR OF PIECE
        can_enpassant = false;          // EN PASSANT IMPOSSIBLE IN START POSITION

        if(colorarg == 0)
        loadSprite(DEFAULTfp + PAWNfn[0]);
        
        else if(colorarg == 1)
        loadSprite(DEFAULTfp + PAWNfn[1]);
    }

    Pawn(Pawn obj)
    {
        super(obj);                     // COPY CONSTRUCTOR OF CLASS PIECE
        can_enpassant = false;  
        sprite = null;
    }


   

    public boolean checkMove(int rowarg, int colarg, Board board)
    {
        if(rowarg < 0 || rowarg > 7 || colarg < 0 || colarg > 7) return false;
        if(rowarg == row && colarg == col) return false;
        
        if(this.color == 0){      ///// FOR BLACK i.e small p
            if(board.pieces[rowarg][colarg] == null)   /// IF TARGET POSITION EMPTY
            {
                if( colarg == col && rowarg - row == 2 && row == 1 && board.pieces[row + 1][col] == null) return true;   /// IF MOVES TWO SPACES FROM BEGINNING
                else if (colarg == col && rowarg - row == 1) return true;         /// ONE FORWARD
                else return false;
            }
            else if(board.pieces[rowarg][colarg] != null && board.pieces[rowarg][colarg].color == 1)   // IF TARGET POSITION HAS WHITE PIECE
            {
                if( Math.abs(colarg - col) == 1 && rowarg - row == 1) return true;   //CROSS KILL
                else return false;
            }
        } 

        else if(this.color == 1){      ///// FOR WHITE i.e big P  - LOL pp
            if(board.pieces[rowarg][colarg] == null)
            {
                if( colarg == col && row - rowarg == 2 && row == 6  && board.pieces[row -1][col] == null) return true;   /// IF MOVES TWO SPACES FROM BEGINNING
                else if (colarg == col && row - rowarg == 1) return true;         /// ONE FORWARD

                else return false;
            }
            else if(board.pieces[rowarg][colarg] != null && board.pieces[rowarg][colarg].color == 0)  /// IF TARGET POSITION HAS BLACK PIECE
            {
                if( Math.abs(col - colarg) == 1 && row - rowarg == 1) return true;   // CROSS KILL
                else return false;
            }
        } 
        return false;          ///// IN CASE OF AN UNEXPECTED CASE 
        
    }

    
}