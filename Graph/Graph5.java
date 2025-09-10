package Graph;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph5 {
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

    public static void createGraph(ArrayList<Edge> graph[], int flight[][]) {
        for(int i = 0 ; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < flight.length ; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    static class Info {
        int v;
        int cost;
        int stops;

        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }

        
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dst, int k) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(graph, flights);

        int cost[] = new int[graph.length];
        for(int i = 0 ; i < cost.length; i++) {
            if (i != src) {
                cost[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0,0));

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.stops > k) {
                break;
            }
            System.out.println("v : " + curr.v + " cost : " + curr.cost + " Stops : " + curr.stops);
                
            for(int i = 0 ; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.dest;
                int currCost = e.wt;
                if (cost[u] != Integer.MAX_VALUE && curr.cost + currCost < cost[v] && curr.stops <= k) {
                    cost[v] = curr.cost + currCost;
                    q.add(new Info(v, cost[v], curr.stops + 1));
                }
            }
            
        }

        for(int cst : cost) {
            System.out.print(cst + " ");
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];


    }

    public static void main(String[] args) {
        // int n = 4;
        // int flight[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        // int src = 0 , dst = 3, k=1;
        // System.out.println(cheapestFlight(n, flight, src, dst, k) + "   ||  ");
        
        // ConnectingCities.main(args);

        // DisjointSet.main(args);

        // KruskalsAlgorithm.main(args);

        FloodFill.main(args);

    }
}




class ConnectingCities {

    static class Edge implements Comparable<Edge> {
        int dst;
        int cost;

        Edge(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        } 
    }

    public static int connectingCitiesMinCost(int cities[][]) {
    
        boolean vis[] = new boolean[cities.length];
        int minCost = 0;

        
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(0, 0));

        while (!q.isEmpty()) {
            Edge curr = q.remove();
            if (!vis[curr.dst]) {
                vis[curr.dst] = true;
                minCost += curr.cost;
                
                for(int i = 0 ; i < cities[curr.dst].length; i++) {
                    if (cities[curr.dst][i] != 0) {
                        q.add(new Edge(i, cities[curr.dst][i]));
                    }
                }  
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        int cities[][] ={{0, 1, 2, 3, 4},
                        {1, 0, 5, 0, 7},
                        {2, 5, 0, 6, 0},
                        {3, 0, 6, 0, 0},
                        {4, 7, 0, 0, 0}};

        System.out.println(connectingCitiesMinCost(cities));
    }
}


class DisjointSet {
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i = 0 ; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static void main(String[] args) {
        init();
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        union(1, 5);
        System.out.println(find(5));

        for(int i : par) {
            System.out.print(i + " ");
        }
    }
}


class KruskalsAlgorithm {

    static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s; 
            this.dst = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }  
    }

    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge( 0,  1,  10));
        edges.add(new Edge( 0,  2,  15));
        edges.add(new Edge( 0,  3, 30));
        edges.add(new Edge( 1,  3,  40));
        edges.add(new Edge( 2,  3,  50));
    }
    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for(int i = 0 ; i < par.length; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }

        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (parA == parB) {
            return;
        }

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    //Kruskal`s Algorithm for Minimun Spaning Tree (MST)
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int mstCost = 0 ;
        int count = 0;

        for(int i = 0 ; count < V-1; i++) {
            Edge e = edges.get(i);
            
            int parA = find(e.src);
            int parB = find(e.dst);
            // If src and dst are in different sets, include this edge in MST
            if (parA != parB) {
                union(e.src, e.dst); // Union the sets
                mstCost += e.wt;     // Add edge weight to MST cost
                count++;             // Increment edge count in MST
            }
        }
        System.out.println(mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalsMST(edges,V);

    }
}

class FloodFill {
    public static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int originalColor) {
        if ((sr < 0 || sr >= image.length) || (sc < 0 || sc >= image[0].length) || vis[sr][sc] || image[sr][sc] != originalColor) {
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        helper(image, sr, sc-1, color, vis, originalColor); //left
        helper(image, sr, sc+1, color, vis, originalColor); //right
        helper(image, sr-1, sc, color, vis, originalColor); //up
        helper(image, sr+1, sc, color, vis, originalColor);//down
    }

    public static int[][] floodFill(int image[][], int sr, int sc, int color){
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
        
    }

    public static void main(String[] args) {
        int image[][] = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};
        int newImage[][] = floodFill(image, 1, 1, 2);
        for(int i = 0 ; i < newImage.length ; i++) {
            for (int j = 0 ; j < newImage[0].length ; j++) {
                System.out.print(newImage[i][j] + " ");
            }
            System.out.println();
        }

    }
}

