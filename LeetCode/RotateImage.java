package LeetCode;



public class RotateImage {
    public static void print2DArray(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void reverse(int arr[]) {
        int left = 0 , right = arr.length-1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void rotate(int[][] matrix) {
        int start = 0;
        int end = matrix.length-1;
        while (start < end) {
            for(int i = start ; i < end ; i++) {
                int temp = matrix[start][i+1];
                matrix[start][i+1] = matrix[i+1][start];
                matrix[i+1][start] = temp;
            }

            reverse(matrix[start]);
            start++;
        }
        reverse(matrix[start]);
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        // print2DArray(matrix2);
        rotate(matrix2);
        print2DArray(matrix2);
        // rotate(matrix);
        // print2DArray(matrix);
    }
}
