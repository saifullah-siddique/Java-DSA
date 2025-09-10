package LeetCode;

import java.util.Stack;

public class Validparanthese {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' ||ch == '(') {
                stack.add(s.charAt(i));
            } else if (!stack.isEmpty()) {
                char top = stack.peek();
                if ((top == '{' && ch == '}') || (top == '(' && ch == ')') || (top == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        String s = "(())";
        System.out.println(isValid(s));

    }
}
