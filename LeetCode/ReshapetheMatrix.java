package LeetCode;

public class ReshapetheMatrix {

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (n * m != r *c) return mat;

        int reshap[][] = new int[r][c];
        int k = 0;
        int l = 0;
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length && k < reshap[0].length ; j++) {
                reshap[l][k] = mat[i][j]; 
                if (k == c-1) {
                    l++;
                    k = 0;
                } else {
                    k++;
                }
                
            }
        }

        return reshap;

        
    }
    
    public static void main(String[] args) {
        int mat1[][] = {{1,2,3,4}};
        printMatrix(matrixReshape(mat1, 2, 4));
        
    }
}
