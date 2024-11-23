import java.util.ArrayList;
import java.util.Collections;

public class GP_17_Kruskal_Algorithm {

    static int n = 7;
    static int rank[] = new int[n];
    static int par[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
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

    static class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    // Method to create a graph by populating the edge list
    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 5));
        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(2, 3, 1));
        edges.add(new Edge(2, 4, 4));
        edges.add(new Edge(4, 2, 2));
    }

    public static void kruskalMST(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges); // Sort edges by weight
        int mstCost = 0;
        int count = 0;

        for (int i = 0; count < V - 1; i++) {
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println("Minimum Cost of the MST: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges); // Populate the edge list
        kruskalMST(edges, V);
    }
}
