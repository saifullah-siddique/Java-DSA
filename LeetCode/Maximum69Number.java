package LeetCode;

public class Maximum69Number {
    public static int maximum69Number (int num) {
        char val[] = String.valueOf(num).toCharArray();
        for(int i = 0 ; i < val.length ; i++) {
            if (val[i] == '6') {
                val[i] = '9';
                break;
            }
        }
    
        return Integer.parseInt(new String(val));
    }
    
    public static void main(String[] args) {
        System.out.println(maximum69Number(9999));
    }
}
