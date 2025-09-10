package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Practiceq {
    
    public static void main(String[] args) {
        
        // TribonacciNumbers.main(args);

        BlancedParentheses.main(args);
    }
}


class TribonacciNumbers {

    public static void printdp(int dp[]) {
        for(int i = 0 ; i < dp.length; i++) {
            System.out.print(dp[i]);
            if (i != dp.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static int tirbTabulation(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2 ) return 1;

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        for(int i = 3 ; i < dp.length  ; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        printdp(dp);

        return dp[n];
    }

    public static int tribmemo(int n, int dp[]) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        return tribmemo(n-1, dp) + tribmemo(n-2, dp) + tribmemo(n-3, dp);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(tirbTabulation(n));
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(tribmemo(n, dp));
    }
}


class BlancedParentheses {

    public static void balacedPrantheseUtil(int n, int open, int close,String current, ArrayList<String> retsult) {
        if (open == n && close == n) {
            retsult.add(current);
            return;
        }

        if (open < n) {
            balacedPrantheseUtil(n, open +1, close, current + "{", retsult);
        }
        if (close < open) {
            balacedPrantheseUtil(n, open, close+1, current + "}", retsult);
        }

    }

    public static ArrayList<String> balacedPranthese(int n) {
        ArrayList<String> retsult = new ArrayList<>();
        balacedPrantheseUtil(n, 0, 0,"", retsult);
        return retsult;
    }



    public static void main(String[] args) {
        int n = 3;
        System.out.println(balacedPranthese(n));
    }
}
