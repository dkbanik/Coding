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

        int fromRow = from.getRow();
        int fromCol = from.getCol();
        int toRow = to.getRow();
        int toCol = to.getCol();

        // Determine direction based on the piece's color
        int direction = (this.color == Color.WHITE) ? -1 : 1;

        // Check if the move is 1 cell vertical
        if (fromCol == toCol && fromRow + direction == toRow) {
            // Check if the 'to' cell is empty
            return board.isEmptyCell(toRow, toCol);
        }

        // Check if the move is 2 cells vertical for the first move
        if (fromCol == toCol && fromRow + 2 * direction == toRow && isFirstMove(fromRow, this.color)) {
            // Check if the intermediate cell is empty and the 'to' cell is empty
            return board.isEmptyCell(fromRow + direction, fromCol) && board.isEmptyCell(toRow, toCol);
        }

        // Check if the move is diagonal
        if (Math.abs(toCol - fromCol) == 1 && fromRow + direction == toRow) {
            // Check if the 'to' cell contains a piece of the opposite color
            Piece toPiece = board.getCell(toRow, toCol).piece;
            return toPiece != null && toPiece.color != this.color;
        }

        return false;
    }
    @Override
    public String toString() {
        return "P";
    }

    private boolean isFirstMove(int row, Color color) {
        return (color == Color.WHITE && row == 6) || (color == Color.BLACK && row == 1);
    }
}
