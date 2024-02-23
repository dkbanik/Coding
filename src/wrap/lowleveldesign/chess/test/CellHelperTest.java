package wrap.lowleveldesign.chess.test;


import wrap.lowleveldesign.chess.helper.CellHelper;

public class CellHelperTest {
    public static void main(String[] args) {
        String ans = CellHelper.convertToChessNotation(4, 6);
        System.out.println(ans);

        int[] xy = CellHelper.getChessCellCoordinate(ans);
        System.out.println(xy[0]+" "+xy[1]);

        int[] yz = CellHelper.getChessCellCoordinate("e4");
        System.out.println(yz[0]+" "+yz[1]);
    }

}
