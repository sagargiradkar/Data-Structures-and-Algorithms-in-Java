import java.util.*;

public class GP_19_Cheapest_Flight_K_Stops {

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

    // Method to create the graph from the flights array
    public static void createGraph(int flights[][], ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class Info {
        int v;       // Current vertex
        int cost;    // Cost to reach this vertex
        int stops;   // Number of stops taken to reach this vertex

        public Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(int n, int flights[][], int src, int dest, int k) {
        // Create a graph with adjacency lists
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        // Distance array to track the minimum cost to each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Queue to perform BFS-like traversal
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // Start with the source node

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // If the number of stops exceeds k, continue
            if (curr.stops > k) {
                continue;
            }

            // Explore neighbors of the current vertex
            for (Edge e : graph[curr.v]) {
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                // Relaxation step
                if (curr.cost + wt < dist[v]) {
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        // Return the minimum cost to the destination
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int flights[][] = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int src = 0, dst = 3, k = 1;

        // Calculate the cheapest flight with up to k stops
        int result = cheapestFlight(n, flights, src, dst, k);

        // Print the result
        System.out.println("Cheapest cost: " + result);
    }
}
