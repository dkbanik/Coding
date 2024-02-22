package wrap.topinterviewmedium;

import java.util.HashMap;
import java.util.Map;
/*
* Youtube application on a Smart TV

A B C D
E F G H
I J K L
M N O P
Q R S T (4,3)
U V W X
Y Z  (6,(1,2,3))
SPACE


Write a function which returns minimum number of clicks
you will have to do in order to search for a term, given the following
constraints:
- Starting point is A
- You can move UP, DOWN, LEFT, RIGHT
- You will have to click the letter as well
eg:
input output
WHATFIX 43*/
public class MinClicks {
    public static void main(String[] args) {
        Map<Character, int[]> map = new HashMap<>();
        constructGridMap(map);
        String input = "WHATFIX A";
        int ans = minClicks(map,input);
        System.out.println(ans);
    }

    public static void constructGridMap(Map<Character,int[]> map){
        map.put('A', new int[]{0, 0});
        map.put('B', new int[]{0,1});
        map.put('C',new int[]{0,2});
        map.put('D', new int[]{0,3});

        map.put('E', new int[]{1, 0});
        map.put('F', new int[]{1,1});
        map.put('G',new int[]{1,2});
        map.put('H', new int[]{1,3});

        map.put('I', new int[]{2, 0});
        map.put('J', new int[]{2,1});
        map.put('K',new int[]{2,2});
        map.put('L', new int[]{2,3});

        map.put('M', new int[]{3, 0});
        map.put('N', new int[]{3,1});
        map.put('O',new int[]{3,2});
        map.put('P', new int[]{3,3});

        map.put('Q', new int[]{4, 0});
        map.put('R', new int[]{4,1});
        map.put('S',new int[]{4,2});
        map.put('T', new int[]{4,3});

        map.put('U', new int[]{5, 0});
        map.put('V', new int[]{5,1});
        map.put('W',new int[]{5,2});
        map.put('X', new int[]{5,3});

        map.put('Y', new int[]{6, 0});
        map.put('Z', new int[]{6,1});

        map.put(' ', new int[]{7,0});

    }

    public static int minClicks(Map<Character, int[]> map, String input){
        int clicks =0;
        int i=0;int j=0;
        int len = input.length();
        for(int k=0;k<len;k++){
            Character ch = input.charAt(k);
            int[] charCor = map.get(ch);
            clicks+=Math.abs(charCor[0]-i);
            if(ch == 'Z' && j != 0){
                charCor[1] = j;
            }
            if(ch == ' '){
                charCor[1] = j;
            }
            clicks+=Math.abs(charCor[1]-j);
            clicks++;
            i=charCor[0];
            j=charCor[1];
        }
        return clicks;
    }
}
