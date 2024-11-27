import java.util.*;

public class D_27_Shortest_Distance_After_Queries {
    public static void main(String[] args) {
        // Example: Number of nodes and queries
        int n = 5;
        int[][] queries = {
            {0, 3}, // Add an edge from 0 to 3
            {3, 4}, // Add an edge from 3 to 4
            {1, 4}  // Add an edge from 1 to 4
        };

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the function and get the results
        int[] results = solution.shortestDistanceAfterQueries(n, queries);

        // Print the results for each query
        System.out.println("Shortest distances after each query:");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Query " + (i + 1) + ": " + results[i]);
        }
    }
}

class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    private int bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int node = queue.poll();

                if (node == n - 1) {
                    return level; // Found the destination node
                }

                for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
            level++;
        }
        return -1; // If destination node is unreachable
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        adj.clear();

        // Initialize adjacency list with direct edges (i -> i + 1)
        for (int i = 0; i < n - 1; i++) {
            adj.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }

        int k = queries.length;
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adj.computeIfAbsent(u, k1 -> new ArrayList<>()).add(v);
            res[i] = bfs(n);
        }

        return res;
    }
}