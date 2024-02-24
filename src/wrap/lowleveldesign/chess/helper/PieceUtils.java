package wrap.lowleveldesign.chess.helper;

import wrap.lowleveldesign.chess.model.Board;
import wrap.lowleveldesign.chess.model.Cell;

public class PieceUtils {
    public static boolean canMoveHorizontal(Board board, Cell from, Cell to){
        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();
        // check if its horizontal move
        if(fromY == toY && fromX != toX){
            int step = toX > fromX ? 1 : -1;
            for(int x = fromX + step; x != toX; x+=step){
                if(!board.isEmptyCell(x, toY)) return false;
            }
            return board.isEmptyCell(toX, toY) ||
                    board.getCell(toX, toY).getPiece().getColor() != board.getCell(fromX, fromY).getPiece().getColor();
        }
        return false;
    }

    public static boolean canMoveVertical(Board board, Cell from, Cell to){
        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();
        // check if move is vertical
        if(fromX == toX && fromY != toY){
            int step = toY > fromY ? 1 : -1;
            for(int y = fromY + step; y != toY; y+=step){
                if(!board.isEmptyCell(toX, y)) return false;
            }
            return board.isEmptyCell(toX, toY) ||
                    board.getCell(toX, toY).getPiece().getColor() != board.getCell(fromX, fromY).getPiece().getColor();
        }
        return false;
    }

    public static boolean canMoveDiagonal(Board board, Cell from, Cell to){
        int fromX = from.getX();
        int fromY = from.getY();
        int toX = to.getX();
        int toY = to.getY();

        if(Math.abs(toX - fromX) == Math.abs(toY - fromY)){
            int xDirection = toX > fromX ? 1 : -1;
            int yDirection = toY > fromY ? 1 : -1;

            int curX = fromX + xDirection;
            int curY = fromY + yDirection;
            while(curX != toX && curY != toY){
                // if there is piece inbetween
                if(!board.isEmptyCell(curX, curY)){
                    return false;
                }
                curX+=xDirection;
                curY+=yDirection;
            }
            // check if to Cell is empty or has piece of opp color
            return board.isEmptyCell(toX, toY) ||
                    board.getCell(toX,toY).getPiece().getColor() != board.getCell(fromX, fromY).getPiece().getColor();
        }
        return false;
    }
}
