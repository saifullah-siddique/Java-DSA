import java.util.*;

public class JavaLoops {
    public static void main (String args[]) {        
        Scanner sc = new Scanner(System.in);

        // //Print number from 1 to n.
        // System.out.print("Enter  n : ");
        // int n = sc.nextInt();
        // for (int i = 1 ; i <= n ; i++) {
        //     System.out.println(i);
        // }


        // //Sum of First n Natural Numbers
        // System.out.print("Enter num : ");
        // int num = sc.nextInt();
        // int sum = 0, i = 1;

        // while (i<=num) {
        //     sum += i;
        //     i++;
        // }
        // System.out.println(sum);


        // //Print Square Pattern
        // System.out.print("Enter Size of square : ");
        // int square = sc.nextInt();
        // for (int i = 1 ; i <= square ; i++) {
        //     for (int j = 1 ; j <= square ; j++) {
        //         System.out.print("*  ");
        //     }
        //     System.out.println();
        // }



        // //Print Reverse of a number
        // int n = 10899;
        // while (n > 0) {
        //     int lastDigit = n%10;
        //     System.out.print(lastDigit + " ");
        //     n /= 10;

        // }

        // //Reverse the given number
        // System.out.print("Enter Number : ");
        // int orginal = sc.nextInt();
        // System.out.println("Orginal : " + orginal);
        // int Reverse = 0; 
        // while (orginal> 0) {
        //     int lastDigit = orginal % 10;
        //     Reverse = (Reverse*10) + lastDigit;
        //     orginal = orginal / 10;
        // }
        // System.out.println("Reversed : " + Reverse);



        //Keep entering numbers till user enters a number multiple of 10
        // System.out.println("Check if Number is Multiple of 10 or not");
        // System.out.print("Enter Number : ");
        // do {
        //     int num = sc.nextInt();
        //     if (num%10 == 0) {
        //         System.out.println(num + " is a Multiple of 10");
        //         break;
        //     } else {
        //         System.out.print("Try Again : ");
        //     }
        // } while(true);




        // //Display all NUmbers enterd by user except multiple of 10;
        // do {
        //     System.out.print("ENter Num : ");
        //     int num = sc.nextInt();
        //     if (num%10==0) {
        //         continue;
        //     }
        //     System.out.println(num);
        // }while (true); 


        // //Check if a number is prime or not
        // System.out.println("Check if a number is prime or not");
        // System.out.print("Enter Number : ");
        // int num = sc.nextInt();

        // if (num < 2) {
        //     System.out.println(num + " is not a Prime Number");
        //     System.exit(0);    
        // }

        // for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
        //     if (num%i == 0) {
        //         System.out.println(num + " is not a Prime Number");
        //         System.exit(0);
        //     }
        // }

        // System.out.println(num + " is a prime Number");



        /*--------------Practice --Questions----------- */

        // //Q1//How many times 'Hello' is printed?  //2 times
        // for (int i = 0 ; i < 5 ; i++) {
        //     System.out.println("Hello");
        //     i+=2;
        // }
        

        //Q2//Write a program that reads a set of integers, and then prints the sum of the even and odd integers.
        System.out.print("Enter Number: ");
        int num = sc.nextInt(); 
        int dublicateNum = num;
        int evenSum = 0;
        int oddSum = 0;
        while (num > 0) {
            int lastDigit = num%10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            } else {
                oddSum += lastDigit;
            }
            num = num/10;
        }
        num = dublicateNum;

        System.out.println("Sum Odd digits in " + num + " is = " + oddSum + " || Sum of Even digits in " + num + " is = " + evenSum);


        //Write a program to find the factorial of any number entered by the user.
        System.out.print("Enter Number : ");
        int factNum = sc.nextInt();
        int factorial = 1 ; 
        for (int i = 1 ; i <= factNum ; i++) {
            factorial *= i ; 
        }

        System.out.println("Factorial of " + factNum + " is = " + factorial);


        //Write a program to print the multiplication table of a number N, entered by the user.
        System.out.print("Enter Number : ");
        int table = sc.nextInt();
        for (int i = 1 ; i <=10 ; i++) {
            System.out.println(table + " x " + i + " = " + table*i);
        }

        sc.close();

    }
}
