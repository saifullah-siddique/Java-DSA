import java.util.*;
public class Patterns {

    public static void pyramidWithNumbers (int n) {
        for (int i = n ; i >= 1 ; i--) {
            for (int j = 1 ; j <= i ; j++ ) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void floydsTriangle (int n) {
        int num = 1 ;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle (int n) {
        
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= i ; j++) {
                if ((i+j)%2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();

        }
    }
    public static void main(String args[]) {
        Scanner sc = new  Scanner(System.in);


        //chapter advanve patterns

        // //inverted Half-Pyramid With Numbers
        System.out.print("SIze Of Pyramid : ");
        int numberPyramid = sc.nextInt();
        pyramidWithNumbers(numberPyramid);

        //Floyd`s Triangle 
        System.out.print("Size Of Floyeds Triangle : ");
        int floyedsTriangle = sc.nextInt();
        floydsTriangle(floyedsTriangle);

        //0-1 Triangle
        System.out.print("Enter Size : ");
        int zeroOne = sc.nextInt();
        zeroOneTriangle(zeroOne);

        





        sc.close();

    }
}
