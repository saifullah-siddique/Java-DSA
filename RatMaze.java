public class RatMaze  {
    /*----SAIFULLAH SIDDIQUI---- */

    //count  number of ways
    static int count = 0 ;

    public static int mazeWay(int maze[][] , int i , int j , int n , int m, boolean visited[][], int path[][]) {
        //Base Case
        if (i == n-1 && j == m-1) {
            path[i][j] = 1;
            print2Darray(path);
            count++; 
            return 1;
        } 
        //Edge Cases
        else if (i < 0 || j < 0 || i >= n || j >= m || maze[i][j] == 0 || visited[i][j]) { 
            return 0;
        }
        
        //track visited cell
        visited[i][j] = true;
        //store current path 
        path[i][j] = 1;

        //Calls in All 4 direction (U , D, L, R)
        int up = mazeWay(maze, i-1, j, n, m,visited, path);
        int down = mazeWay(maze, i+1, j, n, m, visited, path);
        int left = mazeWay(maze, i, j-1, n, m, visited, path);
        int right = mazeWay(maze, i, j+1, n, m, visited, path);
        
        //Backtrack
        visited[i][j] = false;
        path[i][j] = 0;
        

        return up + down + right + left;
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
        //maze
        int maze[][] = { 
        { 1, 0, 0, 0 },
        { 1, 1, 0, 1 },
        { 0, 1, 0, 0 },
        { 1, 1, 1, 1 }};

        //lenth of n X m
        int n = maze.length;
        int m = maze[0].length;
        boolean visited[][] = new boolean[n][m];
        
        int path[][] = new int[n][m];

        //function Call 
        mazeWay(maze, 0, 0, n, m, visited, path);
        System.out.println("Total way to reach maze : " + count);

    } 

    
}