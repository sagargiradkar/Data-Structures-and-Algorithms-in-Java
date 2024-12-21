import java.util.ArrayList;
import java.util.List;

public class D_21_Max_KDivisible_Components {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int n = 5; // Number of nodes
        int[][] edges = {
            {0, 1},
            {1, 2},
            {1, 3},
            {3, 4}
        }; // Edges of the tree
        int[] values = {2, 3, 4, 6, 5}; // Node values
        int k = 3; // Divisibility factor

        // Output the result
        System.out.println("Maximum K-Divisible Components: " + solution.maxKDivisibleComponents(n, edges, values, k));
    }
}

class Solution {
    private long cnt = 0;

    // Function to calculate subtree sums
    private void getSubtree(int node, List<List<Integer>> adj, int parent, long[] subtree) {
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                getSubtree(neighbor, adj, node, subtree);
                subtree[node] += subtree[neighbor];
            }
        }
    }

    // DFS to count valid K-divisible components
    private void dfs(int node, List<List<Integer>> adj, int parent, long[] subtree, int k) {
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                long parentSubtree = subtree[node] - subtree[neighbor];
                long childSubtree = subtree[neighbor];

                if (parentSubtree % k == 0 && childSubtree % k == 0) {
                    cnt++;
                } else {
                    subtree[neighbor] = subtree[node];
                }

                dfs(neighbor, adj, node, subtree, k);
            }
        }
    }

    // Main function to calculate the maximum number of K-divisible components
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Building adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Array to store subtree sums
        long[] subtree = new long[n];
        for (int i = 0; i < n; i++) subtree[i] = values[i];

        // Calculate subtree sums
        getSubtree(0, adj, -1, subtree);

        // Perform DFS to count K-divisible components
        dfs(0, adj, -1, subtree, k);

        // Return the count of components
        return (int) (cnt + 1);
    }
}
