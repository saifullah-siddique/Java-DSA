public class Backtracking {
    public static void printArr(int arr[]) {
        for (int i = 0 ; i <arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); 
    }

    public static void changeArray(int arr[], int i, int val) {
        if(i == arr.length) {
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArray(arr, i+1, val+1);
        arr[i] -= 2;
    }

    public static void subset(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.print(ans + " ");
            return; 
        }

        subset(str, ans+str.charAt(i), i+1);
        subset(str, ans, i+1);
    }

    public static void findpermutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i = 0 ; i <str.length() ; i++) {
            char curr = str.charAt(i);
            String newstr = str.substring(0, i) + str.substring(i+1);
            findpermutation(newstr, ans+curr);
        }
    }

    /*----------------nQueens------------------- */
    public static boolean isSafe(char chess[][], int row , int col) {
        //horizontal Up
        for(int i = row-1 ; i >= 0 ; i--) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        //diag left
        for(int i = row-1, j = col-1  ; i >= 0 && j >=0 ; i-- , j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        //diag right 
        for(int i = row-1, j = col+1 ; i >= 0 && j < chess.length ; i--, j++ ) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    static int count = 0;

    public static boolean nQueens(char chess[][], int row) {
        if (row == chess.length) {
            printChess(chess);
            // count++;
            return true;
        }

        for (int j = 0 ; j < chess.length ; j++) {
            if(isSafe(chess, row, j)) {
                chess[row][j] = 'Q';
                if (nQueens(chess, row+1)) {
                    return true;
                }
                chess[row][j] = 'X';
            }
        }

        return false;
    }

    public static void printChess(char chess[][]) {
        System.out.println("-----------Chess-----------");
        for(int i = 0 ; i <chess.length ; i++) {
            for (int j = 0 ; j < chess.length ; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }
    /*----------------nQueens End------------------- */


    public static int factorial(int n) {
        if (n == 0 || n ==1) return 1;
        return n * factorial(n-1);
    }

    //using time complexty of O(2^(n+m))
    public static int gridWays(int i, int j, int n, int m) {
        if (i == n-1 && j == m-1){
            return 1;
        } else if (i >= n || j >= m) {
            return 0 ;
        }
        return gridWays(i + 1, j, n, m) + gridWays(i, j + 1, n, m);
    }

    //using fact to O(n+m) time complexity
    public static int GridWays(int n , int m) {
        int numerator = factorial(n + m - 2);
        int denominator = factorial(n-1) * factorial(m-1);
        return numerator/denominator;
    }

    //----------------------sudoku solver--------------
    public static boolean isSAFE(int sudoku[][], int row, int col, int num) {
        //colmn
        for(int j = 0 ; j < sudoku[0].length ; j++) {
            if(sudoku[row][j] == num) {
                return false;
            }
        }
        
        //row
        for(int i = 0 ; i < sudoku.length ; i++) {
            if(sudoku[i][col] == num) {
                return false;
            }
        }


        //grid 
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;
        for(int i = sr ; i < sr + 3 ; i++) {
            for(int j = sc ; j < sc + 3 ; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][] , int row , int col){
        //base case
        if (row == 9) {
            System.out.println("Solution:- ");
            print2Darray(sudoku);
            return true;
        }

        //recursion
        int nexRow = row , nexCol = col+1;
        if (col+1 == 9) {
            nexRow++;
            nexCol = 0;
        }
        // if not zero 
        if (sudoku[row][col] != 0 ) {
            return sudokuSolver(sudoku, nexRow, nexCol);
        }

        for(int digit = 1 ; digit <= 9 ; digit++) {
            if(isSAFE(sudoku, row, col, digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nexRow, nexCol)) {
                    return true;
                }
                sudoku[row][col] = 0;  
            } 
        }
        return false;
    }

    public static void print2Darray(int arr[][]) {
        for(int i = 0 ; i <arr.length ; i++) {
            for (int j = 0 ; j <arr[0].length ; j++ ) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {

        // // BackTracking In Array
        // int[] arr = new int[5];
        // changeArray(arr, 0, 1);
        // printArr(arr);

        // //print total number of subset in string "abc"
        // String str = "abc";
        // subset(str, "", 0);


        // //find permutation 
        // String str = "abc";
        // findpermutation(str, "");


        // //n-queens
        // int n = 2;
        // char chess[][] = new char[n][n];
        // for (int i = 0 ; i < n ; i++) {
        //     for (int j = 0 ; j < n; j++) {
        //         chess[i][j] = 'X';
        //     }  
        // }
        // nQueens(chess, 0);
        // System.out.println("Total no of ways = " + count);


        // //Grid Ways 
        // int n = 4, m = 4;
        // // System.out.println(gridWays(0 , 0, n, m));
        // System.out.println(GridWays(n, m));


        // //sudoku solver 
        // int sudoku[][] = { 
        // {0, 0, 8, 0, 0, 0, 0, 0, 0},
        // {4, 9, 0, 1, 5, 7, 0, 0, 2},
        // {0, 0, 3, 0, 0, 4, 1, 9, 0},
        // {1, 8, 5, 0, 6, 0, 0, 2, 0},
        // {0, 0, 0, 0, 2, 0, 0, 6, 0},
        // {9, 6, 0, 4, 0, 5, 3, 0, 0},
        // {0, 3, 0, 0, 7, 2, 0, 0, 4},
        // {0, 4, 9, 0, 3, 0, 0, 5, 7},
        // {8, 2, 7, 0, 0, 9, 0, 1, 3}
        // };

        // sudokuSolver(sudoku, 0, 0);

        Practice.main(null);

    }
}

class Practice  {

    static int count = 0 ;

    public static int mazeWay(int maze[][] , int i , int j , int n , int m, boolean visited[][], int path[][]) {
        if (i == n-1 && j == m-1) {
            path[i][j] = 1;
            Backtracking.print2Darray(path);
            count++; 
            return 1;
        } else if (i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        
        visited[i][j] = true;
        path[i][j] = 1;
        int up = mazeWay(maze, i-1, j, n, m,visited, path);
        int down = mazeWay(maze, i+1, j, n, m, visited, path);
        int left = mazeWay(maze, i, j-1, n, m, visited, path);
        int right = mazeWay(maze, i, j+1, n, m, visited, path);
        
        visited[i][j] = false;
        path[i][j] = 0;
        

        return up + down + right + left;
    }


    public static void main(String args[]) {
        // int maze[][] = { 
        // { 1, 0, 0, 0 },
        // { 1, 1, 0, 1 },
        // { 0, 1, 0, 0 },
        // { 1, 1, 1, 1 }};

        // int n = maze.length;
        // int m = maze[0].length;
        // boolean visited[][] = new boolean[n][m];
        // int path[][] = new int[n][m];

        // mazeWay(maze, 0, 0, n, m, visited, path);
        // System.out.println("Total way to reach maze : " + count);



        //

    } 

    
}