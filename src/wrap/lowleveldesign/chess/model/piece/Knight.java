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

        return false;
    }

    @Override
    public String toString() {
        return "N";
    }
}
