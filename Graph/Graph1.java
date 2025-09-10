package Graph;
import java.util.*;


public class Graph1 {

    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i<graph.length; i++) {
            graph [i] = new ArrayList<>(); 
        }
        graph [0].add(new Edge( 0,  1,  1));
        graph [0].add(new Edge( 0,  2,  1));

        graph [1].add(new Edge( 1,  0,  1));
        graph [1].add(new Edge( 1,  3,  1));

        graph [2].add(new Edge( 2,  0,  1));
        graph [2].add(new Edge( 2,  4,  1));

        graph [3].add(new Edge( 3,  1,  1));
        graph [3].add(new Edge( 3,  4,  1));
        graph [3].add(new Edge( 3,  5,  1));

        graph [4].add(new Edge( 4,  2,  1));
        graph [4].add(new Edge( 4,  3,  1));
        graph [4].add(new Edge( 4,  5,  1));

        graph [5].add(new Edge( 5,  3,  1));
        graph [5].add(new Edge( 5,  4,  1));
        graph [5].add(new Edge( 5,  6,  1));

        graph [5].add(new Edge( 6,  5,  1));
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0); // source 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0 ; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i = 0 ; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }

    }
    
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int des, boolean visited[]) {
        if (src == des) {
            return true;
        }

        visited[src] = true;

        for (int i = 0 ; i < graph[src].size() ; i++) {
            Edge e = graph[src].get(i);
            if (!visited[e.dest] && hasPath(graph, e.dest, des, visited)) {
                return true;
            }
        }

        return false;
    }


    ////----------Graph part 2-------///////
    
    //conceted components  for bfs 
    public static void Bfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length ; i++) {
            if (!visited[i]) {
                bfsUtil(graph, visited);
            }
        }
    }

    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // source 0
        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i = 0 ; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    //conected component traversal for dfs
    public static void Dfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length ; i++) {
            if (!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        System.out.print(curr + " ");
        visited[curr] = true;
        for(int i = 0 ; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfsUtil(graph, e.dest, visited);
            }
        }

    }


    public static void main(String[] args) {
        //create graph
        /*
        // int v = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge>[] graph = new ArrayList[v];
        // for (int i = 0 ; i < v  ; i++) {
        //     graph[i] =  new ArrayList<>();
        // }

        // //0 - vertex 
        // graph[0].add(new Edge(0, 1, 5));

        // //1- vertices 
        // graph[1].add(new Edge(1, 1, 5));
        // graph[1].add(new Edge(1, 2, 1));
        // graph[1].add(new Edge(1, 3, 3));

        // //2-vertices 
        // graph[2].add(new Edge(2, 1, 1));
        // graph[2].add(new Edge(2, 3, 1));
        // graph[2].add(new Edge(2, 4, 2));

        // //3-vertices
        // graph[3].add(new Edge(3, 1, 3));
        // graph[3].add(new Edge(3, 2, 1));

        // //4- vertices 
        // graph[4].add(new Edge(4, 2, 2));


        // //2's neighbors
        // for (int i = 0 ; i < graph[2].size(); i++ ) {
        //     Edge e = graph[2].get(i);
        //     System.out.println(e.dest);
        // }
        */

        //BFS (Breadth first search) 
        /*
                    1           3
             /                  |
            0                   |        5
             \                  |                   6
                    2           4
        */
        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // bfs(graph);

        // dfs(graph, 0, new boolean[V]);

        boolean path = hasPath(graph, 2, 6, new boolean[V]);
        System.out.println("source to destination path Exist : " + path);

        
    }
}
