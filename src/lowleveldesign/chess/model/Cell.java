package lowleveldesign.chess.model;


import lowleveldesign.chess.helper.CellHelper;
import lowleveldesign.chess.model.piece.Piece;

public class Cell {
    public int x;
    public int y;
    public String name; // a1 ...h8
    public Piece piece;

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.name = CellHelper.convertToChessNotation(x, y);
    }
}
