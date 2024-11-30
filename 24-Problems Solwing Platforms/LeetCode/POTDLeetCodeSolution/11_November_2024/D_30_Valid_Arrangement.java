import java.util.*;

public class D_30_Valid_Arrangement {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple pair arrangement
        int[][] pairs1 = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        System.out.println("Valid arrangement: " + Arrays.deepToString(solution.validArrangement(pairs1)));
        // Expected output: [[11, 9], [9, 4], [4, 5], [5, 1]]

        // Test Case 2: Linear path
        int[][] pairs2 = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Valid arrangement: " + Arrays.deepToString(solution.validArrangement(pairs2)));
        // Expected output: [[1, 2], [2, 3], [3, 4]]

        // Test Case 3: Circular path
        int[][] pairs3 = {{1, 2}, {2, 3}, {3, 1}};
        System.out.println("Valid arrangement: " + Arrays.deepToString(solution.validArrangement(pairs3)));
        // Expected output: [[1, 2], [2, 3], [3, 1]]

        // Test Case 4: Single pair
        int[][] pairs4 = {{7, 8}};
        System.out.println("Valid arrangement: " + Arrays.deepToString(solution.validArrangement(pairs4)));
        // Expected output: [[7, 8]]

        // Test Case 5: Complex path
        int[][] pairs5 = {{1, 3}, {3, 2}, {2, 4}, {4, 1}, {2, 3}};
        System.out.println("Valid arrangement: " + Arrays.deepToString(solution.validArrangement(pairs5)));
        // Expected output: A valid Eulerian path arrangement
    }
}

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build graph and in/out-degree maps
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        // Build graph and degree counts
        for (int[] pair : pairs) {
            int u = pair[0], v = pair[1];
            graph.computeIfAbsent(u, k -> new Stack<>()).push(v);
            outDegree.put(u, outDegree.getOrDefault(u, 0) + 1);
            inDegree.put(v, inDegree.getOrDefault(v, 0) + 1);
        }

        // Step 2: Identify the start node for the Eulerian path
        int start = pairs[0][0]; // Default start
        for (int key : graph.keySet()) {
            if (outDegree.getOrDefault(key, 0) - inDegree.getOrDefault(key, 0) == 1) {
                start = key; // Found the valid start
                break;
            }
        }

        // Step 3: Perform Hierholzer's algorithm to find Eulerian path
        List<int[]> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.peek();
            if (graph.containsKey(node) && !graph.get(node).isEmpty()) {
                stack.push(graph.get(node).pop());
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    result.add(new int[]{stack.peek(), node});
                }
            }
        }

        // Convert list to array and return
        Collections.reverse(result);
        return result.toArray(new int[result.size()][]);
    }
}
