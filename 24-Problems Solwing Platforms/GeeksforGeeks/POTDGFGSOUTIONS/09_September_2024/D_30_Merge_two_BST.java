import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    // Function to perform in-order traversal of the BST
    private void inOrderTraversal(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, result);
        result.add(root.data);
        inOrderTraversal(root.right, result);
    }

    // Function to merge two sorted lists
    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Merge the two lists
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements from list1
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Add remaining elements from list2
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Get in-order traversal of both BSTs
        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);

        // Merge the two sorted lists
        return mergeSortedLists(list1, list2);
    }
}

public class D_30_Merge_two_BST {
    public static void main(String[] args) {
        // Create first BST
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);

        // Create second BST
        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);
        root2.right.right = new Node(7);
        root2.right.right.left = new Node(6);

        // Create Solution object
        Solution solution = new Solution();
        // Merge both BSTs
        List<Integer> mergedList = solution.merge(root1, root2);

        // Print the merged sorted list
        for (int num : mergedList) {
            System.out.print(num + " ");
        }
    }
}
