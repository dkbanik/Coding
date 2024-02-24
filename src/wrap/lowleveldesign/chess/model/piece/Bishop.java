package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.helper.PieceUtils;
import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public class Bishop extends Piece{
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        /*
        *  Only move diagonal
        *
        * */
        return PieceUtils.canMoveDiagonal(board, from, to);
    }

    @Override
    public String toString() {
        return "B";
    }
}
