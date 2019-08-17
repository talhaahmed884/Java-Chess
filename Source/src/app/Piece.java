package app1;

import java.awt.Graphics;
import java.io.IOException;

public abstract class Piece {
    
    protected boolean isdead;                   // FOR KILLED PIECES
    protected int row, col;                         // BOARD POSITIONS x == columns and y == rows
    public int color;                           // 0 FOR BLACK && 1 FOR WHITE
    protected Sprite sprite;

    //FILEPATHS - CHANGE HERE:::

    public final String DEFAULTfp = "C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\";
    public final String[] PAWNfn  = {"blackpawn.bmp", "whitepawn.bmp" };
    public final String[] QUEENfn = {"blackqueen.bmp", "whitequeen.bmp"};
    public final String[] BISHOPfn = {"blackbishop.png", "whitebishop.png"};
    public final String[] KINGfn = {"blackking.png", "whiteking.png", "blackkingcheck.png", "whitekingcheck.png", "checkmate.png"};
    public final String[] KNIGHTfn = {"blackknight.bmp", "whiteknight.bmp"};
    public final String[] ROOKfn = {"blackrook.bmp", "whiterook.bmp"};


    //

    public Piece(int rowarg, int colarg, int colorarg)          // PARAMETERIZED
    {
        this.row = rowarg;
        this.col = colarg;
        this.color = colorarg;
    }

    public Piece(Piece obj)                                 // COPY
    {
        this.row = obj.row;
        this.col = obj.col;
        this.color = obj.color;
    }

    public void killPiece()                                                 
    {
        this.isdead = true;
    }

    public void drawPiece(Graphics g){
        
        if(!this.isdead){            
        sprite.paint(g);
        }
    }

    public void loadSprite(String filepath)
    {
        
            try {
                sprite = new Sprite(filepath);
            } catch (IOException e) {
                e.printStackTrace();
            }

            int x_offset = col * Game.square_size + 135;
            int y_offset = row * Game.square_size + 57;
            int boardlength =  Game.square_size;

            sprite.move(x_offset , y_offset);
            sprite.setScale(boardlength, boardlength);
            sprite.setVisibility(true);
    }
    
    public void removeVisibility()
    {
    	sprite.setVisibility(false);
    }
 
    
    public abstract boolean checkMove(int xarg, int yarg, Board board);

      

}