import java.util.*; 

public class Strings {
    public static void printLetter(String str) {
        for(int i = 0 ; i < str.length() ; i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static boolean checkPelindrome (String str) {
        for(int i = 0 ;  i <str.length()/2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                System.out.println("Not a Pelindrome!");
                return false;
            }
        }

        System.out.println(str + " is a Pelindrome");
        return true;
    }

    public static float shortesPath(String str) {
        //origin (0,0)
        int x = 0 , y = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == 'N') {
                y++;
            } else if (str.charAt(i) == 'S') {
                y--;
            } else if (str.charAt(i) == 'W') {
                x--;
            } else if (str.charAt(i) == 'E') {
                x++;
            }
        }

        int rootDistance = (int)(Math.pow(x, 2) + Math.pow(y, 2));
        System.out.println("Final Destination Is (" + x + "," + y + ")");
        return (float)Math.sqrt(rootDistance);

    }

    public static void substring(String str, int si, int ei) {
        String subString = "";

        for(int i = si ; i < ei ; i++) {
            subString += str.charAt(i);
        }

        System.out.println(subString);
    }

    public static String touppercase(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i = 1 ; i < str.length() ; i++) {
            if(str.charAt(i) == ' ' && i <str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String compress(String str) {
        String newStr = "";
        for(int i = 0 ; i < str.length() ; i++) {
            Integer count = 1;
            while(i <str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if ( count > 1) {
                newStr += count.toString();
            }
        }

        return newStr;
    }

    public static int countVowels(String str) {
        int count = 0 ;
        for (int i = 0 ; i < str.length() ; i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String str ,String str2) {
        if (str.length() != str2.length()) {
            System.out.println("Strings are not anagrams.");
            return false;
        }

        //converting in lowercase
        str = str.toLowerCase();
        str2 = str2.toLowerCase();

        //convert ki array 
        char strCharArray[] = str.toCharArray();
        char str2CharArray[] = str2.toCharArray();

        //short them in order
        Arrays.sort(strCharArray);
        Arrays.sort(str2CharArray);


        // check if arrays are equals (if yes then will return true )
        if (Arrays.equals(strCharArray, str2CharArray)) {
            System.out.println(str + " and " + str2 + " are anagrams of each other");
            return true;
        }

        //return  false if both arrays are not eaqual
        System.out.println(str +  " and " + str2 + " are not anagrams of each other");
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String firstName = "Saifullah";
        // String lastName = "Siddiqui";
        // String fullName = firstName + " " + lastName;
        // printLetter(fullName);

        // //check if a String is Pelindrome 
        // String test = "racecar";
        // checkPelindrome(test);
        

        // //Given a route containing 4 directions (E, W, N, S), find the shortest path to reach destination.
        // String path = "WNEENESENNN";
        // System.out.println("Shortest path is : " + shortesPath(path));


        // //Substring 
        // String str = "HelloWorld";
        // substring(str, 0, 5);
        // System.out.println(str.substring(0,5));


        // //Largest 
        // String fruits[] = {"Apple", "Mango", "Banana"};
        // String largest = fruits[0];
        // for (int  i = 0 ; i <fruits.length ; i++) {
        //     if(largest.compareTo(fruits[i]) < 0 ) {
        //         largest = fruits[i];
        //     }
        // }

        // System.out.println(largest);


        // //String Builder
        // StringBuilder sb = new StringBuilder("");
        // for(char ch = 'a' ; ch <= 'z' ; ch++){
        //     sb.append(ch);
        // }

        // System.out.println(sb.length());


        // //cover every first charec of word to upper case 
        // String str = "hi i am saifullah siddiqui";
        // System.out.println(touppercase(str));


        // //String Compression
        // String str = "aaabbcccdd";
        // System.out.println(compress(str));


        /*-----------Practice------------- */
        // //Q1//Count how many times lowercase vowels occurred in a String entered by the user.
        // String str = sc.next();
        // System.out.println("total Numbers Of Vowels : " + countVowels(str));

        // //Q2//What will be the output of the following code?
        // String str = "ShradhaDidi";
        // String str1 = "ApnaCollege";
        // String str2 = "ShradhaDidi";
        // System.out.println(str.equals(str1) +" "+str.equals(str2));

        // //Q3//What will be the output of the following code?
        // String str="ApnaCollege".replace("l",""); //Apnacoege
        // System.out.println(str);

        //Q4//Determine if 2 Strings areanagramsof each other.
        String str = "earth";
        String str2 = "Heart";
        isAnagram(str, str2);
        
        sc.close(); 
    }
}