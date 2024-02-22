package wrap.lowleveldesign.chess.model;


import wrap.lowleveldesign.chess.model.piece.Piece;

public class Move {

    public Player player;
    public String from;
    public String to;
    public Piece piece;

    public Move(Player player, String from, String to, Piece piece) {
        this.player = player;
        this.from = from;
        this.to = to;
        this.piece = piece;
    }

    public boolean isValid(Board board){
        return piece.canMove(board, board.getCellbyName(this.from), board.getCellbyName(this.to));
    }
}
