package DynamicProgramming;

public class DP1 {
    public static int fibbonacchi(int n, int f[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (f[n] != 0) {
            return f[n];
        }

        f[n] = fibbonacchi(n-1,f) + fibbonacchi(n-2,f);
        return f[n];
    }

    public static int fib(int n, int f[]) {
        f[0] = 0;
        f[1] = 1;

        for(int i = 2 ; i <= n ; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }


    //Climbing Stairs Dynamic Programming 
    public static int climbingStairs(int n) { //Normal Recurion //O(n^n)
        if (n < 0) return 0;
        if (n == 0) return 1;

        return climbingStairs(n-1) + climbingStairs(n-2);
    }

    public static int climbingStairsDP(int n, int dp[]) { // Memoization Dynamic Programming, T-C = O(n)
        if (n < 0) return 0;
        if (n == 0) return 1;

        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbingStairsDP(n-1,dp) + climbingStairsDP(n-2,dp);
        return dp[n];

    }

    public static int climbingStairsDP(int n) {// Tabulation(Itarative) Dynamic Programming, T-C O(n);
        if (n < 0) return 0;
        if (n == 0) return 1;


        int ways[] = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for(int i = 2 ; i<=n ; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
 
        return ways[n];
    }

    public static void main(String[] args) {
        int n = 40;
        int N = n < 0 ? 0 : n;
        int f[] = new int[N+1];
        // System.out.println(fib(n, f));
        // System.out.println(fibbonacchi(n,f));


        //Climbing Stairs
        System.out.println("Recursive : " + climbingStairs(n));
        System.out.println("Recursive DP : " + climbingStairsDP(n, f)); // Memoization 
        System.out.println("Itarative DP : " + climbingStairsDP(n)); //tabulation 
        
    }
}
 