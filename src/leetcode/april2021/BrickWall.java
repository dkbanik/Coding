package leetcode.april2021;
import java.util.*;
public class BrickWall {
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
//        wall.add(Arrays.asList(2));
//        wall.add(Arrays.asList(2));
//        wall.add(Arrays.asList(2));

        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        System.out.println("Ans is: "+leastBricks(wall));

    }
    public static int leastBricks(List<List<Integer>> wall) {
        int width=0;
        int height = wall.size();
        for(int i: wall.get(0)){
            width+=i;
        }

        Map<Integer,Integer> brickMap = new HashMap<>();
        for(List<Integer> row: wall){
            int sum=0;
            for(int j=0; j<row.size()-1;j++){
                int val = sum+=row.get(j);
                brickMap.put(val,brickMap.getOrDefault(val,0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry: brickMap.entrySet()){
            if(max < entry.getValue()) max=entry.getValue();
        }

        return brickMap.size()==0?height:height-max;
    }
}
