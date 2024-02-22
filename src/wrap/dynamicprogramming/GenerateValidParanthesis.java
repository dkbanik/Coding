package wrap.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParanthesis {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for(String s : result){
            System.out.print(s+", ");
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis(n,n,"",list);
        return list;
    }

    public static void generateParenthesis(int open, int close, String s, List<String> list) {
        if(open == 0 && close == 0){
            list.add(s);
            return;
        }

        if(open != 0){
            generateParenthesis(open-1, close, s+"(", list);
        }

        if(close > open){
            generateParenthesis(open, close-1, s+")",list);
        }
    }
}
