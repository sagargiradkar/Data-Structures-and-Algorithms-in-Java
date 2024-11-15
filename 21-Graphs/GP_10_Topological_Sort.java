import java.util.ArrayList;
import java.util.Stack;

class GP_10_Topological_Sort {
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

        // Example graphs
        if (example == 1) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 3));
            graph[3].add(new Edge(3, 0)); // Cycle here
        } else if (example == 2) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 3));
        } else if (example == 3) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 4));
            graph[4].add(new Edge(4, 1)); // Cycle here
        } else if (example == 4) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[2].add(new Edge(2, 3));
            graph[3].add(new Edge(3, 4));
        } else if (example == 5) {
            graph[0].add(new Edge(0, 1));
            graph[1].add(new Edge(1, 2));
            graph[3].add(new Edge(3, 4));
            graph[4].add(new Edge(4, 5));
        }

        return graph;
    }

    // Topological sort method
    public static void topSort(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        // Perform DFS for all nodes
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topSortUtil(graph, i, vis, stack);
            }
        }

        // Print the sorted order
        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.dest]) {
                topSortUtil(graph, e.dest, vis, stack);
            }
        }

        stack.push(curr); // Add to stack after exploring neighbors
    }

    public static void main(String[] args) {
        int V = 6;

        // Test Case 1: Graph with a cycle
        System.out.println("Test Case 1 (Cycle Present):");
        ArrayList<Edge>[] graph1 = createGraph(V, 1);
        topSort(graph1); // Expected: No meaningful order due to cycle

        // Test Case 2: Graph without a cycle
        System.out.println("Test Case 2 (No Cycle):");
        ArrayList<Edge>[] graph2 = createGraph(V, 2);
        topSort(graph2); // Expected: Topological order

        // Test Case 3: Graph with a cycle
        System.out.println("Test Case 3 (Cycle Present):");
        ArrayList<Edge>[] graph3 = createGraph(V, 3);
        topSort(graph3); // Expected: No meaningful order due to cycle

        // Test Case 4: Linear graph without a cycle
        System.out.println("Test Case 4 (No Cycle):");
        ArrayList<Edge>[] graph4 = createGraph(V, 4);
        topSort(graph4); // Expected: 0 -> 1 -> 2 -> 3 -> 4

        // Test Case 5: Complex graph
        System.out.println("Test Case 5 (No Cycle):");
        ArrayList<Edge>[] graph5 = createGraph(V, 5);
        topSort(graph5); // Expected: A valid topological order
    }
}
