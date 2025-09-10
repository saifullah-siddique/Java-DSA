package Graph;

import java.util.*;

public class Graph3 {
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }  
    }

    //topological sorting BFS kanh`s algorithm 

    // public static void createGraph(ArrayList<Edge> graph[]) {
    //     for(int i = 0 ; i < graph.length ; i++) {
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 1));

    //     graph[4].add(new Edge(4, 0));
    //     graph[4].add(new Edge(4, 1));

    //     graph[5].add(new Edge(5, 0));
    //     graph[5].add(new Edge(5, 2));
    // }

    public static void inDegree(ArrayList<Edge> graph[], int inDeg[]) {
        for(int i = 0 ; i <graph.length; i++) {
            for(int j = 0 ; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topSortBfs(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        inDegree(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < inDeg.length ; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for(int i = 0 ; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }       
        }

    }


    //All Paths From Source to target
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i < graph.length ; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    //exponetial time complexity 
    public static void allPathSrc2Trgt(ArrayList<Edge> graph[], int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path+dest);
            return;
        }

        for(int i = 0 ; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            allPathSrc2Trgt(graph, e.dest, dest, path+src);
        }
    }

    public static void main(String[] args) {
        //topological sort using BFS 
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        
        // //topological sorting BFS kahn`s algorithm
        // topSortBfs(graph);

        // //All Paths From Source to destination
        // allPathSrc2Trgt(graph, 5, 1, "");


        //class call
        DijkstrasAlgorithm.main(args);
    }
}

//Dikstras Algorithm
class DijkstrasAlgorithm {
    static class Edge {
        int src;
        int dest;
        int wt;
        
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));
        
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    static class Pair implements Comparable<Pair>{
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path; //path based sorting for pairs
        }
        
    }

    public static void dijkstra(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length];
        for(int i = 0 ; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;
                for(int i = 0 ; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i = 0 ; i < dist.length ; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.print("Shortest path form Source to Every Vertices : ");
        dijkstra(graph, 0);
    }
    
}
