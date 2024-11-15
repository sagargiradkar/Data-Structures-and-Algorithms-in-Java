import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class GP_08_Bipartite_Graph {

    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // Method to create a graph
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example graph (you can modify for testing)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 0));
        graph[0].add(new Edge(0, 3));

        return graph;
    }

    // Check if the graph is bipartite
    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // -1 means unvisited
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // If unvisited, start BFS
                q.add(i);
                col[i] = 0; // Assign first color

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Edge e : graph[curr]) {
                        if (col[e.dest] == -1) {
                            col[e.dest] = 1 - col[curr]; // Alternate color
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; // Same color on both ends of an edge
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test case 1: Bipartite graph
        ArrayList<Edge>[] graph1 = createGraph(4);
        System.out.println("Test Case 1: " + isBipartite(graph1)); // true

        // Test case 2: Non-bipartite graph
        ArrayList<Edge>[] graph2 = createGraph(5);
        graph2[0].add(new Edge(0, 4));
        graph2[4].add(new Edge(4, 0));
        System.out.println("Test Case 2: " + isBipartite(graph2)); // false

        // Test case 3: Single vertex graph
        ArrayList<Edge>[] graph3 = new ArrayList[1];
        graph3[0] = new ArrayList<>();
        System.out.println("Test Case 3: " + isBipartite(graph3)); // true

        // Test case 4: Two disconnected components
        ArrayList<Edge>[] graph4 = new ArrayList[6];
        for (int i = 0; i < 6; i++) graph4[i] = new ArrayList<>();
        graph4[0].add(new Edge(0, 1));
        graph4[1].add(new Edge(1, 0));
        graph4[2].add(new Edge(2, 3));
        graph4[3].add(new Edge(3, 2));
        System.out.println("Test Case 4: " + isBipartite(graph4)); // true

        // Test case 5: Complete bipartite graph K3,3
        ArrayList<Edge>[] graph5 = new ArrayList[6];
        for (int i = 0; i < 6; i++) graph5[i] = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                graph5[i].add(new Edge(i, j));
                graph5[j].add(new Edge(j, i));
            }
        }
        System.out.println("Test Case 5: " + isBipartite(graph5)); // true
    }
}
