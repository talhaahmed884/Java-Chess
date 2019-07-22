package app;

import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;

public class Board {

    public Piece[][] pieces;
    Sprite sprite;

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
            sprite = new Sprite("/root/Desktop/Java/Chess/src/app/Data/board.bmp");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int x_offset = ((( Game.screen_width / Game.square_size) - 8) / 2) * Game.square_size;
        int y_offset = ((( Game.screen_height / Game.square_size) - 8) / 2) * Game.square_size + (Game.square_size)*14/17;
        int boardlength = (Game.square_size * 8) + 10;

        sprite.move(x_offset, y_offset);
        sprite.setScale(boardlength, boardlength);
        sprite.setVisibility(true);
    }

    public void resetBoard( JFrame g)
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
                    pieces[r][c] = new King(r,c, 0); c++;
                    pieces[r][c] = new Queen(r, c, 0); c++;
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
                    pieces[r][c] = new King(r,c, 1); c++;
                    pieces[r][c] = new Queen(r, c, 1); c++;
                    pieces[r][c] = new Bishop(r,c, 1); c++;
                    pieces[r][c] = new Knight(r,c,1); c++;
                    pieces[r][c] = new Rook(r,c,1); c++;
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