package LeetCode;

public class ValidPalindrome {


    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            }
        }

        int i = 0 , j = sb.length()-1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    

    public static void main(String[] args) {
        String s = "A mn, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

    }
}
