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
        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();

        // Determine direction based on the piece's color
        int direction = (this.getColor() == Color.WHITE) ? -1 : 1;

        // Check if the move is 1 cell vertical
        if (fromX == toX && fromY + direction == toY) {
            // Check if the 'to' cell is empty
            return board.isEmptyCell(toX, toY);
        }

        // Check if the move is 2 cells vertical for the first move
        if (fromX == toX && fromY + 2 * direction == toY && isFirstMove(fromY, this.getColor())) {
            // Check if the intermediate cell is empty and the 'to' cell is empty
            return board.isEmptyCell(fromX,  fromY + direction ) && board.isEmptyCell(toX, toY);
        }

        // Check if the move is diagonal
        if (Math.abs(toX - fromX) == 1 && fromY + direction == toY) {
            // Check if the 'to' cell contains a piece of the opposite color
            Piece toPiece = board.getCell(toX, toY).getPiece();
            return toPiece != null && toPiece.getColor() != this.getColor();
        }

        return false;
    }
    @Override
    public String toString() {
        return "P";
    }

    private boolean isFirstMove(int y, Color color) {
        return (color == Color.WHITE && y == 6) || (color == Color.BLACK && y == 1);
    }
}
