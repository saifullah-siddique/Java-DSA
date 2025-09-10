package LeetCode;

public class FirstOccurrence {

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        for(int i = 0 ; i <= haystack.length() - needle.length() ; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                while (j < needle.length() && haystack.charAt(i +j) == needle.charAt(j)) {
                    j++;
                }

                if (j == needle.length()-1) {
                    return j;
                }
            }
        }

        return -1;
    }
    

    public static int string(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        for(int i = 0 ; i <= n-m ; i++ ) {
            if (needle.equals(haystack.substring(i, i+m))) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
       String haystack = "mississippi", needle = "issip";
       System.out.println(strStr(haystack, needle));
       System.out.println(string(haystack, needle));

    }
}
