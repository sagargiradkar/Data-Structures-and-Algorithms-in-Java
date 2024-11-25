import java.util.*;

public class D_25_Sliding_Puzzle {
    public static void main(String[] args) {
        // Example input
        int[][] board = {
            {1, 2, 3},
            {4, 0, 5}
        };

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calling the slidingPuzzle function
        int result = solution.slidingPuzzle(board);

        // Printing the result
        System.out.println("Minimum number of moves to solve the puzzle: " + result);
    }
}

class Solution {
    public int slidingPuzzle(int[][] board) {
        // Target state as a string
        String target = "123450";
        // Convert the board to a string
        StringBuilder start = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        // If the board is already solved
        if (start.toString().equals(target)) return 0;

        // Predefined neighbors for each position in the 2x3 grid
        int[][] neighbors = {
            {1, 3},      // 0 can move to 1 or 3
            {0, 2, 4},   // 1 can move to 0, 2, or 4
            {1, 5},      // 2 can move to 1 or 5
            {0, 4},      // 3 can move to 0 or 4
            {1, 3, 5},   // 4 can move to 1, 3, or 5
            {2, 4}       // 5 can move to 2 or 4
        };

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int steps = 0;

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // If the target is reached, return the steps
                if (current.equals(target)) return steps;

                // Find the index of '0' (empty space)
                int zeroIndex = current.indexOf('0');
                // Generate new states by moving '0' to its neighbors
                for (int neighbor : neighbors[zeroIndex]) {
                    String nextState = swap(current, zeroIndex, neighbor);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.offer(nextState);
                    }
                }
            }
            steps++;
        }

        // If no solution is found
        return -1;
    }

    // Helper function to swap characters in a string
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
