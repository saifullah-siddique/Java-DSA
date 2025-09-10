package DynamicProgramming;

import java.util.Arrays;

public class DP5 {
    
    public static void main(String[] args) {
        
        // WildcardMatching.main(args);

        // CatlansNumber.main(args);

        // CountingTrees.main(args);

        MountainRanges.main(args);

    } 
}

class WildcardMatching {

    public static void printdp(boolean dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for (int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean wildCardMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        if ( n == 0 && m == 0) return true;
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int i = 1 ; i < dp.length; i++) {
            dp[i][0] = false;
        }
        for(int j = 1 ; j < dp[0].length; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1] ;
            } else {
                dp[0][j] = false;
            }
        }

        for(int i =1 ; i < dp.length; i++) {
            for(int j =1 ; j <dp[i].length; j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }

     

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "baaabab";
        String p = "*****ba*****ab";

        System.out.println(wildCardMatching(s, p));

    }
}

class CatlansNumber {
    
    public static int recursion(int n){
        if (n == 0 || n == 1) {
            return 1;
        }

        int ans = 0;
        for (int i = 0 ; i < n ; i++) {
            ans += recursion(i) * recursion(n - i - 1);
        }
        return ans;
        
    }


    public static int memoization(int n, int dp[]){
        if (n == 0 || n == 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = 0;
        for (int i = 0 ; i < n ; i++) {
            ans += memoization(i, dp) * memoization(n - i - 1, dp);
        }

        return dp[n] = ans;   
    }

    public static int tabulation(int n) {
        if (n == 0 || n == 1) return 1;
        int dp[] = new int[n+1];
 
        dp[0] = dp[1] = 1;

        for (int i = 2 ; i < dp.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                dp[i]+= dp[j] *dp[i-j-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(recursion(n));

        System.out.println(memoization(n, dp));

        System.out.println(tabulation(n));

    }
}


class CountingTrees {
    public static int countBST(int n) {
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2 ; i < dp.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                dp[i] += dp[j] * dp[i - j -1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countBST(n));
    }
}

class MountainRanges {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(CatlansNumber.tabulation(n));
    }
}
