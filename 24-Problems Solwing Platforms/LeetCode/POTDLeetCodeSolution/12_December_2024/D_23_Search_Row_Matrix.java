
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class D_23_Search_Row_Matrix {
    public static void main(String[] args) {
        // Example tree
        TreeNode root = new TreeNode(1,
            new TreeNode(4, new TreeNode(7), new TreeNode(6)),
            new TreeNode(3, new TreeNode(8), new TreeNode(5))
        );

        // Create solution instance and calculate minimum operations
        Solution solution = new Solution();
        int result = solution.minimumOperations(root);
        System.out.println("Minimum operations to sort the tree by levels: " + result);

        // Example matrix and target value
        int[][] mat = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        // Call the function and display the result
        boolean found = solution.searchRowMatrix(mat, target);
        if (found) {
            System.out.println("Element found in the matrix.");
        } else {
            System.out.println("Element not found in the matrix.");
        }
    }
}

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (x < mat[i][0] || x > mat[i][m - 1]) continue;
            int low = 0, high = m - 1, mid;
            while (low <= high) {
                mid = (low + high) / 2;
                int temp = mat[i][mid];
                if (temp == x) return true;
                else if (temp < x) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }

    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int operations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            operations += countSwaps(level);
        }

        return operations;
    }

    private int countSwaps(List<Integer> level) {
        int n = level.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = level.get(i);

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) indexMap.put(arr[i], i);

        Arrays.sort(arr);
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexMap.get(arr[i]) == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(arr[j]);
                cycleSize++;
            }

            if (cycleSize > 1) swaps += (cycleSize - 1);
        }

        return swaps;
    }
}

// TreeNode class definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
