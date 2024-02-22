package wrap.topinterviewmedium;

import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        int len = s.length();
        if(len == 0)return false;
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<len;i++){
            Character ch = s.charAt(i);
            switch (ch){
                case '(':
                case '{':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '{') {
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '[') {
                        stack.pop();
                    }
                    else{
                        return false;
                    }
                    break;

            }
        }
        return stack.isEmpty();
    }
}
