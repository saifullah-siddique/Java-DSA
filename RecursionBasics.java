

// public  class RecursionBasics {
//     public static void printDec(int n) {
//         if( n == 1) {
//             System.out.println(n);
//             return;
//         }
//         System.out.print(n + " ");
//         printDec(n-1);
//     }

//     public static void printInc(int n) {
//         if(n == 1) {
//             System.out.print(n + " ");
//             return;
//         }
//         printInc(n-1);
//         System.out.print(n + " ");
//     }

//     public static int factorial(int n) {
//         if ( n== 1 || n == 0) {
//             return 1;
//         }
//         return n * factorial(n-1);

//     }

//     public static int sumofNaturalN(int n) {
//         if (n == 1) {
//             return 1;
//         }
//         return sumofNaturalN(n-1) + n;
//     }

//     public static int fibonacciOf(int n) {
//         if (n == 0 || n == 1) {
//             return n;
//         }  
//         int fibno =  fibonacciOf(n-1) + fibonacciOf(n-2);
//         return fibno;
//     }

//     public static boolean isSorted(int nums[], int i ) {
//         if( i == nums.length-1) {
//             return true;
//         }

//         if(nums[i] > nums[i+1]) {
//             return false; 
//         } 

//         return isSorted(nums, i+1);
//     }

//     public static int firstOuccurance(int nums[], int key, int i) {
//         if (i == nums.length) {
//             return -1;
//         }
//         if(nums[i] == key) {
//             return i;
//         }
//         return firstOuccurance(nums, key, i+1);
//     }

//     public static int lastOuccurance(int nums[], int key, int i) {
//         if (i == nums.length) {
//             return -1;
//         }
//         int isFound = lastOuccurance(nums, key, i+1);
//         if( isFound == -1 && nums[i] == key) {
//             return i;
//         }

//         return isFound;

//     }

//     public static int power(int x, int n){
//         if (n == 0) {
//             return 1;
//         }
//         return x * power(x, n-1);
//     }

//     public static int optimizedPower(int x, int n) {
//         if (n== 0) {
//             return 1;
//         }
//         int half = optimizedPower(x, n/2);
//         if((n & 1) == 0){
//             return  half * half;
//         } else {
//             return x * half * half;
//         }
//     }
    
//     public static int placeTile(int n) {
//         if (n == 0 || n == 1) {
//             return 1;
//         }

//         //vertical choice
//         int vertical = placeTile(n-1);

//         //Horizontal Choice
//         int horizontal = placeTile(n-2);

//         return vertical + horizontal;
//     }

//     public static void removeDublicates(String str, int i, StringBuilder newStr, boolean map[]) {
//         if (i == str.length()) {
//             System.out.println(newStr);
//             return;
//         }
        
//         if (map[str.charAt(i)-'a'] == false ) {
//             newStr.append(str.charAt(i));
//             map[str.charAt(i)-'a'] = true;
//             removeDublicates(str, i+1, newStr, map);
//         } else{
//             removeDublicates(str, i+1, newStr, map);
//         }

//     }

//     public static int friendsPair(int n) {
//         if (n == 1 || n == 2) {
//             return n;
//         }
//         //      single                  pair
//         return friendsPair(n-1) + (n-1) * friendsPair(n-2);
//     }

//     public static void binaryStrings(String str, int n, int lastPlace) {
//         if (n == 0) {
//             System.out.println(str);
//             return;
//         }
 
//         binaryStrings(str +"0", n-1, 0);
//         if (lastPlace == 0 ) {
//             binaryStrings(str +"1", n-1, 1);
//         }
        
//     }
//     public static void main(String[] args) {
//         // int n = 5;
//         // printDec(n);
//         // printInc(n);
//         // System.out.println(factorial(5));
//         // System.out.println(sumofNaturalN(5));
//         // System.out.println(fibonacciOf(n));


//         // //check if given is array is Sorted Or not 
//         // int num[] = {1,2,3,4,5};
//         // System.out.println(isSorted(num,0));

//         // // //find first occurence of an element
//         // int nums[] = {5,1,2,3,5,3,2,6,2};
//         // System.out.println("Occured at idx : " + firstOuccurance(nums, 9, 0));

//         // //find last occurance of an element in array 
//         // System.out.println(lastOuccurance(nums, 3, 0));

//         // //print x^n;
//         // System.out.println(power(3, 2));
//         // System.out.println(optimizedPower(2, 10));

//         // //Tilling Problem 
//         // System.out.println(placeTile(4));

//         // //Remove dublicates
//         // String str = "saifullah";
//         // int i = 0;
//         // StringBuilder newstr = new StringBuilder("");
//         // boolean map[] = new boolean[26];
//         // removeDublicates(str, i, newstr, map);


//         // //Friends Pairing Problem
//         // System.out.println(friendsPair(4));

//         // //print binary strings of size n 
//         // binaryStrings("", 3, 0);


//     }
// }





/*-----------------------------Practice Question-------------------- */
public class RecursionBasics {

    public static void allOccurance(int arr[],int i, int key) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == key) {
            System.out.print(i + " ");
        } 
        allOccurance(arr, i+1, key);
    }

    public static void englishNumber(int n, String num[], StringBuilder numString) {
        if (n == 0) {
            System.out.println(numString);
            return;
        }
        englishNumber(n/10, num, numString.insert(0,num[n%10]));
    }

    public static int length(String str) {
        if(str.equals("")) {
            return 0;
        }
        return 1 + length(str.substring(1));
    }

    // public static int totalSubString(String s, int i)

    public static void main(String[] args) {
        
        // //Q1//For a given integer array of size N. You have to find all the 
        // //occurrences (indices) of a given element (Key) and print them. 
        // //Use a recursive function to solve this problem.
        // int arr[] = {3,2,4,5,6,2,7,2,2}, key = 2;
        // allOccurance(arr, 0, key);

        // //Q2//You are given a number (e.g., 2019), convert it into a string 
        // //of English like “two zero one nine”. Use a recursive function 
        // //to solve this problem. NOTE – The digits of the number will 
        // //only be in the range 0-9 and the last digit of a number can’t be 0.
        // String num[] = {"zero ", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eigth ", "nine "};
        // int n = 1947;
        // englishNumber(n, num, new StringBuilder(""));


        // //Write a program to find Length of a String using Recursion.
        // String name = "saifullah";
        // System.out.println("Length of String " + name + "is : " + length(name));


        //We are given a string S, we need to find the count of all 
        //contiguous substrings starting and ending with the same 
        //character.
        // String S = "abcab";



    }
}