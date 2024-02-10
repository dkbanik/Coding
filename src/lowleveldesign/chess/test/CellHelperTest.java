package lowleveldesign.chess.test;


import lowleveldesign.chess.helper.CellHelper;

public class CellHelperTest {
    public static void main(String[] args) {
        String ans = CellHelper.convertToChessNotation(0, 7);
        System.out.println(ans);

        int[] xy = CellHelper.getChessCellCoordinate(ans);
        System.out.println(xy[0]+" "+xy[1]);
    }

}
