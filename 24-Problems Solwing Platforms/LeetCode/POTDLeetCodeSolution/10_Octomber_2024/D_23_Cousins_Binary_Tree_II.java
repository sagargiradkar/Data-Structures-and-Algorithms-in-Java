import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.
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

public class D_23_Cousins_Binary_Tree_II {

    public static TreeNode replaceValueInTree(TreeNode root) {
        // Breadth-first search
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int prevSum = root.val;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int curSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                node.val = prevSum - node.val;
                int sibsum = 0;

                if (node.left != null) {
                    sibsum += node.left.val;
                }
                if (node.right != null) {
                    sibsum += node.right.val;
                }

                if (node.left != null) {
                    curSum += node.left.val;
                    node.left.val = sibsum;
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    curSum += node.right.val;
                    node.right.val = sibsum;
                    queue.offer(node.right);
                }
            }
            prevSum = curSum;
        }
        return root;
    }

    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(10,
                            new TreeNode(6, new TreeNode(4), new TreeNode(8)),
                            new TreeNode(14, new TreeNode(12), new TreeNode(16)));
        
        root = replaceValueInTree(root);

        // Output the modified tree
        printTree(root);
    }

    private static void printTree(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }
}
