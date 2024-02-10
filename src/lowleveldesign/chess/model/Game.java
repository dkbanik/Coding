package lowleveldesign.chess.model;

import java.util.List;
import java.util.Queue;

public class Game {
    Board board;
    Player playerA;
    Player playerB;
    Queue<Player> queue;
    GameStatus gameStatus;
    List<Move> moveHistory;

    public void initializeGame(){
        this.board = new Board();
        this.board.displayBoard();
    }
    public void startGame(){}

}
