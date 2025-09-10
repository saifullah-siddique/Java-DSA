package Arrays;
import java.util.Scanner;

public class arrays {

    public static void update (int marks[]) {
        for (int i = 0 ; i < marks.length ; i++) {
            marks[i] += 1; 
        }
    }


    public static int lenearSearch(int numbers[], int key) {
        for (int i = 0 ; i < numbers.length ; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int fruits (String menu[], String key) {
        for (int i = 0 ; i < menu.length ; i++) {
            if (menu[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static int largest (int numbers[]) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0 ; i <numbers.length ; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            } 
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        System.out.println("Smallest Number in Array Is : " + smallest);
        return largest;
    }

    public static int binarySearch (int shortArray[], int key) {
        int start = 0;
        int end = shortArray.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2; 
            if (shortArray[mid] == key) {
                return mid ;   
            } 
            if(shortArray[mid] < key) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        return -1;
       
    }

    public static void reverseArray(int reverse[]) {
        for (int i = 0 ; i < (reverse.length) /2 ; i++) {
            int first  = reverse[i];
            int last = reverse[reverse.length-i -1];
            reverse [i] = last;
            reverse[reverse.length-i-1] = first;
        }
    }

    public static void arrayPairs (int pairs[]) {
        for (int i = 0 ; i < pairs.length ; i++) {
            for (int j = i+1 ; j < pairs.length ; j++) {
                System.out.print("(" + pairs[i] + "," + pairs[j] + ") ");
            }
            System.out.println();
        }
    }

    public static void subArrays (int array[]) {
        int opration = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0 ; i < array.length ; i++) {
            
            for (int j = i ; j <array.length ; j++) {
                int sum = 0;
                for (int k = i ; k<=j ; k++){
                    System.out.print(array[k] + " ");
                    sum += array[k];
                    opration++;
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
                System.out.print("\tSum of Array is = " + sum);
                System.out.println();

            }
           
            System.out.println();
        }

        System.out.println("Max Sum of Array is : " + maxSum + " || Number of Opration taken : " + opration);
    }


    public static void prefixSum (int arr[]) {
        int opration = 0;
        int prefixArray[] = new int[arr.length] ;
        prefixArray[0] = arr [0];
        for (int i = 1 ; i < arr.length ; i++) {
            prefixArray[i] = prefixArray[i-1]+arr[i];
        }
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0 ; i < arr.length ; i++) {
            int sum = 0; 
            for (int j = i ; j < arr.length ; j++) {
                sum = i == 0 ? prefixArray[j] : prefixArray[j] - prefixArray[i-1];
                if (sum > maxSum) {
                    maxSum = sum;
                }
                opration++;
            }
        }
        System.out.println("Max Sum : " + maxSum + " || Number of Opration taken : " + opration);

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // //lenear search 
        // int numbers[] = {4,8,10,15,20,30,35,54,65};
        // int key = 65;
        // int index = lenearSearch(numbers, key);
        // if (index == -1) {
        //     System.out.println("NOT Found");
        // } else {
        //     System.out.println("Key is on Index : " + lenearSearch(numbers, key));
        // }


        // //string array 
        // String menu[] = {"banana" , "mango" , "berry" , "carrot" , "pineapple"};
        // String key = "berry";
        // int result = fruits(menu, key);
        // if ( result == -1) {
        //     System.out.println("Data NOT Found");
        // } else {
        //     System.out.println("Key : " + key + ". is at Indices : " + result);
        // }


        // //largest search
        // int numbers[] = {12,43,34,11,43,78,74,83};
        // System.out.println("The Largest in Array 'Numbers' is : " + largest(numbers));


        //binary search
        // int shortArray[] = {2,4,6,8,10,12,14};
        // System.out.print("Search key : ");
        // int key = sc.nextInt();
        // int result = binarySearch(shortArray, key);
        // if (result == -1) {
        //     System.out.println("Key Not Found");
        // } else {
        //     System.out.println("Key Found At Index : " + result);
        // }



        // //reverse array 
        // int reverse[] = {2,3,4,5,6,7,8,10,12,23};
        // reverseArray(reverse);
        // for (int i = 0 ; i < reverse.length ; i++) {
        //     System.out.print(reverse[i] + " ");
        // }


        // //pairs in array 
        // int pairs[] = {2,4,6,8,10};
        // arrayPairs(pairs);

        // //sub Array 
        // int array[] = {2,4,6,8,10};
        // subArrays(array);



        // //prefix array method
        // int arr[] = {1,-2,6,-1,3,8};
        // prefixSum(arr);
        


        sc.close();
    }
}

