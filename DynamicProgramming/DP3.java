package DynamicProgramming;

public class DP3 {

    public static void main(String[] args) {
        // // Coin Change 
        // CoinChange.main(args);

        // // Rod Cutting 
        // RodCutting.main(args);

        // Longest Common Subsequence
        LongestCommonSubsequence.main(args);

    }

}

class CoinChange {
    
    public static int countwaysCoinChange(int coins[], int sum) {
        if (sum == 0 ) return 1;  
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1 ; i <dp[0].length ; i++) {
            dp[0][i] = 0 ;
        }

        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[i].length ; j++) {
                int c = coins[i-1];
                if (c <= j) {
                    dp[i][j] = dp[i][j-c] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = {2, 5, 3, 6};
        int sum = 10;
        System.out.println(countwaysCoinChange(coins, sum));
    }
}

class RodCutting {

    public static int rodCutting(int length[], int price[] , int rodlength) {
        if (rodlength == 0 ) return 0;
        int n = length.length;
        int dp[][] = new int[n+1][rodlength+1];
        
        for (int i = 0 ; i < dp.length ; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0 ; i < dp[0].length ; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1 ; i < dp.length ; i++) {
            for (int j = 1 ; j < dp[i].length ; j++) {
                int p = price[i-1] , l = length[i-1];
                if (l <= j) {
                    dp[i][j] = Math.max( p + dp[i-1][j-l], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][rodlength];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodlength = 8;
        System.out.println(rodCutting(length, price, rodlength));
    }
}

class LongestCommonSubsequence {

    public static int recursion(String str1, String str2, int n ,int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if ( str1.charAt(n-1) == str2.charAt(m-1)) {
            return recursion(str1, str2, n-1, m-1) +1;
        } else {
            int case1 = recursion(str1, str2, n-1, m);
            int case2 = recursion(str1, str2, n, m-1);
            return Math.max(case1, case2);
        }
    }  

    public static int memoization(String str1, String str2, int n ,int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if ( str1.charAt(n-1) == str2.charAt(m-1)) {
            return dp[n][m] =  memoization(str1, str2, n-1, m-1, dp) +1;
        } else {
            int case1 = memoization(str1, str2, n-1, m, dp);
            int case2 = memoization(str1, str2, n, m-1, dp);
            return dp[n][m]  = Math.max(case1, case2);
        }
    }  

    public static int tabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n == 0 || m == 0 ) return 0;
        int dp[][] = new int[n+1][m+1];

         

        for(int  i = 1 ; i < dp.length ; i++) {
            for (int j = 1 ; j < dp[i].length ; j++) {
                if ( str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] =   dp[i-1][j-1] + 1; 
                } else {
                    dp[i][j] += Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n =  str1.length() , m = str2.length();
        System.out.println(recursion(str1, str2, n, m));

        // memoization
        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[i].length ; j++) {
                dp[i][j] = -1;
            }
        }
        memoization(str1, str2, n, m, dp);
        System.out.println(dp[n][m]);

        System.out.println(tabulation(str1, str2));
    }
}
