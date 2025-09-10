

public class BitManipulation {

    public static void oddOrEven(int n) {
        int bitmask = 1 ; 
        if((n & bitmask) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0 ;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n , int i) {
        int bitmask = 1 << i;
        return n | bitmask;
    }

    public static int clearIthBit(int n ,  int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    public static int updateIthBit(int n ,int i, int updateVal) {
        // if (updateVal == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitmask = updateVal << i;
        return n | bitmask;
    }

    public static int clearLastIBits(int n, int i) {
        int bitmask = ~ (0)<<i;
        return n & bitmask;
        
    }

    public static int clearInRange(int n, int si, int ei) {
        int a = ~(0) << (ei+1);
        int b = (1<<si)-1;
        int bitmask =  a|b;
        return n & bitmask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n&(n-1)) == 0;
    }

    public static int countSetBit(int n){
        int count = 0; 
        while (n > 0) {
            if((n & 1) != 0) {
                count++;
            }
            n = n>>1;
        }

        return count;
    }

    public static int fastExponentiation(int n,int p) {
        int ans = 1;
        int count = 0 ;
        while (p != 0) {
            if((p&1) != 0) {
                ans *= n;
            } 
            n *= n;
            p >>= 1;
            count++;
        }
        System.out.println("Total Operation : " + count);

        return ans;
    }

    public static void swapNumbers(int a, int b) {
        System.out.println("Old A:-" + a + " B:- " + b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("New A:-" + a + " B:- " + b);
    }

    public static void main(String[] args) {

        // //odd or even
        // int n = new Scanner(System.in).nextInt();
        // oddOrEven(n);

        // //get ith bit
        // System.out.println(getIthBit(7, 2));

        // //set ith bit
        // System.out.println(setIthBit(7, 2));

        // //clear ith Bit
        // System.out.println(clearIthBit(10, 1));

        // //update bit
        // System.out.println(updateIthBit(10, 2, 1));

        // //Clear Last i Bits
        // System.out.println(clearLastIBits(15, 2));


        // //clear bits in a range 
        // System.out.println(clearInRange(10, 2, 4)); 

        // //Check If Number is power of 2 
        // System.out.println(isPowerOfTwo(8));

        // //Count set bits in a number 
        // System.out.println(countSetBit(16));

        // //Fast Exponantiation
        // System.out.println(fastExponentiation(5, 3));



        
        /*-----------------------------Practice---------------------- */
        // //Q1//What is the value of x^x for any valueof x?
        // System.out.println(3^3); //0

        // //Q2//Swap two numbers without using any thirdvariable.
        // swapNumbers(20, 30);

        // System.out.println( (~(10)));

        System.out.println(4&2);
    }
}