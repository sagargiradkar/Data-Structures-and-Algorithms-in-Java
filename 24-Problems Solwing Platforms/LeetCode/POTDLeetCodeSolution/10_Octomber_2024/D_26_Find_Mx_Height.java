import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

class Solution {
    private int[] level = new int[1000001]; // Level of each node
    private int[] height = new int[100001]; // Height of each node
    private int[] levelMaxHt = new int[100001];
    private int[] levelSecondMaxHt = new int[100001];

    // Method to find the height of each node and populate the max heights at each level
    private int findHeight(TreeNode root, int l) {
        if (root == null) {
            return 0;
        }

        level[root.val] = l;
        height[root.val] = Math.max(findHeight(root.left, l + 1), findHeight(root.right, l + 1)) + 1;

        if (levelMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = levelMaxHt[l];
            levelMaxHt[l] = height[root.val];
        } else if (levelSecondMaxHt[l] < height[root.val]) {
            levelSecondMaxHt[l] = height[root.val];
        }

        return height[root.val];
    }

    // Main method to process queries
    public int[] treeQueries(TreeNode root, int[] queries) {
        findHeight(root, 0);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int L = level[node]; // Node's level

            // Calculate result for this node
            int tempResult = L + (levelMaxHt[L] == height[node] ? levelSecondMaxHt[L] : levelMaxHt[L]) - 1;
            result[i] = tempResult;
        }

        return result;
    }
}

public class D_26_Find_Mx_Height {
    public static void main(String[] args) {
        // Create the tree for demonstration
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Queries to find max height when a node is removed
        int[] queries = {1, 2, 3, 4, 5};

        Solution solution = new Solution();
        int[] results = solution.treeQueries(root, queries);

        // Output results
        System.out.println("Max heights after removing each queried node:");
        for (int i = 0; i < queries.length; i++) {
            System.out.println("Node " + queries[i] + ": " + results[i]);
        }
    }
}