import java.util.PriorityQueue;

public class GP_20_Connecting_Cities {
    static class Edge implements Comparable<Edge> {
        int dest;
        int cost;

        public Edge(int cost, int dest) {
            this.cost = cost;
            this.dest = dest;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.cost - e2.cost;
        }
    }

    public static int connectCities(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();

            if (!vis[curr.dest]) {
                vis[curr.dest] = true;
                finalCost += curr.cost;

                for (int i = 0; i < cities[curr.dest].length; i++) {
                    if (cities[curr.dest][i] != 0 && !vis[i]) {
                        pq.add(new Edge(cities[curr.dest][i], i));
                    }
                }
            }
        }

        // Check if all cities are connected
        for (boolean visited : vis) {
            if (!visited) {
                return -1; // Not all cities are connected
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        // Test case 1: Fully connected graph
        int cities1[][] = {
            {0, 1, 2, 3},
            {1, 0, 4, 5},
            {2, 4, 0, 6},
            {3, 5, 6, 0}
        };
        System.out.println("Test Case 1: " + connectCities(cities1)); // Output: 10

        // Test case 2: Sparse graph
        int cities2[][] = {
            {0, 2, 0, 6},
            {2, 0, 3, 8},
            {0, 3, 0, 0},
            {6, 8, 0, 0}
        };
        System.out.println("Test Case 2: " + connectCities(cities2)); // Output: 11

        // Test case 3: Disconnected graph
        int cities3[][] = {
            {0, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 2},
            {0, 0, 2, 0}
        };
        System.out.println("Test Case 3: " + connectCities(cities3)); // Output: -1 (not fully connected)

        // Test case 4: Single city (no connections)
        int cities4[][] = {
            {0}
        };
        System.out.println("Test Case 4: " + connectCities(cities4)); // Output: 0

        // Test case 5: Linearly connected graph
        int cities5[][] = {
            {0, 4, 0, 0},
            {4, 0, 5, 0},
            {0, 5, 0, 6},
            {0, 0, 6, 0}
        };
        System.out.println("Test Case 5: " + connectCities(cities5)); // Output: 15
    }
}
