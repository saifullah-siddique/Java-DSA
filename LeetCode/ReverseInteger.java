package LeetCode;

public class ReverseInteger {

    public static int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int lastdigit = x %10;
            ans *= 10;
            ans += lastdigit;
            x = x /10;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int x = -123456;
        System.out.println(reverse(x));

    }
}
