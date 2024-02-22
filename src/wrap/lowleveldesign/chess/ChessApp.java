package wrap.lowleveldesign.chess;


import wrap.lowleveldesign.chess.model.Game;

public class ChessApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
    }
}
