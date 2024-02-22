package wrap.lowleveldesign.chess.model;



import wrap.lowleveldesign.chess.helper.CellHelper;
import wrap.lowleveldesign.chess.model.piece.Bishop;
import wrap.lowleveldesign.chess.model.piece.King;
import wrap.lowleveldesign.chess.model.piece.Knight;
import wrap.lowleveldesign.chess.model.piece.Pawn;
import wrap.lowleveldesign.chess.model.piece.Queen;
import wrap.lowleveldesign.chess.model.piece.Rook;

import java.util.HashMap;
import java.util.Map;

public class Board {
    Cell[][] cells;
    Map<String, Cell> cellName = new HashMap<>();

    Board(){
        cells = new Cell[8][8];
        this.setBoard();
    }
    public void setBoard(){
        cells[0][0] = new Cell(0,0, new Rook(Color.BLACK));
        cells[0][1] = new Cell(0,1, new Knight(Color.BLACK));
        cells[0][2] = new Cell(0,2, new Bishop(Color.BLACK));
        cells[0][3] = new Cell(0,3, new Queen(Color.BLACK));
        cells[0][4] = new Cell(0,4, new King(Color.BLACK));
        cells[0][5] = new Cell(0,5, new Bishop(Color.BLACK));
        cells[0][6] = new Cell(0,6, new Knight(Color.BLACK));
        cells[0][7] = new Cell(0,7, new Rook(Color.BLACK));

        cells[7][0] = new Cell(7,0, new Rook(Color.WHITE));
        cells[7][1] = new Cell(7,1, new Knight(Color.WHITE));
        cells[7][2] = new Cell(7,2, new Bishop(Color.WHITE));
        cells[7][3] = new Cell(7,3, new Queen(Color.WHITE));
        cells[7][4] = new Cell(7,4, new King(Color.WHITE));
        cells[7][5] = new Cell(7,5, new Bishop(Color.WHITE));
        cells[7][6] = new Cell(7,6, new Knight(Color.WHITE));
        cells[7][7] = new Cell(7,7, new Rook(Color.WHITE));

        for(int y=0;y<8;y++){
            cells[1][y] = new Cell(1,y,new Pawn(Color.BLACK));
            cells[6][y] = new Cell(6,y, new Pawn(Color.WHITE));
        }
    }

    public Cell getCell(int x, int y){
        if(x > 7 || x < 0 || y > 7 || y < 0) return null;
        return cells[x][y];
    }
    public Cell getCellbyName(String name){
        int[] xy = CellHelper.getChessCellCoordinate(name);
        return getCell(xy[0], xy[1]);
    }

    public Cell moveRight(Cell currentCell){
        return getCell(currentCell.x+1, currentCell.y);
    }
    public Cell moveLeft(Cell currentCell){
        return getCell(currentCell.x-1, currentCell.y);
    }
    public Cell moveUp(Cell currentCell){
        return getCell(currentCell.x, currentCell.y+1);
    }
    public Cell moveDown(Cell currentCell){
        return getCell(currentCell.x, currentCell.y-1);
    }
    public Cell moveTopRight(Cell currentCell){
        return getCell(currentCell.x+1, currentCell.y+1);
    }
    public Cell moveTopLeft(Cell currentCell){
        return getCell(currentCell.x-1, currentCell.y+1);
    }
    public Cell moveBottomRight(Cell currentCell){
        return getCell(currentCell.x+1, currentCell.y-1);
    }
    public Cell moveBottomLeft(Cell currentCell){
        return getCell(currentCell.x-1, currentCell.y-1);
    }
    public void displayBoard(){
        System.out.println("------------------------------");
        for (int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (getCell(i, j) != null)
                    System.out.print(getCell(i, j).piece.toString() + " | ");
                else {
                    System.out.print("  | ");
                }
            }
            System.out.println();
            System.out.println("------------------------------");
        }
    }
}
