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
        return false;
    }

    @Override
    public String toString() {
        return "K";
    }
}
