package wrap.lowleveldesign.tictactoe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    Deque<Player> players;
    Board board;

    Game(){
        this.players = new LinkedList<>();
        this.board = new Board(3);
        Player playerA = new Player("A", new Piece(PieceType.X));
        Player playerB = new Player("B", new Piece(PieceType.O));

        this.players.add(playerA);
        this.players.add(playerB);

    }

    public String start(){
        String winner = "tie";
        boolean noWinner = true;

        while(board.hasFreeSpace() && noWinner){
            board.display();
            Player currentPlayer = this.players.removeFirst();

            System.out.println("Player "+currentPlayer.name +": Enter row, column: ");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            String[] values = line.split(",");
            int row = Integer.valueOf(values[0]);
            int col = Integer.valueOf(values[1]);

            boolean addPiece = board.placePiece(row, col, currentPlayer.piece);
            if(!addPiece){
                System.out.println("Incorrect position, re-enter");
                players.addFirst(currentPlayer);
                continue;
            }
            players.addLast(currentPlayer);
            boolean isWinner = checkWinner(row, col, currentPlayer.piece);
            if(isWinner){
                noWinner = false;
                winner = currentPlayer.name;
            }
        }
        board.display();
        return winner;
    }

    private boolean checkWinner(int currentRow, int currentCol, Piece currentPiece) {

        boolean horizontalMatch = true;
        boolean verticalMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonal = true;

        for(int j=0; j<board.size;j++){
            if(board.board[currentRow][j] == null || board.board[currentRow][j] != currentPiece){
                horizontalMatch = false;
            }
        }

        for(int i=0;i< board.size;i++){
            if(board.board[i][currentCol] == null || board.board[i][currentCol] != currentPiece){
                verticalMatch = false;
            }
        }

        if(board.board[0][0] != currentPiece || board.board[1][1] != currentPiece || board.board[2][2] != currentPiece){
            diagonalMatch = false;
        }
        if(board.board[0][2] != currentPiece || board.board[1][1] != currentPiece || board.board[2][0] != currentPiece){
            antiDiagonal = false;
        }

        return horizontalMatch || verticalMatch || diagonalMatch || antiDiagonal;
    }
}
