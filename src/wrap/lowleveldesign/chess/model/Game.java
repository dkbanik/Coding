package wrap.lowleveldesign.chess.model;

import java.util.LinkedList;
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
        playerA = new Player("A", Color.WHITE);
        playerB = new Player("B", Color.BLACK);
        queue = new LinkedList<>();
        queue.add(playerA);
        queue.add(playerB);
        this.board.displayBoard();
        //this.startGame();
    }
    public void startGame(){
        Player currentPlayer = playerA.color == Color.WHITE ? playerA : playerB;

        // create a move which takes from & to and which piece to move
        Move move = new Move(currentPlayer, "e2", "e4", board.getCellbyName("e2").piece);
        // check if the move is valid
        boolean isValidMove = move.isValid(board);
    }

}
