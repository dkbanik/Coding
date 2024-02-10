package lowleveldesign.chess.model.piece;


import lowleveldesign.chess.model.Board;
import lowleveldesign.chess.model.Cell;
import lowleveldesign.chess.model.Color;

public abstract class Piece {

    Color color;
    boolean isKilled;
    int movesMade;
    public Piece(Color color) {
        this.color = color;
    }

    abstract boolean canMove(Board board, Cell from, Cell to);
}
