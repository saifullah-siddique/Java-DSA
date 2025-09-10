import java.util.*;

public class ConditionalStatements {

    public static void main(String args[]){

        Scanner  sc = new Scanner(System.in);
        
        /*
        //Print The Largest number;
        int a = 1, b = 3;
        if (a > b ) {
            System.out.println("A is grater then B");
        } else {
            System.out.println("B is greater Than A");
        }
        */

        /*
        //Print If A number is Odd Or Even
        System.out.print("Enter Number : ");
        int number = sc.nextInt();
        if (number%2 == 0) {
            System.out.println(number + " is Even Number");
        } else {
            System.out.println(number + " is Odd Number");
        }
        */


        /*
        //Income Tax Calculator
        System.out.print("Enter Your Salary : Rs.");
        int salary = sc.nextInt();
        if (salary < 500000) {
            System.out.println("Your Tax Amount is Rs.0");
            System.out.println("Your Final Salary is Rs." + salary);
        } else if (salary >= 500000 && salary < 1000000) {
            float tax = salary*0.20f;
            System.out.println("Your Tax Amount is = Rs." + tax + " 20% Tax Applied");
            float Finalsalary = salary - tax;
            System.out.println("Final Salary After Deduction is Rs." + Finalsalary);
        } else if (salary >= 100000) {
            float tax = salary*0.30f;
            System.out.println("Your Tax Amount is = Rs." + tax + " 30% Tax Applied");
            float Finalsalary = salary - tax;
            System.out.println("Final Salary After Deduction is Rs." + Finalsalary);
        } else {
            System.out.println("Enter Valid Salary");
        }
        */



        /*
        //Print The Largest of 3
        System.out.print("Enter A = ");
        int a = sc.nextInt();
        System.out.print("Enter B = ");
        int b = sc.nextInt();
        System.out.print("Enter C = ");
        int c = sc.nextInt();

        if ( a > b && a > c) {
            System.out.println("A is largest");
        } else if ( b > c) {
            System.out.println("B is largest");
        } else  {
            System.out.println("C is largest");
        }
        */


        /*
        //ternary operator 
        int a = 3 , b = 6;
        String result = a> b ? "A is greater" : "B is Greater";
        System.out.println(result);
        */

        /*
        //Check If A Student Is Pass Or Fail
        System.out.print("Enter Marks : ");
        int marks = sc.nextInt();
        String  result = marks >= 33 ? "PASS" : "FAIL" ;
        System.out.println(result);
        */



        /*
        //Calculator using Switch 
        System.out.println("Welcome To Calculator");
        System.out.println("Add '+', Subtract '-', Multiply '*', Divide'/'");
        System.out.print("Enter Calculation Type : ");
        char calculation = sc.next().charAt(0);

        switch (calculation) {
            case '+':
                System.out.println("Addition");
                System.out.print("Enter Num1: ");
                int num1 = sc.nextInt();
                System.out.print("Enter Num2: ");
                int num2 = sc.nextInt();
                int sum = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + sum);
            break;

            case '-':
                System.out.println("Subtraction");
                System.out.print("Enter Num1: ");
                int subNumber1 = sc.nextInt();
                System.out.print("Enter Num2: ");
                int subNumber2 = sc.nextInt();
                int sub = subNumber1 - subNumber2;
                System.out.println(subNumber1 + " - " + subNumber2 + " = " + sub);
            break;

            case '*':
                System.out.println("Multiplication");
                System.out.print("Enter Num1: ");
                int multi1 = sc.nextInt();
                System.out.print("Enter Num2: ");
                int multi2 = sc.nextInt();
                int multi = multi1 * multi2;
                System.out.println(multi1 + " x " + multi2 + " = " + multi);
            break;

            case '/': 
                System.out.println("Division");
                System.out.print("Enter Num1: ");
                int div1 = sc.nextInt();
                System.out.print("Enter Num2: ");
                int div2 = sc.nextInt();
                int divide = div1 / div2;
                System.out.println(div1 + " / " + div2 + " = " + divide);
           
            break;
        
        
            default:
                System.out.println("Invalid Input!");
                System.out.println("Choose These Value :[Add '+', Subtract '-', Multiply '*', Divide'/']");
                break;
        }
        */


  

        /*-------------Practice Questions------------- */


        //Q1//Write a Java program to get anumber from the user and print whether it is positive or negative.
        System.out.print("Enter Number : ");
        int num = sc.nextInt();
        String result =  num >= 1 ? num + " is Postive Number" : num + " is Negative Number" ;
        System.out.println(result);


        //Q2//Finish the following code so that it prints You have a fever if your temperature is above 100 and otherwise prints You don't have a fever.
        double temp = 103.5;
        String haveFever = temp >= 100 ? "You Have A Fever" : "You Don`t Have A Fever" ;
        System.out.println(haveFever);

        //Q3//Write a Java program to input week number(1-7) and print day of week name using switch case.
        System.out.print("Enter week number(1-7) : ");
        int day = sc.nextInt();
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        
            default:
                System.out.println("Enter Value from (1-7)");
                break;
        }


        //Q4//What will be the value of x & y in thefollowing program:
        int a = 63 , b = 36;
        boolean x = ( a< b ) ? true : false ; //false
        int y = (a > b ) ? a : b ;//63
        System.out.println("X = " + x + " Y = " + y);



        //Q5//Write a Java program that takes a year from the user and print whether that year is a leap year or not.
        System.out.print("Enter Year : ");
        int year = sc.nextInt();
        if (year%4 == 0 ) {
            if (year%100 == 0) {
                if (year%400 == 0) {
                    System.out.println(year + " is Leap Year");
                } 
                else {
                    System.out.println(year + " is not Leap Year");
                }
            } 
            else {
                System.out.println(year + " is Leap Year");
            }

        }
        else {
            System.out.println(year + " is not Leap Year");
        }



        sc.close();

    }
    
}