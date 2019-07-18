package app;

import java.awt.Graphics;

public class Queen extends Piece {

    Queen(int rowarg, int colarg, int colorarg)
    {
        super(rowarg, colarg, colorarg);    // PARAMETERIZED CONSTRUCTOR OF PIECE
        loadSprites("/root/Desktop/Java/Chess/src/app/whitequeen.bmp", "/root/Desktop/Java/Chess/src/app/blackqueen.bmp");
    }
    Queen(Pawn obj)
    {
        super(obj);                     // COPY CONSTRUCTOR OF CLASS PIECE
    }


    public void drawPiece(Graphics g){
        
        if(this.isdead){             // IF DEAD, PRINT "-"
        //System.out.printf(" - "); 
        }
        else if(color == 0){         // IF BLACK
        //System.out.printf(" p ");
        spriteb.drawSprite(g);
        }
        else if(color == 1){          // IF WHITE
        //System.out.printf(" \u01A5 "); 
        spritew.drawSprite(g);
        }
        else{                        // TO PRINT NOTHING INSTEAD OF CRASHING IN CASE OF A BUG
        System.out.printf("   ");
        }
    }

    public boolean checkMove(int rowarg, int colarg, Board board)
    {
        if(rowarg < 0 || rowarg > 7 || colarg < 0 || colarg > 7) return false;
        if(board.pieces[rowarg][colarg]!= null &&  board.pieces[rowarg][colarg].color == this.color) return false; /// IF TARGET POSITION HAS PIECE OF SAME COLOR

        /// BELOW ARE CONDITIONS FOR PATH CHECK OF EACH OF EIGHT DIRECTIONS


        ///UPWARDS
        if(col == colarg && rowarg < row)
        {
            for(int x = row + 1; x < rowarg; x++){
                if(board.pieces[x][col] != null) return false;
            }
            return true;
        }
        
        //DOWNWARDS
        if(col == colarg && rowarg > row)
        {
            for(int x = row - 1; x > rowarg; x--){
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
        if(col > colarg && row > rowarg)
        {
            for(int c = col - 1, r = row + 1; c > colarg && r > rowarg; r++, c--){
                if(board.pieces[r][c] != null) return false;
            }
            return true;
        }
        
        //UPLEFT
        if(col > colarg && row > rowarg)
        {
            for(int c = col - 1, r = row + 1; c > colarg && r > rowarg; r--, c--){
                if(board.pieces[r][c] != null) return false;
            }
            return true;
        }
    

        return false;

    }

}