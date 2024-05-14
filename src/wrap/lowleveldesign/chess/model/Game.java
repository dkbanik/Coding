package wrap.lowleveldesign.chess.model;

import java.util.*;

public class Game {
    private Board board;
    private Player playerA;
    private Player playerB;
    private List<Move> moveHistory;

    public void initializeGame(){
        this.board = new Board();
        playerA = new Player("A", Color.WHITE);
        playerB = new Player("B", Color.BLACK);
        this.board.displayBoard();
        moveHistory = new ArrayList<>();
    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = playerA.color == Color.WHITE ? playerA : playerB;
        while (board.getBoardStatus() == BoardStatus.IN_PLAY){
            boolean isValidMove;
            Move move;
            System.out.println("Player "+currentPlayer.name +" enter your move!");
            do {
                String moveStr = scanner.nextLine();
                String from = moveStr.substring(0,2);
                String to = moveStr.substring(2,4);
                move = new Move(currentPlayer, from, to, board.getCellbyName(from).getPiece());
                // check if the move is valid
                isValidMove = move.isValid(board);
                System.out.println("move is valid: "+isValidMove);
                if(!isValidMove)System.out.println("Player "+currentPlayer.name +" enter your move again!");
            }while (!isValidMove);

            move.execute(board);
            moveHistory.add(move);
            board.displayBoard();

            currentPlayer = (currentPlayer == playerA) ? playerB : playerA;
        }
        System.out.println("Game Result "+board.getBoardStatus());
    }

}
