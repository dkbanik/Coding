package wrap.lowleveldesign.chess.model;


import wrap.lowleveldesign.chess.helper.CellHelper;
import wrap.lowleveldesign.chess.model.piece.Piece;

public class Cell {
    private int x;
    private int y;
    private String name; // a1 ...h8
    private Piece piece;

    public int getX(){return x;}
    public int getY(){return y;}

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
