package lowleveldesign.battleship;

import lowleveldesign.battleship.model.Board;
import lowleveldesign.battleship.model.Player;

public class BattleshipApp {
    public static void main(String[] args) {
        Board board = new Board(8, new Player());
        board.printBoard();
    }
}
