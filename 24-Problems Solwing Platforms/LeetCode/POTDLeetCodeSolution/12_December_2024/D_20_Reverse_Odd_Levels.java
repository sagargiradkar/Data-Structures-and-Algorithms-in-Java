class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class D_20_Reverse_Odd_Levels {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);

        // Reverse odd levels
        solution.reverseOddLevels(root);

        // Print the tree in a level order to verify results
        printTreeLevelOrder(root);
    }

    // Utility method to print the tree in level order
    private static void printTreeLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}

class Solution {
    private void solve(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }

        // Reverse values at odd levels
        if (level % 2 == 1) {
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }

        solve(left.left, right.right, level + 1);
        solve(left.right, right.left, level + 1);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        solve(root.left, root.right, 1); // root is at level 0, left and right children at level 1
        return root;
    }
}
