package Arrays;
public class Array2d {
    public static boolean search( int matrix[][], int key) {
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == key) {
                    System.out.println( key + " Found At cell : (" + i + ", " + j + ")");
                    return true;
                }
            }
        }
        System.out.println("Key Not Found");
        return false;
    }

    /*-------------Spiral Matrix Function---------- */
    public static void printSpiral(int matrix[][]) {
        int startRow = 0 , startCol = 0;
        int endROw = matrix.length-1 , endCol = matrix[0].length-1;

        while (startRow <= endROw && startCol <= endCol) {
            //top
            for (int j = startCol ; j <= endCol ; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            //right
            for (int i = startRow+1 ; i <= endROw ; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            //bottom
            for (int j = endCol-1 ; j >= startCol ; j--) {
                if (startRow == endROw) {
                    break;
                }
                System.out.print(matrix[endROw][j] + " ");
            }
            //left
            for (int i = endROw-1 ; i >= startRow+1  ; i--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " ");
            }
            startRow++ ; 
            startCol++ ;
            endROw--;
            endCol--;
        }
        
    }

    public static void diagonalMatrix(int matrix[][]) {
        if(matrix.length != matrix[0].length) {
            System.out.println("Daigonal Sum Is Only For Square Matrix");
            return;
        }

        int sum = 0 ;
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++) {
            //primary diagonal
            System.out.print(matrix[i][i] + " ");
            sum += matrix[i][i];

            //Secondary diagonal
            if ((n-1-i) != i ) { // checks dublicate values
                System.out.print(matrix[i][n-1-i] + " ");
                sum += matrix[i][n-1-i];
            }
        }
        System.out.println();
        System.out.println("Sum Of The Diagonal Matrix = " + sum);
    }


    public static boolean searchSortedMatrix(int matrix[][], int key) {
        int row = 0 , col = matrix[0].length-1;
        while (row <= matrix.length-1 && col >= 0) {
            if(matrix[row][col] == key) {
                System.out.println("Found Key At Index : (" + row + "," + col + ")");
                return true;
            }

            if(matrix[row][col] > key) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("Key Not Found!");
       return false;
    }

    /*--------------Practice-------- */
    public static int secondSum(int matrix[][]) {
        int sum = 0 ;
        for(int i = 0 ; i < matrix[0].length ; i++) {
            sum += matrix[1][i];
        }
        return sum;
    }

    public static int countkey(int matrix[][], int key) {
        int count = 0 ;
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (matrix[i][j] == key) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void tranposOfMatrix(int matrix[][]) {
        // int col = 0 ; 
        
    }
    public static void main(String[] args) {
        /*-----------------Important------------- */
        // //Google MS APple Oracle Amazon Q
        // //Spiral Matrix
        // int matrix[][] = {{1,2,3,4},
        //                     {5,6,7,8},
        //                     {9,10,11,12},
        //                     {13,14,15,16}};

        // printSpiral(matrix);


        // //Amazon Sansung Microsoft
        // //Diagonal Mtarix
        // int diagonal[][] = {{1,2,3,4},
        //                     {5,6,7,8},
        //                     {9,10,11,12},
        //                     {13,14,15,16}};
        // diagonalMatrix(diagonal);

        // int[][] matrix = {
        //     {1, 2, 3},
        //     {4, 5, 6},
        //     {7, 8, 9}
        // };
        // diagonalMatrix(matrix);

        // //Search in Shorted Matrix (Stair Case Search) (Oracle)
        // int searchMatrix[][] = {{10,20,30,40},
        // {15,25,35,45},
        // {27,29,37,48},
        // {32,33,39,50}};
        // int key = 27;                
        // searchSortedMatrix(searchMatrix, key);


        
        /*--------------Practice-------------- */
        // //Q1//Print the number of 7’s that are inthe 2d array.
        // int[][] array = {{4,7,8},
        //                 {8,8,7}};
        // System.out.println("Total no of 7 in matrix is : " + countkey(array, 7));

        // //Q2//Print out the sum of the numbers inthe second row of the “nums” array
        // int[][] nums = {{1,4,9},
        //                 {11,4,3},
        //                 {2,2,3}};
        // System.out.println("Sum of Second row of matrix is : " + secondSum(nums));

        // //Q3//Write a program to FindTransposeofa Matrix.What is Transpose?
        // int tranposMatrix[][] = {{11,12,13},
        //                         {21,22,23}};
    }
    
    

}
