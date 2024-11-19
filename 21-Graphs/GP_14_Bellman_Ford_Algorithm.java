
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GP_14_Bellman_Ford_Algorithm {

    static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Method to create a graph
    public static ArrayList<Edge>[] createGraph(int V) {
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph edges
        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        return graph;
    }

    public static void bellmanFored(ArrayList<Edge>[] graph, int src) {
        int dist[] = new int[graph.length];

        for (int i = 0; i < dist.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
            int V = graph.length;

            for (i = 0; i < V - 1; i++) {
                for (int j = 0; j < graph.length; j++) {
                    for (int k = 0; k < graph[j].size(); k++) {
                        Edge e = graph[j].get(k);

                        int u = e.src;
                        int v = e.dest;
                        int wt = e.wt;

                        if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                            dist[v] = dist[u] + wt;
                        }

                    }
                }
            }

        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V = 5; // Adjusted to match the graph structure
        ArrayList<Edge>[] graph = createGraph(V); // Create and populate the graph

        int src = 0; // Starting node
        bellmanFored(graph, 0); // Run Dijkstra's algorithm
    }
}
