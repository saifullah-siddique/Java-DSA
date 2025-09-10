package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int starRow = 0;
        int startcol = 0 ;
        int endRow = matrix.length-1;
        int endcol = matrix[0].length-1;

        while (starRow <= endRow && startcol <= endcol) {
            for(int j = startcol ; j <= endcol; j++) {
                list.add(matrix[starRow][j]);
            }
            for(int k = starRow+1; k <= endRow ; k++) {
                list.add(matrix[k][endcol]);
            }
            for(int j = endcol-1 ; j >= startcol; j--) {
                if (starRow == endRow) {
                    return list;
                }
                list.add(matrix[endRow][j]);
            }
            for(int k = endRow-1 ; k > starRow ; k--) {
                if (startcol == endcol) {
                    return list;
                }
                list.add(matrix[k][startcol]);
            }
            starRow++;
            endRow--;
            startcol++;
            endcol--;
        }

        return list;
    }


    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));

    }
}
