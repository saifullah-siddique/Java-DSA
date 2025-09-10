import java.util.*;

public class functions {

    public static int factorial (int fact) {
        int factorial = 1;
        for (int i = 1 ; i <=fact ; i++) {
            factorial *= i;
        }

        return factorial ; 
    } 

    public static int binomialCoefficient (int n, int r) {
        int nFactorial = factorial(n);
        int rFactorial = factorial(r);
        int n_rFactorial = factorial(n-r);
        int binomialCoe = nFactorial / (rFactorial*n_rFactorial);

        return binomialCoe;

    }

    public static boolean isPrime (int num) {
        if (num<2) {
            return false;
        }

        for (int i = 2 ; i <= Math.sqrt(num) ; i++) {
            if (num%i==0) {
                return false;
            }
        }

        return true;
    }

    public static void printPrimeRange (int primeRange) {
        for (int i = 0 ; i<=primeRange ; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void binaryToDecimal (int binaryNum) {
        int decimal = 0 ;
        for (int i = 0 ; binaryNum > 0 ; i++) {
            int lastDigits = binaryNum % 10;
            decimal = decimal + (lastDigits* (int)Math.pow(2, i));
            binaryNum = binaryNum / 10;
        }

        System.out.println("Decimal is " + decimal);
    }


    public static void decimalToBinary (int decimalNum) {
        int binary = 0;
        for(int i = 0 ; decimalNum > 0 ; i++) {
            int remainder = decimalNum % 2;
            binary = binary + (remainder * (int)Math.pow(10, i));
            decimalNum = decimalNum/ 2 ;
        }

        System.out.println("BInary is : " + binary);
    }



    /*----------------Practice Function---------------- */


    public static int avgOfthree (int a, int b, int c) {
        int avg = (a + b + c ) / 3 ;
        return avg;
    } 


    public static boolean isEven ( int number){
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPalindrome (int checkNum) {
        int dublicateNum = checkNum;
        int reverse = 0 ;
        while (checkNum > 0 ) {
            int lastDigit = checkNum % 10 ;
            reverse = (reverse*10) + lastDigit;
            checkNum = checkNum / 10;
        }
        if ( dublicateNum == reverse) {
            return true;
        } else {
            return false ; 
        }
    }

    public static int sumOfDigits (int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10 ;
            sum += lastDigit ; 
            n = n / 10 ;
        }

        return sum;
    }



    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // //Binomial Coefficient
        // System.out.println("THis Program Calculates Binomial Coefficient");
        // System.out.print("Enter n : ");
        // int n = sc.nextInt();
        // System.out.print("Enter r : ");
        // int r = sc.nextInt();
        // System.out.println("Binomial Coefficient of "+ n + " and " + r + " is :" + binomialCoefficient(n,r));



        // //is Prime using Function
        // System.out.print("Enter Number : ");
        // int number = sc.nextInt();
        // System.out.println(isPrime(number));


        // //Print All Primae No. In A range.
        // System.out.print("Enter Prime Range : ");
        // int primeRange = sc.nextInt();
        // printPrimeRange(primeRange);


        // //Binary to Decimal Conversion// 
        // System.out.print("Enter Binary : ");
        // int binaryNum = sc.nextInt();
        // binaryToDecimal(binaryNum);

        // //Decimal To binary conversion
        // System.out.print("Enter Decimal : ");
        // int decimalNum = sc.nextInt();
        // decimalToBinary(decimalNum);



        /*-----------------Practice Questions--------------- */

        // //Write a Java method to compute the average of three numbers.
        // System.out.println("This program Calculates avg of three");
        // System.out.print("Enter a : ");
        // int a = sc.nextInt();
        // System.out.print("Enter b : ");
        // int b = sc.nextInt();
        // System.out.print("Enter c : ");
        // int c = sc.nextInt();
        // System.out.println("Avg of " + a +  " + " + b + " + " + c + " = " + avgOfthree(a,b,c));



        // /* Q2//
        //  Write a method named is Even that accepts an int argument. 
        //  The method should return true if the argument is even, or false other wise. 
        //  Also write a program to test your method
        // */
        // System.out.println("CHeck If A Number Is Even or Not");
        // System.out.print("Enter NUmber : ");
        // int Even = sc.nextInt();
        // System.out.println(Even + " is even: " + isEven(Even));
        


        //Q3 /*
        // Write a Java program to check if a number is a palindrome in Java? (121 is a palindrome, 321 is not)A number is called a palindrome if the number 
        // is equal to the reverse of a number e.g.,121 is a palindrome because the reverse of 121 is 121 itself. On the other hand, 321 is not a palindrome 
        // because the reverse of 321 is 123, which is not equal to 321.
        // */
        // System.out.println("THis Program Check If A Number is Penildrome Or Not");
        // System.out.print("Enter Number : ");
        // int checkNum  = sc.nextInt();
        // System.out.println(checkNum + " is Palindrome : " + isPalindrome(checkNum));


        
        // //Q5 Write a Java method to compute the sum of the digits in an integer.
        // System.out.println("This Promgram Gives Sum Of Digits of A Number");
        // System.out.print("Enter NUmber : ");
        // int n = sc.nextInt();
        // System.out.println("Sum Of Digits of " + n + " is : " + sumOfDigits(n));    


        /* //Q4//
        Math.min( )
        b.Math.max( ) 
        c.Math.sqrt( )
        d.Math.pow( )
        e.Math.avg( )
        f.Math.abs( )
        */
        System.out.println(Math.min(3, 5));
        System.out.println(Math.max(3, 5));
        System.out.println((int)Math.pow(3, 5));
        System.out.println(Math.abs(-3000));

        sc.close();
    }
}
