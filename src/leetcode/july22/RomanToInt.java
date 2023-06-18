package leetcode.july22;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s= "I";
        System.out.println(romanToInt(s));
    }

    public static int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L', 50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char[] chars = s.toCharArray();
        int len = chars.length;
        int i =0;
        int value = 0;
        while(i < len){
            char ch = chars[i];
            if(i< len-1 && (ch == 'I' || ch == 'X' || ch == 'C')){
                char nextCh = chars[i+1];
                if(ch == 'I' && nextCh == 'V') {
                    value+=4;i=i+2;
                }
                else if(ch == 'I' && nextCh == 'X') {
                    value+=9;i=i+2;
                }
                else if(ch == 'X' && nextCh == 'L') {
                    value+=40;i=i+2;
                }
                else if(ch == 'X' && nextCh == 'C') {
                    value+=90;i=i+2;
                }
                else if(ch == 'C' && nextCh == 'D') {
                    value+=400;i=i+2;
                }
                else if(ch == 'C' && nextCh == 'M') {
                    value+=900;i=i+2;
                }
                else {
                    value+=map.get(ch);
                    i++;
                }
            }else{
                value+=map.get(ch);
                i++;
            }

        }
        return value;
    }
}
