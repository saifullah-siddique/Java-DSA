package LeetCode;

public class PowerOf3 {

    public static boolean isPowerOfThree(int n) {
        if(n < 8) return false;
        double cuberoot = (Math.cbrt(n));
        System.out.println(cuberoot);
        return (cuberoot * cuberoot * cuberoot) == n;
    }

    public static void main(String[] args) {
        int n = 9;
        System.out.println(isPowerOfThree(n));
    }
}