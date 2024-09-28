public class D_07_LinkedList_inBinaryTree {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Definition for a binary tree node.
    public static class TreeNode {
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

    static class Solution {
        public boolean dfs(ListNode head, TreeNode node) {
            if (head == null) return true;
            if (node == null) return false;
            if (head.val != node.val) return false;
            return dfs(head.next, node.left) || dfs(head.next, node.right);
        }

        public boolean isSubPath(ListNode head, TreeNode root) {
            if (root == null) {
                return false;
            }
            if (root.val == head.val) {
                if (dfs(head, root)) {
                    return true;
                }
            }
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }

    // Main method for testing the solution
    public static void main(String[] args) {
        // Creating the Linked List: 4 -> 2 -> 8
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        // Creating the Binary Tree:
        //       1
        //      / \
        //     4   4
        //    /   / \
        //   2   2   6
        //  /   /
        // 8   8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(8);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(8);
        root.right.right = new TreeNode(6);

        // Testing the isSubPath function
        Solution solution = new Solution();
        boolean result = solution.isSubPath(head, root);

        System.out.println("Is the linked list a subpath in the binary tree? " + result);
    }
}
