package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.helper.PieceUtils;
import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public class Queen extends Piece{

    public Queen(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        /*
        *   1. check if horizontal
        *   2. check if vertical
        *   3. check if diagonal
        *
        * */
        return PieceUtils.canMoveHorizontal(board,from,to) ||
                PieceUtils.canMoveVertical(board, from, to) ||
                PieceUtils.canMoveDiagonal(board, from, to);

    }

    @Override
    public String toString() {
        return "Q";
    }
}
