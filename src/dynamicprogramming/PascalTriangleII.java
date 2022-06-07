package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {

    public static void main(String[] args) {
        List<Integer> list = getRow(4);

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0){
            return list;
        }

        for(int i=1;i<=rowIndex;i++){
            Integer[] row = new Integer[i+1];
            row[0] = 1;
            row[i] = 1;
            for(int j=1;j<i;j++){
                row[j] = list.get(j-1)+list.get(j);
            }
            list = Arrays.asList(row);
        }
        return list;
    }
}
