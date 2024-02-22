package wrap.leetcode.april2021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/explore/featured/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3726/
public class PowerfulIntegers {
    public static void main(String[] args) {
        int x=2, y=91, bound = 996;
        List<Integer> ans = powerfulIntegers(x,y,bound);
        System.out.println(ans);
        //[33,2,3,5,65,129,9,107,257,513,17,99,155,219,603,347,123,92,93,95]
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        int maxX = (x==1)? 1: (int) (Math.log(bound)/ Math.log(x));
        System.out.println(maxX);
        int maxY = (y==1) ? 1:(int) (Math.log(bound)/ Math.log(y));
        System.out.println(maxY);

        List<Integer> temp = new ArrayList<>();
        int min_of_x_y = Math.min(x,y);
        int max_of_x_y = Math.max(x,y);
        int max = Math.max(maxX,maxY);
        for(int i=0;i<=max;i++){
            temp.add((int)Math.pow(min_of_x_y, i));
        }
        for(int i=0;i<=max;i++){
            int value = (int)Math.pow(max_of_x_y, i);
            if(value<bound)
                temp.add(value);
            else break;
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0;i<=max;i++){
            for(int j=max+1;j<temp.size();j++){
                int sum = temp.get(i)+temp.get(j);
                if(sum<=bound) set.add(sum);
            }
        }
        return new ArrayList<>(set);
    }
}
