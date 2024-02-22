package wrap.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            Integer[] row = new Integer[i];
            for(int j=0;j<i;j++){
                row[j] = 1;
                row[i-1] = 1;
            }
            for(int j=1;j<i-1;j++){
                List<Integer> prevList = result.get(i-2);
                row[j] = prevList.get(j-1)+prevList.get(j);
            }
            result.add(Arrays.asList(row));
        }
        return result;
    }
}
