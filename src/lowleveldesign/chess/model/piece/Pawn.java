package lowleveldesign.chess.model.piece;


import lowleveldesign.chess.model.Board;
import lowleveldesign.chess.model.Cell;
import lowleveldesign.chess.model.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    boolean canMove(Board board, Cell from, Cell to) {
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }
}
