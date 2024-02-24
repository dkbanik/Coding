package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public class King extends Piece{
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();

        /*
        *   can move 1 cell horizontal, vertical or diagonal
        * */

        if(Math.abs(toX - fromX) == 1 || Math.abs(toY - fromY) == 1){
            return board.isEmptyCell(toX, toY) || board.getCell(toX, toY).getPiece().getColor() != this.getColor();
        }

        // also need to check if king is in check in destination cell
        // implementation later
        return false;
    }

    @Override
    public String toString() {
        return "K";
    }
}
