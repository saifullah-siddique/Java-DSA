package LeetCode;

public class TransposeMatrix {

    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int trans[][] = new int[m][n];
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                trans[j][i] = matrix[i][j];
            }
        }

        return trans;

    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        print2DArray(transpose(matrix));

    }
}
