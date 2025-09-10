package Graph;

import Graph.Graph3.Edge;
import java.util.ArrayList;
import java.util.Stack;

public class GraphsSuplemental {

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph [0].add(new Edge( 0,  2));
        graph [0].add(new Edge( 0,  3));
        graph [1].add(new Edge( 1,  0));
        graph [2].add(new Edge( 2,  1));
        graph [3].add(new Edge( 3,  4));
    }

    public static void topSort(ArrayList<Edge> graph[], int curr, Stack<Integer> s, boolean vis[]) {
        vis[curr] =true;

        for(int i = 0 ; i < graph[curr].size(); i ++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topSort(graph, e.dest, s, vis);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> transpose[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0 ; i < transpose[curr].size(); i++) {
            Edge e = transpose[curr].get(i);
            if (!vis[e.dest]) {
                dfs(transpose, e.dest, vis);
            }
        }
    }

    public static void kosaRaju(ArrayList<Edge> graph[],int V) {
        //Step 1 - Top Sort of graph
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[graph.length];
        for(int i = 0 ; i < graph.length; i++) {
            if (!vis[i]) {
                topSort(graph, i, s, vis);
            }
        }

        //Step 2- Transpose Graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i = 0 ; i < graph.length; i++) {
            transpose[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < graph.length ; i++) {
            for(int j = 0 ; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        vis = new boolean[V];
        //step 3 - call DFS and print 
        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                System.out.print("SCC :-> ");
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // kosaRaju(graph, V);



        // //Bridge in Graph
        // BridgeInGraph.main(args);

        //Articulation Points
        ArticulationPoint.main(args);
    }
}


class BridgeInGraph {

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
    
    }

    public static void tarjanBridge(ArrayList<Edge> graph[], int V) {
        int time = 0;
        int discT[] = new int[V];
        int lowDiscT[] = new int[V];
        boolean vis[] = new boolean[V];

        for(int i = 0 ; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, discT, lowDiscT, vis, time);
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[],int curr, int par, int discT[], int lowDiscT[],boolean vis[], int time) {
        vis[curr] = true;
        discT[curr] = lowDiscT[curr] = ++time;

        for(int i = 0 ; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
               continue; 
            } else if (!vis[e.dest]) {
                dfs(graph, e.dest, curr, discT, lowDiscT, vis, time);
                lowDiscT[curr] = Math.min(lowDiscT[curr], lowDiscT[e.dest]);
                if (discT[curr] < lowDiscT[e.dest]) {
                    System.out.println("Bridg : " + curr + " ----- " + e.dest);
                }
                
            } else {
                lowDiscT[curr] = Math.min(lowDiscT[curr], discT[e.dest]);
            } 
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);
    }
}

class ArticulationPoint {

        public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0, 3));
        
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static void dfs(ArrayList<Edge> graph[],int curr, int par, int dt[], int low[], boolean vis[],boolean ap[], int time ) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(int i = 0 ; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (e.dest == par) {
                continue;
            } else if (!vis[e.dest]) {
                dfs(graph, e.dest, curr, dt, low, vis, ap, time);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (par != -1 && dt[curr] <= low[e.dest]) {
                   ap[curr] = true;
                }
                children++;
            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }

        if (par == -1 && children > 1) {
            ap[curr] = true;
        }

    }

    public static void getAP(ArrayList<Edge> graph[], int V) {
        int time = 0;
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean vis[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i = 0 ; i < graph.length ; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, dt, low, vis, ap, time);
            }
        }

        for(int i = 0 ; i < graph.length ; i++) {
            if (ap[i]) {
                System.out.println ("AP : " + i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);


    }

}
