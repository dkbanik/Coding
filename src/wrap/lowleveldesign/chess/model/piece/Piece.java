package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public abstract class Piece {

    Color color;
    boolean isKilled;
    int movesMade;
    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);
}
