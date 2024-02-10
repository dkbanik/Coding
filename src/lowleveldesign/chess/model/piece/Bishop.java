package lowleveldesign.chess.model.piece;


import lowleveldesign.chess.model.Board;
import lowleveldesign.chess.model.Cell;
import lowleveldesign.chess.model.Color;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    boolean canMove(Board board, Cell from, Cell to) {
        return false;
    }

    @Override
    public String toString() {
        return "B";
    }
}
