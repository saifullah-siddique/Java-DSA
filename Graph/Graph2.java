package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph2 {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    /*  //graph of detect cycle 
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i<graph.length; i++) {
            graph [i] = new ArrayList<>(); 
        }

        graph [0].add(new Edge( 0,  1));
        graph [0].add(new Edge( 0,  2));
        graph [0].add(new Edge( 0,  3));

        graph [1].add(new Edge( 1,  0));
        graph [1].add(new Edge( 1,  2));

        graph [2].add(new Edge( 2,  0));
        graph [2].add(new Edge( 2,  1));

        graph [3].add(new Edge( 3,  0));
        graph [3].add(new Edge( 3,  4));

        graph [4].add(new Edge( 4,  3));
    }
     */


    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length ; i++) {
            if (!vis[i] ) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0 ; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case 3
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            //case 1
            else if (vis[e.dest] && e.dest != par) {
                return true;
            }
            //case 2 skip 
        }

        return false;
    }


    //Bipartite grap question ----------------------------------------------
    // public static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i = 0 ; i < graph.length ; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph [0].add(new Edge( 0,  1));
    //     graph [0].add(new Edge( 0,  2));

    //     graph [1].add(new Edge( 1,  0));
    //     graph [1].add(new Edge( 1,  3));

    //     graph [2].add(new Edge( 2,  0));
    //     graph [2].add(new Edge( 2,  4));

    //     graph [3].add(new Edge( 3,  1));
    //     graph [3].add(new Edge( 3,  4));

    //     graph [4].add(new Edge( 4,  2));
    //     graph [4].add(new Edge( 4,  3));
    // }

    public static boolean isBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        for(int i = 0 ; i < color.length ; i++) {
            color[i] = -1;
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < graph.length ; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0; //yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for(int j = 0 ; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);
                        if (color[e.dest] == -1) {
                            int nexColor = color[curr] == 0 ? 1 : 0;
                            color[e.dest] = nexColor;
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            return false; //Note Bipartite
                        }
                    }
                } 
            }
        }

        return true;
    }


    //detect cycle for directed Graphs ---> using DFS 
    // public static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i = 0 ; i < graph.length ; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge( 0,  2));

    //     graph [1].add(new Edge( 1,  0));

    //     graph [2].add(new Edge( 2,  3));

    //     graph [3].add(new Edge( 3,  0));
    //     /* 
    //         0--->2
    //         ^^   |  contains cycle 
    //           \  |
    //         |  \\/
    //         1   3
    //     */
    // } 

    // static void createGraph (ArrayList<Edge> graph[]) {
    //     for(int i = 0 ; i<graph.length; i++) {
    //         graph [i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0,1));
    //     graph[0].add(new Edge(0,2));

    //     graph [1].add(new Edge(1,3));

    //     graph [2].add(new Edge(2,3));

    // }
    public static boolean isDirectedCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for ( int i = 0 ; i < graph.length ; i++) {
            if (!vis[i]) {
                if(isDirectedCycleUtil(graph, i, vis, stack)) return true;
            }
        }
        return false;
    }

    public static boolean isDirectedCycleUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i = 0 ; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) {
                return true;
            }

            if (!vis[e.dest] && isDirectedCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    //----------Topological Sorting-----------------------
    static void createGraph (ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph [i] = new ArrayList<>();
        }
        graph [2].add(new Edge( 2,  3));

        graph [3].add(new Edge( 3,  1));

        graph [4].add(new Edge( 4,  0));
        graph [4].add(new Edge( 4,  1));

        graph [5].add(new Edge( 5,  0));
        graph [5].add(new Edge( 5,  2));
    }
    
    public static void topSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0 ; i < graph.length ; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[],int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;

        for (int i = 0 ; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, s);
            }
        }

        s.push(curr);
    }
    public static void main(String[] args) {
/*        0----------------3
         /|
        / |
        1 |
        \ |
         \|
          2-----------------4
 */
        // int V = 5;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);

        // System.out.println("Graph Contains Cycle : " + detectCycle(graph));


        //Bipartite graph 
        /*
             0---------2
            /          |
           /           |
           1           |
           \           |
            \          |
             3---------4
        */
        // int V = 5 ;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] =new  ArrayList[V];
        // createGraph(graph);
        // System.out.println(isBipartite(graph));


        // //Cycle Detect in Directed Graph using DFs 
        // int V = 4;
        // @SuppressWarnings("unchecked")
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // System.out.print(isDirectedCycle(graph));


        //topological sorting using DFS(DAG)
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] =new  ArrayList[V];
        createGraph(graph);
        topSort(graph);
        



    }
}
