package DynamicProgramming;

import java.util.Arrays;

public class DP6 {

    public static void printDP(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        // MatrixChainMultiplication.main(args);

        // MinimumPartitioning.main(args);

        MinArrayJumps.main(args);
    }
}

class MatrixChainMultiplication {

    public static int recusionMCM(int arr[], int i, int j) {
        if (i == j) return 0;

        int ans = Integer.MAX_VALUE;

        for(int k = i ; k < j ; k++) {
            int setACost = recusionMCM(arr, i, k); // Ai...Ak => arr[i-1] X arr[k]
            int setBCost = recusionMCM(arr, k+1, j); // Ai+1.....Aj => arr[k] X arr[j]
            int AnswerSetCost = arr[i-1] * arr[k] * arr[j];
            int finalCost = setACost + setBCost + AnswerSetCost;
            ans = Math.min(ans, finalCost);
        } 

        return ans;

    }

    public static int memoizationMCM(int arr[], int i, int j, int dp[][]) {
        if (i == j) return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k = i ; k < j ; k++) {
            int setACost = memoizationMCM(arr, i, k, dp); // Ai...Ak => arr[i-1] X arr[k]
            int setBCost = memoizationMCM(arr, k+1, j, dp); // Ai+1.....Aj => arr[k] X arr[j]
            int answereSetCost = arr[i-1] * arr[k] * arr[j];
            int finalCost = setACost + setBCost + answereSetCost;
            ans = Math.min(ans, finalCost);
        }

        return dp[i][j] = ans;

    }

    public static int tabulationMCM(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            dp[i][i] = 0;
        }

        for(int len = 2 ; len < n ; len++) {
            for(int i = 1 ; i <= n-len; i++ ) {
                int j = i + len -1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k < j ; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int resultCost = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1 + cost2 + resultCost);
                } 
            }
        }

        DP6.printDP(dp);

        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        System.out.println(recusionMCM(arr, 1, n-1));

        int dp[][] = new int[n][n];
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(memoizationMCM(arr, 1, n-1, dp));

        System.out.println(tabulationMCM(arr));

    }
}


class MinimumPartitioning {

    public static int minimumPartitioning(int nums[]) {
        int arrSum = 0 ; 
        for(int i = 0 ; i < nums.length ; i++) {
            arrSum += nums[i];
        }
        int W = arrSum / 2;
        int n = nums.length;
        int dp[][] = new int[n+1][W+1];

        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1; j < W+1 ; j++) {
                int v = nums[i-1];
                int w = nums[i-1];
                if (w <= j) {
                    int include = v + dp[i-1][j-w];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = arrSum - sum1;
        return Math.abs(sum1-sum2);
    }

    public static void main(String[] args) {
        int arr[] = {1, 6, 11, 5};
        System.out.println(minimumPartitioning(arr));
    }
}


class MinArrayJumps {

    public static int minArrayJumps(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for(int j = i+1 ; j <= i+steps && j < n ; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println(minArrayJumps(arr));
    }
}