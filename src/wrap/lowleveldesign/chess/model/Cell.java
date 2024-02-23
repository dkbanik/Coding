package wrap.lowleveldesign.chess.model;


import wrap.lowleveldesign.chess.helper.CellHelper;
import wrap.lowleveldesign.chess.model.piece.Piece;

public class Cell {
    public int x;
    public int y;
    public String name; // a1 ...h8
    public Piece piece;

    public int getRow(){
        return y;
    }
    public int getCol(){
        return x;
    }

    public Cell(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
        this.name = CellHelper.convertToChessNotation(x, y);
    }

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.name = CellHelper.convertToChessNotation(x,y);
    }
}
