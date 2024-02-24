package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public class Knight extends Piece{
    public Knight(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {

        /*
        *   1. Can move 2 in one direction n 1 in other direction
        * */
        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();

        if(Math.abs(fromX - toX) * Math.abs(fromY-toY) == 2){
            return board.isEmptyCell(toX, toY);
        }

        return false;
    }

    @Override
    public String toString() {
        return "N";
    }
}
