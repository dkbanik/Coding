package wrap.lowleveldesign.chess.model.piece;


import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;
import wrap.lowleveldesign.chess.model.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        /*
        *   1. first move can go 2 cell vertical
        *   2. other move only 1 cell vertical
        *   3. move diagonal 1 cell if piece is of opposite color
        * */
        if(this.color == Color.WHITE){
            if(from.y == 6 && (to.y == 4 || to.y == 5)) return true;
            if(board.moveUp(from) == to) return true;
            if( (board.moveTopRight(from) == to || board.moveTopLeft(from) == to ) && to.piece.color == Color.BLACK) return true;
        }else {

        }
        return false;

    }

    @Override
    public String toString() {
        return "P";
    }
}
