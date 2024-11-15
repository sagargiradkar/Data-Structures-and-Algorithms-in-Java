import java.util.ArrayList;

public class GP_09_Cycle_Detection_Directed_Graph {

    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
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

        // Example 1: Graph with a Cycle (0 -> 1 -> 2 -> 3 -> 0)
        if (example == 1) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 3));
            graph[3].add(new Edge(3, 0));
        }

        // Example 2: Graph without a Cycle (Tree-like structure)
        else if (example == 2) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 3));
        }

        // Example 3: Graph with a Cycle (1 -> 2 -> 4 -> 1)
        else if (example == 3) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 4));
            graph[4].add(new Edge(4, 1));
        }

        // Example 4: Graph without a Cycle (Linear chain)
        else if (example == 4) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 3));
            graph[3].add(new Edge(3, 4));
        }

        // Example 5: Complex graph with multiple components, one having a cycle
        else if (example == 5) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 0)); // Cycle here

            graph[3].add(new Edge(3, 4));
            graph[4].add(new Edge(4, 5));
        }

        return graph;
    }

    // Method to detect a cycle in a directed graph
    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCycleUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { // Cycle detected
                return true;
            }
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 6;

        // Test Case 1: Graph with a cycle
        ArrayList<Edge>[] graph1 = createGraph(V, 1);
        System.out.println("Test Case 1 (Cycle Present): " + isCycle(graph1)); // Expected: true

        // Test Case 2: Graph without a cycle
        ArrayList<Edge>[] graph2 = createGraph(V, 2);
        System.out.println("Test Case 2 (No Cycle): " + isCycle(graph2)); // Expected: false

        // Test Case 3: Graph with a cycle (different structure)
        ArrayList<Edge>[] graph3 = createGraph(V, 3);
        System.out.println("Test Case 3 (Cycle Present): " + isCycle(graph3)); // Expected: true

        // Test Case 4: Linear graph without a cycle
        ArrayList<Edge>[] graph4 = createGraph(V, 4);
        System.out.println("Test Case 4 (No Cycle): " + isCycle(graph4)); // Expected: false

        // Test Case 5: Complex graph with multiple components
        ArrayList<Edge>[] graph5 = createGraph(V, 5);
        System.out.println("Test Case 5 (Cycle Present in Component): " + isCycle(graph5)); // Expected: true
    }
}
