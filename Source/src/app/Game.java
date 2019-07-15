package app;

public class Game{

    public static void main(String[] args) {
        
        Board mainBoard = new Board();
        mainBoard.resetBoard();
        mainBoard.printBoard();

        System.out.print(mainBoard.pieces[1][0].checkMove( 1, 2 , mainBoard));
        
    }

}