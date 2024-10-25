// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {}
    
    TreeNode(int val) {
        this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // base cases
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        
        // check if both subtrees are flip equivalent
        // either no flip or with flip
        boolean isSame = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        if (isSame) {
            return true;
        }
        
        // check flip case
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }
}

public class D_24_Flip_Equivalent_Binary_Trees {
    public static void main(String[] args) {
        // Create two sample trees
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode root2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        
        // Create a solution instance
        Solution solution = new Solution();
        
        // Check if the two trees are flip equivalent
        boolean result = solution.flipEquiv(root1, root2);
        
        // Print the result
        System.out.println("Are the trees flip equivalent? " + result);
    }
}