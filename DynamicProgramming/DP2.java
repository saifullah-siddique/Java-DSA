package DynamicProgramming;

import java.util.Arrays;

public class DP2 {

    public static  int knapsack(int val[], int wt[], int w, int n) {//Normal Recursion
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n-1] <=w) {
            //include
            int include = val[n-1] + knapsack(val, wt, w-wt[n-1], n-1);
            //exclude
            int exclude = knapsack(val, wt, w, n-1);
            return Math.max(include, exclude);
        } else { //notvalid
            return knapsack(val, wt, w, n-1);
        } 
    }

    public static  int knapsack(int val[], int wt[],int dp[][], int w, int n) {//Memeoization 
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n-1] <=w) {
            //include
            int include = val[n-1] + knapsack(val, wt, dp, w-wt[n-1], n-1);
            //exclude
            int exclude = knapsack(val, wt, dp, w, n-1);
            return dp[n][w] = Math.max(include, exclude);
        } else { //notvalid
            return dp[n][w] =  knapsack(val, wt, dp, w, n-1);
        } 
    }

    public static int knapsackTabulation(int val[], int wt[], int W) {// Tabulation
        if (wt.length == 0 || W == 0) return 0;
        int n = wt.length;
        int dp[][] = new int[n+1][W+1];
        for (int i = 0; i <dp.length; i++) {
            dp[i][0] = 0; // 0th column
        }
        for (int j = 0; j <dp[0].length; j++) {
            dp[0][j] = 0; // 0th row
        }

        for(int i = 1; i < n+1; i++) {
            for(int j = 1 ; j < W+1; j++) {
                int v = val[i-1]; //ith item val
                int w = wt[i-1]; //ith item wt

                if (w <= j) {
                    int includeprofit = v + dp[i-1][j-w];
                    int excludeprofit = dp[i-1][j];
                    dp[i][j] = Math.max(includeprofit, excludeprofit);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        return dp[n][W];
    }

    public static void print(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};  
        // int wt[] = {2, 5, 1, 3, 4};
        int w = 7;
        int dp[][] = new int[val.length+1][w+1];
        for(int i = 0 ; i < dp.length ; i++) {
            Arrays.fill(dp[i], -1);
        }
        // System.out.println("Using Recursion :" + knapsack(val, wt,w, val.length));
        // System.out.println("Using Memoization DP :" + knapsack(val, wt,dp, w, val.length));
        // System.out.println("Using Tabulation : " + knapsackTabulation(val, wt, w));


        TargetSum.main(args);
        UnboundedKnapsack.main(args);

    }
    
}

class TargetSum {

    public static boolean targetSum(int val[], int sum) {
        int n = val.length;
        boolean dp[][] = new boolean[n+1][sum+1];
        //Intialization 
        for(int i = 0 ; i < dp.length; i++) {
            dp[i][0] = true;
        } 

        for(int i = 1 ; i < dp.length; i++) {
            for(int j = 1; j <dp[0].length ; j++) {
                int v = val[i-1];
                //include (valid)
                if (v <= j && dp[i-1][j-v] == true) {
                    dp[i][j] = true;
                } 
                //exclude (invalid)
                else if (dp[i-1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int val[] = {4,2,7,1,3};
        int sum = 10;
        System.out.println("Target Sum Exist : " + targetSum(val, sum));

    }
}


//---------------SAIFULLAH SIDDIQUI---------------------//

class UnboundedKnapsack {
    
    public static int unboundedKnapsack(int val[], int wt[], int W) {
        if(W == 0) return 0;
        int n = val.length;
        int dp[][] = new int[n+1][W+1];

        //intialization 
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0 ; j < dp.length ; j++) {
            dp[0][j] = 0;
        }

        //filling 
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j <dp[0].length ; j++) {
                int v = val[i-1] , w = wt[i-1];
                if (w <= j) {
                    int include = v + dp[i][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        System.out.println("Max value = " + unboundedKnapsack(val, wt, W));
    }
}


