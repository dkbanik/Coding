package wrap.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/triangle/
public class Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2),
                                                      Arrays.asList(3,4),
                                                      Arrays.asList(6,5,7),
                                                      Arrays.asList(4,1,8,3));

        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(triangle.get(0).get(0)));

        for(int i=1;i<size;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j == 0){
                    row.add(triangle.get(i).get(j)+result.get(i-1).get(0));
                }else if(j == i){
                    row.add(triangle.get(i).get(j)+result.get(i-1).get(i-1));
                }
                else{
                    row.add(triangle.get(i).get(j) + Math.min(result.get(i-1).get(j-1),result.get(i-1).get(j)));

                }
            }
            result.add(row);
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<result.size();i++){
            min = Math.min(min,result.get(size-1).get(i));
        }
        return min;
    }
}
