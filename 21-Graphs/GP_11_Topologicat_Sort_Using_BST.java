import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GP_11_Topological_Sort_Using_BST {

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
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        int count = 0; // To detect cycles
        // BFS
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            count++;

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if (indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        // Check for cycles
        if (count != graph.length) {
            System.out.println("\nCycle detected. Topological sort not possible.");
        }
    }

    private static void calcIndeg(ArrayList<Edge>[] graph, int indeg[]) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }

    public static void main(String[] args) {
        int V = 6; // Adjusted to match meaningful test cases

        // Test Case 1: Graph with a cycle
        System.out.println("Test Case 1 (Cycle Present):");
        ArrayList<Edge>[] graph1 = createGraph(V, 1);
        topSort(graph1);

        // Test Case 2: Graph without a cycle
        System.out.println("\nTest Case 2 (No Cycle):");
        ArrayList<Edge>[] graph2 = createGraph(V, 2);
        topSort(graph2);

        // Test Case 3: Graph with a cycle
        System.out.println("\nTest Case 3 (Cycle Present):");
        ArrayList<Edge>[] graph3 = createGraph(V, 3);
        topSort(graph3);

        // Test Case 4: Linear graph without a cycle
        System.out.println("\nTest Case 4 (No Cycle):");
        ArrayList<Edge>[] graph4 = createGraph(V, 4);
        topSort(graph4);

        // Test Case 5: Complex graph
        System.out.println("\nTest Case 5 (No Cycle):");
        ArrayList<Edge>[] graph5 = createGraph(V, 5);
        topSort(graph5);
    }
}
