package LeetCode;

public class Largest3SameDigitNumberinString {

    public static String largestGoodInteger(String num) {
        if (num.length() < 3) return "";
        String max = "";
        for(int i = 0 ; i <= num.length()-3 ; i++) {
            String s = num.substring(i, i+3);
            if ("999".equals(s) || "888".equals(s) || "777".equals(s) || "666".equals(s) || "555".equals(s) || "444".equals(s) || "333".equals(s) || "222".equals(s) || "111".equals(s) || "000".equals(s)) {
                if (max.isEmpty() || s.compareTo(max) > 0) {
                    max = s;
                }
            }
        }
        

        return max;

    }

    public static String largestGood(String num) {
        if (num.length() < 3) return "";
        String vals[] = {"999","888", "777", "666" , "555" , "444" , "333" , "222" , "111"};
        for(String v : vals) {
            if (num.contains(v)) {
                return v;
            }
        }

        return "";

    }

    
    public static void main(String[] args) {
        String num = "3888777777200014999";
        System.out.println(largestGoodInteger(num));
    }
}
