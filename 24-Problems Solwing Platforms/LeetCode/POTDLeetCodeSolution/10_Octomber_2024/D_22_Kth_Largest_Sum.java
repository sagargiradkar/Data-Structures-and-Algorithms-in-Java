import java.util.*;

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

public class D_22_Kth_Largest_Sum {

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> levelSums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;
                
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            levelSums.add(sum);
        }
        
        if (levelSums.size() < k) {
            return -1;
        }
        
        Collections.sort(levelSums, Collections.reverseOrder());
        return levelSums.get(k - 1);
    }

    public static void main(String[] args) {
        D_22_Kth_Largest_Sum solution = new D_22_Kth_Largest_Sum();
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);
        
        int k = 2;
        long result = solution.kthLargestLevelSum(root, k);
        System.out.println("Kth largest level sum: " + result);
    }
}