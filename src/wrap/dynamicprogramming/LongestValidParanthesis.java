package wrap.dynamicprogramming;

import java.util.Stack;
//https://www.youtube.com/watch?v=VdQuwtEd10M
public class LongestValidParanthesis {
    public static void main(String[] args) {
        String str = ")(()))))()()())";
        System.out.println(longestValidParenthesesV2(str));
    }
    // time - O(n) space - O(n)
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    int len = i - stack.peek();
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        return maxLen;
    }
    // time - O(n) space - O(n)
    public static int longestValidParenthesesV2(String s) {
        // ")(()))))()()())"
        int open = 0; int close = 0;
        int max = 0;

        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                int len = open+close;
                max = Math.max(max, len);
            }
            else if(close > open){
                open = close = 0;
            }
        }
        open = close = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                close++;
            }
            if(open == close){
                int len = open+close;
                max = Math.max(max, len);
            }
            else if(open > close){
                open = close = 0;
            }
        }
        return max;
    }
}
