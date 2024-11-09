import java.util.*;

public class GP_07_Cycle_Detection_Undirected_Graph {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Method to create a graph
    public static ArrayList<Edge>[] createGraph(int V, int example) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example 1: Graph with a Cycle (0-1-2-3-0)
        if (example == 1) {
            graph[0].add(new Edge(0, 1, 5));
            graph[1].add(new Edge(1, 0, 5));

            graph[1].add(new Edge(1, 2, 1));
            graph[2].add(new Edge(2, 1, 1));

            graph[2].add(new Edge(2, 3, 2));
            graph[3].add(new Edge(3, 2, 2));

            graph[3].add(new Edge(3, 0, 3));
            graph[0].add(new Edge(0, 3, 3));
        }

        // Example 2: Graph without a Cycle (Tree-like)
        else if (example == 2) {
            graph[0].add(new Edge(0, 1, 5));
            graph[1].add(new Edge(1, 0, 5));

            graph[1].add(new Edge(1, 2, 1));
            graph[2].add(new Edge(2, 1, 1));

            graph[2].add(new Edge(2, 3, 2));
            graph[3].add(new Edge(3, 2, 2));
        }

        // Example 3: Graph with a Cycle (1-2-4-1)
        else if (example == 3) {
            graph[0].add(new Edge(0, 1, 5));
            graph[1].add(new Edge(1, 0, 5));

            graph[1].add(new Edge(1, 2, 1));
            graph[2].add(new Edge(2, 1, 1));

            graph[2].add(new Edge(2, 4, 2));
            graph[4].add(new Edge(4, 2, 2));

            graph[4].add(new Edge(4, 1, 3));
            graph[1].add(new Edge(1, 4, 3));
        }

        // Example 4: Graph without a Cycle (Linear Chain)
        else if (example == 4) {
            graph[0].add(new Edge(0, 1, 5));
            graph[1].add(new Edge(1, 0, 5));

            graph[1].add(new Edge(1, 2, 1));
            graph[2].add(new Edge(2, 1, 1));

            graph[2].add(new Edge(2, 3, 2));
            graph[3].add(new Edge(3, 2, 2));

            graph[3].add(new Edge(3, 4, 3));
            graph[4].add(new Edge(4, 3, 3));
        }

        return graph;
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            } else if (vis[e.dest] && e.dest != par) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices

        // Change the argument here to test different examples (1, 2, 3, or 4)
        ArrayList<Edge>[] graph = createGraph(V, 1); // Example 1 selected

        System.out.println(detectCycle(graph));
    }
}
