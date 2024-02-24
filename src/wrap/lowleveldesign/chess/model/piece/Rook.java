package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.helper.PieceUtils;
import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public class Rook extends Piece{
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        /*
        * check if move is vertical
        *            or
        * check if move is horizontal
        * */
        return PieceUtils.canMoveHorizontal(board, from, to) ||
                PieceUtils.canMoveVertical(board, from, to);

    }

    @Override
    public String toString() {
        return "R";
    }
}
