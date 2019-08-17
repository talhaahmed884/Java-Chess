package app1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JFrame;


public class Game extends JFrame {

    // BASIC FIELDS
    public Board mainBoard;
    public Board undoBoard;
    public static final int screen_width = 800;
    public static final int screen_height = 600;
    public static final int square_size = 65;
    static final long serialVersionUID = 30;

    static boolean pieceselected = false;
    static Sprite[][] possiblemoves = new Sprite[8][8]; 
    static Sprite selectedpiece;
    static Sprite previousmove;
    static Sprite presentmove;
    static int turn = 1;

    public Game() throws IOException {

        // WINDOW'S CODE
        super("Chess");
        setSize(screen_width, screen_height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color Brawn = new Color(40,25, 12);
        setBackground(Brawn);
       
        // BOARD'S CODE
        mainBoard = new Board();
        mainBoard.resetBoard();
        undoBoard = new Board();
        undoBoard.copyBoard(mainBoard);

        initializePossibleMoves();
        initializePreviousMoves();

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
                possiblemoves[i][j] = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\possible2.bmp");
                possiblemoves[i][j].move(x_offset , y_offset);
                possiblemoves[i][j].setScale(boardlength, boardlength);
                possiblemoves[i][j].setVisibility(false);

                /// SELECTED PIECE
                selectedpiece = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\possible3.bmp");
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
    
    //for highlighting the previous state of the piece
    private void resetPreviousMove()
    {
    	presentmove.setVisibility(false);
    	previousmove.setVisibility(false);
    }
    
    private void initializePreviousMoves() throws IOException
    {
        int boardlength =  Game.square_size;
        previousmove = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\possible4.bmp");
        presentmove = new Sprite("C:\\Users\\talha\\eclipse-workspace\\app1\\src\\app1\\Data\\possible2.bmp");
        presentmove.move(0, 0);
        previousmove.move(0,0);
        previousmove.setScale(boardlength,boardlength);
        presentmove.setScale(boardlength, boardlength);
        previousmove.setVisibility(false);
        presentmove.setVisibility(false);
    }
    
    private void togglePreviousMove(int row, int col, int newrow, int newcol)
    {
    	previousmove.move(col * Game.square_size + 135 , row * Game.square_size + 58);
    	previousmove.setVisibility(true);
    	presentmove.move(newcol * Game.square_size + 135, newrow * Game.square_size + 58);
    	presentmove.setVisibility(true);
    }

    //Shutdown the game in case of checkmate
    void shutDown()
    {
    	mainBoard.hide();
    	resetPossibleMoves();
    	resetPreviousMove();
    	
    	
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
        previousmove.paint(g);
        presentmove.paint(g);
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
                            if(mainBoard.pieces[row][col].color == turn ){
                            pieceselected = true;
                            togglePossibleMoves(row, col);
                            resetPreviousMove();
                            repaint();
                            }
                        }
                    }
                    else if(pieceselected){
                        int newcol = (x - 134)/Game.square_size;
                        int newrow = (y - 57)/Game.square_size;

                        if(mainBoard.pieces[row][col].checkMove(newrow, newcol, mainBoard)){
                            
                            mainBoard.movePiece(row, col, newrow, newcol);
                            togglePreviousMove(row, col, newrow, newcol);
                            
                            
                            // UPDATES CHECK VALUES
                            King tempk = (King)mainBoard.pieces[mainBoard.whitekingpos[0]][mainBoard.whitekingpos[1]];
                            mainBoard.whitekingpos[2] = tempk.handleCheck(mainBoard);
                            
                            tempk = (King)mainBoard.pieces[mainBoard.blackkingpos[0]][mainBoard.blackkingpos[1]];
                            mainBoard.blackkingpos[2] = tempk.handleCheck(mainBoard);


                            // IF PLAYER MOVES IN CHECK THE BOARD IS UNDONE ONE MOVE
                            if(turn == 0 && mainBoard.blackkingpos[2] == 1){
                                mainBoard.copyBoard(undoBoard);
                            }
                            else if(turn == 1 && mainBoard.whitekingpos[2] == 1)
                            {
                                mainBoard.copyBoard(undoBoard);
                            }
                            // IF PLAYER GETS OTHER PLAYER IN CHECK, CHECKMATE IS CHECKED
                            else 
                            {
                                if(turn == 0 && mainBoard.whitekingpos[2] == 1){
                                    tempk = (King)mainBoard.pieces[mainBoard.whitekingpos[0]][mainBoard.whitekingpos[1]];
                                    
                                    /*if(tempk.isCheckMate(mainBoard))
                                    {
                                    	System.out.print("CheckMate\n");
                                    }*/
                                    try
                                    {
                                    	tempk.isCheckMate(mainBoard);
                                    	if(tempk.checkmate==true)
                                    	{
                                    		shutDown();
                                    	}
                                    }
                                    catch(Exception e)
                                    {
                                    	e.printStackTrace();
                                    }
                                   
                                }
                                else if(turn == 1 && mainBoard.blackkingpos[2] == 1){
                                    tempk = (King)mainBoard.pieces[mainBoard.blackkingpos[0]][mainBoard.blackkingpos[1]];

                                    /*if(tempk.isCheckMate(mainBoard))
                                    {
                                    	System.out.print("CheckMate\n");
                                    }*/
                                    try
                                    {
                                    	tempk.isCheckMate(mainBoard);
                                    	if(tempk.checkmate==true)
                                    	{
                                    		shutDown();
                                    	}
                                    }
                                    catch(Exception e)
                                    {
                                    	e.printStackTrace();
                                    }
                                   
                                }
                            
                                turn = (turn + 1)%2;
                                undoBoard.copyBoard(mainBoard);
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