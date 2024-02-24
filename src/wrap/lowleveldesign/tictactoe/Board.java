package wrap.lowleveldesign.tictactoe;

public class Board {

    int size;
    Piece[][] board;
    int coveredSpace=0;

    Board(int size){
        this.size=size;
        board = new Piece[size][size];
    }

    public boolean placePiece(int row, int column, Piece piece){

        if(board[row][column] != null){
            return false;
        }
        board[row][column] = piece;
        coveredSpace++;
        return true;
    }

    public boolean hasFreeSpace(){
        return coveredSpace < this.size*this.size;
    }

    public void display(){
       for (int i=0;i< size;i++){
           for(int j=0;j<size;j++){
               if (board[i][j] != null) {
                   System.out.print(board[i][j].pieceType.name() + "   ");
               } else {
                   System.out.print("    ");
               }
               System.out.print(" | ");
           }
           System.out.println();

       }

    }



}
