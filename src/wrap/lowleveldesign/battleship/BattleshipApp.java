package wrap.lowleveldesign.battleship;

import wrap.lowleveldesign.battleship.model.Board;
import wrap.lowleveldesign.battleship.model.Player;

public class BattleshipApp {
    public static void main(String[] args) {
        Board board = new Board(8, new Player());
        board.printBoard();
    }
}
