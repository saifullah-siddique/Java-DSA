package LeetCode;

public class ReverseString {
    
    public static void reverse(char[] s) {
        int i = 0 ;
        int j = s.length -1 ; 
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        char s[] = {'h','e','l','l','o'};
        reverse(s);
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();
    }
}
