package wrap.lowleveldesign.chess.model;


import wrap.lowleveldesign.chess.model.piece.King;
import wrap.lowleveldesign.chess.model.piece.Piece;

public class Move {

    private Player player;
    private String from;
    private String to;
    private Piece piece;

    public Move(Player player, String from, String to, Piece piece) {
        this.player = player;
        this.from = from;
        this.to = to;
        this.piece = piece;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean isValid(Board board){
        return piece.canMove(board, board.getCellbyName(this.from), board.getCellbyName(this.to));
    }

    public void execute(Board board){
        Cell fromCell = board.getCellbyName(this.from);
        Cell toCell = board.getCellbyName(this.to);
        if(toCell.getPiece() != null){
            toCell.getPiece().setKilled(true);
            if(toCell.getPiece() instanceof King){
               BoardStatus status = toCell.getPiece().getColor() == Color.WHITE ? BoardStatus.BLACK_WIN : BoardStatus.WHITE_WIN;
               board.setBoardStatus(status);
            }
        }
        toCell.setPiece(this.piece);
        fromCell.setPiece(null);
    }
}
