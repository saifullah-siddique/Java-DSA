
import java.util.*;

public class StackB {

    public static void pushBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushBottom(stack, data);
        stack.push(top);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reverseStack(stack);
        pushBottom(stack, top);
    }

    public static String reverseString(String str) {
        Stack<Character> ch = new Stack<>();
        for(int i = 0 ; i < str.length(); i++) {
            ch.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!ch.isEmpty()) {
            sb.append(ch.pop());
        }
        return sb.toString();
    }

    public static void stockSpan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0]  = 1; 
        s.push(0);
        for(int i = 1 ; i <stock.length ; i++) {
            int currentPrice = stock[i];
            while (!s.isEmpty() && currentPrice > stock[s.peek()]) {
                s.pop(); 
            }
            if (s.isEmpty()) {
                span[i] = i+1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    public static void nextGreater(int arr[], int  nextGreater[]) {
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1 ; i  >= 0 ; i--) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();     
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()]; 
            }
            s.push(i);
        }
    }

    public static boolean validParenthesis(String str) {
        Stack<Character> ch = new Stack<>();
        for (int  i = 0 ; i < str.length() ; i++) {
            char current = str.charAt(i);
            if ( current == '(' || current == '{' || current == '[') {
                ch.push(current);
            } else {
                if (ch.isEmpty()) {
                    return false;
                }
                
                char top = ch.peek();
                if ((top == '(' && current == ')') || (top == '{' && current == '}') || (top == '[' && current == ']')) {
                    ch.pop();
                } else {
                    return false;
                }
            }
        }
        if (ch.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0 ; i < str.length() ; i++) {
            char curr = str.charAt(i);

            //closing 
            if (curr == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1 ) {
                    return true;
                }

            } else {
                s.push(curr);  
            }  
        }

        return false;
    }

    // public static void histogram(int arr[]) {
    //     int maxArea = 0 ;
    //     int nSR[] = new int[arr.length];
    //     int nSL[] = new int[arr.length];

    //     Stack<Integer> s = new Stack<>();
    //     for(int i = arr.length -1  ; i >= 0 ; i-- ) {

    //     }

    // }

    public static void main(String[] args) {
        //Stack s = new Stack();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(5);
        s.push(9);

        // //push at bottom of stack
        // pushBottom(s,2);

        // //Reverse stack 
        // reverseStack(s);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }

        // //revers a stirng using stack
        // String str = "bca";
        // System.out.println(str);
        // str = reverseString(str);
        // System.out.println(str);


        // //Stock Span Problem;
        // int stock[] = {100,80,60,70,60,85,100};
        // int span[] = new int[stock.length];
        // stockSpan(stock, span);
        
        // for(int i = 0 ; i < span.length ; i++) {
        //     System.out.print(span[i] + " ");
        // }


        // //Find next grater of an array
        // int arr[] = {6,8,0,1,3};
        // int nextGreater[] = new int[arr.length];
        // nextGreater(arr, nextGreater);

        // for(int i = 0 ; i < nextGreater.length ; i++) {
        //     System.out.print(nextGreater[i] + " ");
        // }


        // //Valid Parenthesis or not
        // String str =  "({})[]";
        // System.out.println(validParenthesis(str));


        // //Dublicate paranthesis
        // String str = "((a+b))";
        // System.out.println(isDuplicate(str));

        // //Max Area in Histogram
        // int heights[] = {2,1,5,6,2,3};
        // histogram(heights);


       
        
    }   
}
