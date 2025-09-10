import java.util.*;

// public class JavaBasics {
//     // public static void main(String args[]) {
//     //     // System.out.println("****");
//     //     // System.out.println("***");
//     //     // System.out.println("**");
//     //     // System.out.println("*");

//     //     int a = 10;
//     //     int b = 5;
//     //     String name = "Saifullah";
//     //     System.out.println(b);
//     //     System.out.println(name);

//     //     b = a;
//     //     System.out.println(b);

//     // }


//     // Data types in java 
//     public static void main(String args[]) {
//         // byte b = 10;
//         // System.out.println(b);
//         // char ch = 'a';
//         // System.out.println(ch);
//         // boolean isPass = true;
//         // System.out.println(isPass);
//         // float price = 10.5f;
//         // System.out.println(price);
//         // int number = 100;
//         // System.out.println(number);
//         // //long
//         // //double
//         // short n = 240;
//         // System.out.println(n);


//         // Sum Of two Numbers
//         // int a = 10;
//         // int b = 20;
//         // int sum = a+b;
//         // System.out.println(sum);



//         //input in java

//         // Scanner sc = new Scanner(System.in);
//         // // String hel = sc.next();
//         // // System.out.println(hel);

//         // // String fullName = sc.nextLine();
//         // // System.out.println(fullName);

//         // boolean number = sc.nextBoolean();
//         // System.out.println(number);

//         // Scanner cal = new Scanner(System.in);

//         // int a = cal.nextInt();
//         // int b = cal.nextInt();
//         // int sum = a + b ;
//         // int product = a*b;
//         // System.out.println("Sum = " + sum);
//         // System.out.println("Product Is : " + product);


//         // area of circle
//         // float PI = 3.14f;
//         // float radius = cal.nextFloat();
//         // float area = PI*radius*radius;
//         // System.out.println("Area Of Circle = " + area);
//         // cal.close();



//         // type conversion 
//         // int a = 12;
//         // float b = a;
//         // System.out.println(b);

//         // //Type Casting 
//         Scanner ty = new Scanner(System.in);
//         // int a = (int)ty.nextFloat();
//         // System.out.println(a);
//         ty.close();

//         // Type Promotion
//         //  byte n = 20;
//         //  char ch = 'a';
//         //  short s = 2;
//         //  int Promo = n + ch + s;
//         //  System.out.println(Promo);

//         // int num = 10;
//         // float fl = 3.14f;
//         // double lg = 10; 
//         // double newDT = (num + fl + lg);
//         // System.out.println(newDT);

//     }

// }



/* ---------------- Practice- QUestion------------- */

public class JavaBasics {
    public static void main(String args[]) {
        Scanner prac = new Scanner(System.in);
        /*
        //q1//Inaprogram, input 3 numbers : A, B and C. You have to output the average of these 3 numbers;
        int A = prac.nextInt();
        int B = prac.nextInt();
        int C = prac.nextInt();
        int avg = (A+B+C)/3 ;
        System.out.println("Average is = " + avg);
         */

        /*
        //q2//In a program, input the side of a square. You have to output the area of the square.
        int side = prac.nextInt();
        int area = side*side;
        System.out.println("Area Of Square is = " + area);
        */

        /*
        //q3/ Enter cost of 3 items from the user (using float data type) - a pencil, a pen and an eraser. 
            //You have to output the total cost of the items back to the user as their bill.
        float pencil = prac.nextFloat();
        float pen = prac.nextFloat();
        float eraser = prac.nextFloat();
        float bill = pencil + pen + eraser ;
        System.out.println("Total Cost : " + bill);
        */

        
        /*
        //q4// What will be the type of result in the following Java code?(ans : double)
        byte b = 4;
        char c = 'a';
        short s = 512;
        int i = 1000;
        float f = 314f;
        double d = 99.9954;
        double result = (f *b) + (i % c) - (d * s);
        System.out.println("Answere Is Double : " + result);
        */


        /*
        //q5//(Advanced) Will the following statement give any error in Java?
        // int $ = 24; (ans : no )
        int $ = 23;
        System.out.println($);
        */

        prac.close();
    }
    
}
