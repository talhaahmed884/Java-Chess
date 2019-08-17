package app1;

public class Queen extends Piece {

    Queen(int rowarg, int colarg, int colorarg)
    {
        super(rowarg, colarg, colorarg);    // PARAMETERIZED CONSTRUCTOR OF PIECE
        
        if(colorarg == 0)
        loadSprite(DEFAULTfp + QUEENfn[0]);
        
        else if(colorarg == 1)
        loadSprite(DEFAULTfp + QUEENfn[1]);
     }
    Queen(Pawn obj)
    {
        super(obj);                     // COPY CONSTRUCTOR OF CLASS PIECE
    }


    public boolean checkMove(int rowarg, int colarg, Board board)
    {
        if(rowarg < 0 || rowarg > 7 || colarg < 0 || colarg > 7) return false;
        if(board.pieces[rowarg][colarg]!= null &&  board.pieces[rowarg][colarg].color == this.color) return false; /// IF TARGET POSITION HAS PIECE OF SAME COLOR

        /// BELOW ARE CONDITIONS FOR PATH CHECK OF EACH OF EIGHT DIRECTIONS


        ///UPWARDS
        if(col == colarg && rowarg < row)
        {
            for(int x = row - 1; x > rowarg; x--){
                if(board.pieces[x][col] != null) return false;
            }
            return true;
        }
        
        //DOWNWARDS
        if(col == colarg && rowarg > row)
        {
            for(int x = row + 1; x < rowarg; x++){
                if(board.pieces[x][col] != null) return false;
            }
            return true;
        }

        //RIGHTWARDS
        if(col < colarg && rowarg == row)
        {
            for(int x = col + 1; x < colarg; x++){
                if(board.pieces[row][x] != null) return false;
            }
            return true;
        }

        //LEFTWARDS
        if(col > colarg && rowarg == row)
        {
            for(int x = col - 1; x > colarg; x--){
                if(board.pieces[row][x] != null) return false;
            }
            return true;
        }

        
        /// IF NOT MOVING DIAGONALLY
        if( Math.abs(rowarg - row) != Math.abs(colarg - col)) return false;
        

        //UPRIGHT
        if(col < colarg && row > rowarg)
        {
            for(int c = col + 1, r = row - 1; c < colarg && r > rowarg; r--, c++){
                if(board.pieces[r][c] != null) return false;
            }
            return true;
        }

        //DOWNRIGHT
        if(col < colarg && row < rowarg)
        {
            for(int c = col + 1, r = row + 1; c < colarg && r < rowarg; r++, c++){
                if(board.pieces[r][c] != null) return false;
            }
            return true;
        }

        //DOWNLEFT
        if(col > colarg && row < rowarg)
        {
            for(int c = col - 1, r = row + 1; c > colarg && r < rowarg; r++, c--){
                if(board.pieces[r][c] != null) return false;
            }
            return true;
        }
        
        //UPLEFT
        if(col > colarg && row > rowarg)
        {
            for(int c = col - 1, r = row - 1; c > colarg && r > rowarg; r--, c--){
                if(board.pieces[r][c] != null) return false;
            }
            return true;
        }
    

        return false;

    }

}