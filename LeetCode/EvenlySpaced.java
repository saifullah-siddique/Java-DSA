package LeetCode;

import java.util.Arrays;

public class EvenlySpaced {
    public static boolean evenlySpaced(int a, int b, int c) {
        int arr[] = { a, b , c};
        Arrays.sort(arr);
        if (arr[1] - arr[0] == arr[2] - arr[1]) {
            return true;
        }

        

        return false;
    }

    public static void main(String[] args) {
        System.out.println(evenlySpaced(6, 3, 9));
    }

}
