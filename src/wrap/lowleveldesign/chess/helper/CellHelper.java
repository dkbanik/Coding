package wrap.lowleveldesign.chess.helper;

public class CellHelper {
    public static String convertToChessNotation(int x, int y){
        char file = (char) ('a' + x);
        int rank = 8 - y;

        return String.valueOf(file) + rank;
    }

    public static int[] getChessCellCoordinate(String name) {

        char file = name.charAt(0);
        int rank = Character.getNumericValue(name.charAt(1));

        int x = file - 'a';
        int y = 8 - rank;

        return new int[]{x,y};
    }

}
