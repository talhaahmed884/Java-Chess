package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;


public class Game extends JFrame {

    // BASIC FIELDS
    private Board mainBoard;
    public static final int screen_width = 800;
    public static final int screen_height = 600;
    public static final int square_size = 65;
    static final long serialVersionUID = 20;

    static boolean pieceselected = false;
    static Sprite[][] possiblemoves = new Sprite[8][8]; 
    static Sprite selectedpiece;
    
    public Game() throws IOException {

        // WINDOW'S CODE
        super("Chess");
        setSize(screen_width, screen_height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color Brawn = new Color(40,25, 12);
        setBackground(Brawn);
       
        // BOARD'S CODE
        mainBoard = new Board();
        mainBoard.resetBoard(this);
        initializePossibleMoves();

        // THIS ACTION SHOULD ALWAYS BE PERFORMED AT THE END OF THIS BLOCK
        setVisible(true);
    }

    private void togglePossibleMoves(int row, int col){

        for(int i=0; i < 8; i++)
        {
            for(int j =0; j < 8; j++)
            {
                if(mainBoard.pieces[row][col].checkMove(i, j, mainBoard))
                {
                    possiblemoves[i][j].setVisibility(true);
                }
            }
        }

        selectedpiece.move( col * Game.square_size + 135 , row * Game.square_size + 58);
        selectedpiece.setVisibility(true);
    } 

    private void initializePossibleMoves() throws IOException
    {
        for(int i=0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {

                int x_offset = j * Game.square_size + 135;
                int y_offset = i * Game.square_size + 58;
                int boardlength =  Game.square_size;


                /// POSSIBLE MOVES' ARRAY
                possiblemoves[i][j] = new Sprite("/root/Desktop/Java/Chess/src/app/Data/possible2.bmp");
                possiblemoves[i][j].move(x_offset , y_offset);
                possiblemoves[i][j].setScale(boardlength, boardlength);
                possiblemoves[i][j].setVisibility(false);

                /// SELECTED PIECE
                selectedpiece = new Sprite("/root/Desktop/Java/Chess/src/app/Data/possible3.bmp");
                selectedpiece.move( 0 , 0);
                selectedpiece.setScale(boardlength, boardlength);
                selectedpiece.setVisibility(false);
                
            }
        }
    }
    private void resetPossibleMoves()
    {
        for(int i=0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {
                possiblemoves[i][j].setVisibility(false);
            }
        }

        selectedpiece.setVisibility(false);
    }

    // ALL GUI-DRAWING STUFF PERFORMED HERE
    public void paint(Graphics g) {
        //super.paint(g);
        mainBoard.printBoard(g);
        
        for(int i=0; i < 8; i++)
        {
            for(int j=0; j < 8; j++)
            {
                possiblemoves[i][j].paint(g);
            }
        }

        selectedpiece.paint(g);
    }
    
    public void Play()
    {
       
        this.addMouseListener(new MouseListener(){
            int x, y;
            int row, col;
            
            @Override
            public void mouseReleased(MouseEvent evt) {
                x = evt.getX();
                y = evt.getY();
                
                if(x >  134 && x < 654 && y > 56 && y < 576){

                    if(!pieceselected){
                        col = (x - 134)/Game.square_size;
                        row = (y - 57)/Game.square_size;
                        
                        if(mainBoard.pieces[row][col] != null)
                        {
                        pieceselected = true;
                        togglePossibleMoves(row, col);
                        repaint();
                        }
                    }
                    else if(pieceselected){
                        int newcol = (x - 134)/Game.square_size;
                        int newrow = (y - 57)/Game.square_size;

                        if(mainBoard.pieces[row][col].checkMove(newrow, newcol, mainBoard)){
                            if(mainBoard.pieces[row][col] instanceof Pawn)
                            {
                                mainBoard.pieces[newrow][newcol] = new Pawn(newrow, newcol, mainBoard.pieces[row][col].color);
                                mainBoard.pieces[row][col] = null;
                            }
                            else if(mainBoard.pieces[row][col] instanceof Bishop)
                            {
                                mainBoard.pieces[newrow][newcol] = new Bishop(newrow, newcol, mainBoard.pieces[row][col].color);
                                mainBoard.pieces[row][col] = null;
                            }
                            else if(mainBoard.pieces[row][col] instanceof Queen)
                            {
                                mainBoard.pieces[newrow][newcol] = new Queen(newrow, newcol, mainBoard.pieces[row][col].color);
                                mainBoard.pieces[row][col] = null;
                            }
                            else if(mainBoard.pieces[row][col] instanceof King)
                            {
                                mainBoard.pieces[newrow][newcol] = new King(newrow, newcol, mainBoard.pieces[row][col].color);
                                mainBoard.pieces[row][col] = null;
                            }
                            else if(mainBoard.pieces[row][col] instanceof Knight)
                            {
                                mainBoard.pieces[newrow][newcol] = new Knight(newrow, newcol, mainBoard.pieces[row][col].color);
                                mainBoard.pieces[row][col] = null;
                            }
                            else if(mainBoard.pieces[row][col] instanceof Rook)
                            {
                                mainBoard.pieces[newrow][newcol] = new Rook(newrow, newcol, mainBoard.pieces[row][col].color);
                                mainBoard.pieces[row][col] = null;
                            }
                        }
                        resetPossibleMoves();
                        pieceselected = false;
                        repaint();
                    }
                }
            }
        
            @Override
            public void mousePressed(MouseEvent evt) {
               
            }
        
            @Override
            public void mouseExited(MouseEvent evt) {
                
            }

            @Override
            public void mouseEntered(MouseEvent evt) {
                
            }
        
            @Override
            public void mouseClicked(MouseEvent evt) {
                
            }
            
        } ) ;
    }
    public static void main(String[] args) throws IOException {
      

        Game mygame = new Game();
        mygame.Play();        
    }

}