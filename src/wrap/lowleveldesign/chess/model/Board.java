package wrap.lowleveldesign.chess.model;

import wrap.lowleveldesign.chess.helper.CellHelper;
import wrap.lowleveldesign.chess.model.piece.Bishop;
import wrap.lowleveldesign.chess.model.piece.King;
import wrap.lowleveldesign.chess.model.piece.Knight;
import wrap.lowleveldesign.chess.model.piece.Pawn;
import wrap.lowleveldesign.chess.model.piece.Piece;
import wrap.lowleveldesign.chess.model.piece.Queen;
import wrap.lowleveldesign.chess.model.piece.Rook;

public class Board {
    private Cell[][] cells;
    private BoardStatus boardStatus;
    public Board(){
        cells = new Cell[8][8];
        this.setBoard();
        this.boardStatus = BoardStatus.IN_PLAY;
    }
    public void setBoardStatus(BoardStatus boardStatus) {
        this.boardStatus = boardStatus;
    }

    public void setBoard(){
        for(int x =0;x<8;x++){
            for(int y=0;y<8;y++){
                cells[x][y] = new Cell(x,y);
            }
        }

        cells[0][0] = new Cell(0,0, new Rook(Color.BLACK));
        cells[1][0] = new Cell(1,0, new Knight(Color.BLACK));
        cells[2][0] = new Cell(2,0, new Bishop(Color.BLACK));
        cells[3][0] = new Cell(3,0, new Queen(Color.BLACK));
        cells[4][0] = new Cell(4,0, new King(Color.BLACK));
        cells[5][0] = new Cell(5,0, new Bishop(Color.BLACK));
        cells[6][0] = new Cell(6,0, new Knight(Color.BLACK));
        cells[7][0] = new Cell(7,0, new Rook(Color.BLACK));

        cells[0][7] = new Cell(0,7, new Rook(Color.WHITE));
        cells[1][7] = new Cell(1,7, new Knight(Color.WHITE));
        cells[2][7] = new Cell(2,7, new Bishop(Color.WHITE));
        cells[3][7] = new Cell(3,7, new Queen(Color.WHITE));
        cells[4][7] = new Cell(4,7, new King(Color.WHITE));
        cells[5][7] = new Cell(5,7, new Bishop(Color.WHITE));
        cells[6][7] = new Cell(6,7, new Knight(Color.WHITE));
        cells[7][7] = new Cell(7,7, new Rook(Color.WHITE));

        for(int x=0;x<8;x++){
            cells[x][1] = new Cell(x,1,new Pawn(Color.BLACK));
            cells[x][6] = new Cell(x,6, new Pawn(Color.WHITE));
        }
    }
    public BoardStatus getBoardStatus() {
        return boardStatus;
    }

    public Cell getCell(int x, int y){
        if(x > 7 || x < 0 || y > 7 || y < 0) return null;
        return cells[x][y];
    }
    public Cell getCellbyName(String name){
        int[] xy = CellHelper.getChessCellCoordinate(name);
        return getCell(xy[0], xy[1]);
    }

    public boolean isEmptyCell(int x, int y){
        return cells[x][y].getPiece() == null ;
    }
    public void displayBoard(){
        System.out.println("-----------------------------------------");
        for (int i=0;i<8;i++){
            System.out.print("| ");
            for(int j=0;j<8;j++){
                if (getCell(j, i) != null){
                    Piece pieceName = getCell(j, i).getPiece();
                    if(pieceName != null)System.out.print(getCell(j, i).getPiece() + "  | ");
                    else System.out.print("   | ");
                }
                else {
                    System.out.print("   | ");
                }
            }
            System.out.println();
            System.out.println("-----------------------------------------");
        }
    }
}
