package DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;

public class DP4 {
    public static void main(String[] args) {

        // LongestCommonSubstring.main(args);

        // LongestIncreasingSubsequence.main(args);

        // EditDistance.main(args);

        StringConversion.main(args);

    }
}

class LongestCommonSubstring {
    public static int longestcommonsubstring(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if (n == 0 || m == 0 ) {
            return 0;
        }
        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0 ; i < dp[0].length ; i++) {
            dp[0][i] = 0;
        }

        int ans = 0;
        for (int i = 1 ; i < dp.length; i++) {
            for (int j = 1 ; j < dp[i].length ; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "SAIF";
        String str2 = "SAIFULLAH";
        System.out.println(longestcommonsubstring(str1, str2));
    }
}

class LongestIncreasingSubsequence {
    
    public static int longestIncreasingSubsequence(int arr[]) {
        if (arr.length == 0 ) return 0 ;
        HashSet<Integer> set = new HashSet<>();
        for( int i = 0 ; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];

        int i = 0;
        for( int  num : set) {
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);

        return lcs(arr, arr2);
    }

    public static int lcs(int arr[], int arr2[]) {
        int n = arr.length;
        int m = arr2.length;
        
        int dp[][] = new int[n+1][m+1];

        for (int i = 1 ; i < dp.length ; i++) {
            for (int j = 1 ; j < dp[i].length ; j++) {
                if(arr[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int arr[] = {50, 3, 10, 7, 40, 80};
        System.out.println(longestIncreasingSubsequence(arr));
    }
}


class EditDistance {

    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if ( n == 0 && m == 0) return 0;
        int dp[][] = new int[n+1][m+1];

        for(int i = 0 ; i < dp[0].length ; i++) {
            dp[0][i] = i;
        }
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = i;
        }

        for(int i = 1 ; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = dp[i][j-1]+1;
                    int delete = dp[i-1][j]+1 ;
                    int replace = dp[i-1][j-1] +1;
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "horse";
        String str2 = "ros";
        System.out.println(minDistance(str1, str2));
    }
}

class StringConversion {

    public static int lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        if(n == 0 || m == 0 ) return 0;
        int dp[][] = new int[n+1][m+1];

        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void stringConversion(String str1, String str2) {
        int lcs = lcs(str1, str2);
        int delOperation = str1.length() - lcs;
        int addOperation = str2.length() - lcs;

        System.out.println("Total Delete  Operation(s) : " + delOperation);
        System.out.println("Total Add Operation(s) : " + addOperation);
    }

    public static void main(String[] args) {
        String str1 = "saifullah";
        String str2 = "saif";
        stringConversion(str1, str2);
    }
}