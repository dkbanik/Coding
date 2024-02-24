package wrap.lowleveldesign.tictactoe;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Winner is: "+game.start());
    }
}
