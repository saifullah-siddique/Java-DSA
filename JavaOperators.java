public class JavaOperators {
    public static void main(String args[]) {

        /*
        //(i)//What will be the output of the followingprograms :
        int x = 2, y = 5; 

        int exp1 = (x * y / x); //5
        int exp2 = (x * (y / x)); //2.5 ~ 2 (2*2)

        System.out.print(exp1 + " , ");
        System.out.print(exp2);
        */


        /*
        //(ii)//
        int x = 200, y = 50 , z = 100 ; 
        if (x > y && y > z) {
            System.out.println("Hello");
        }

        if (z > y && z < x) {
            System.out.println("Java"); // true statement
        }

        if ((y+200) < x && (y+150) < z) {
            System.out.println("Hello Java");
        }
        */


        /*
        //(iii)//
        int x, y, z;
        x = y = z = 2;
        x += y; //4
        y -= z;//0
        z /= (x + y);//0.5 ~ 0 
        System.out.println(x + " " + y + " " + z); // 4 0 0 
        */


        /*
        //(iv)//
        int x = 9, y = 12;
        int a = 2, b = 4, c = 6;

        //        (     43     )  +  (     234    ) + (          1               )          
        int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y); //278
        System.out.println(exp);
        */


        /*
        //(v)//
        int x = 10, y = 5;


        int exp1 = (y * (x / y + x / y)); //20
        int exp2 = (y * x / y + y * x / y);//20

        System.out.println(exp1);
        System.out.println(exp2);
        */

    }
}
