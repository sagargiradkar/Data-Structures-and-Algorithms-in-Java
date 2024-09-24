import java.util.*;

public class D_24_Longest_Comm_prefix {

    public static void main(String[] args) {
        // Sample arrays
        int[] arr1 = {123, 456, 789, 101};
        int[] arr2 = {123, 456, 102, 789};

        Solution solution = new Solution();
        int longestPrefixLength = solution.longestCommonPrefix(arr1, arr2);

        System.out.println("Longest Common Prefix Length: " + longestPrefixLength);
    }
}

class Node {
    Node[] child;
    
    Node() {
        child = new Node[10]; // 0 to 9 digits
    }
}

class Trie {
    Node root;
    
    Trie() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) { // Convert number string to trie path
            int index = ch - '0'; // Convert char to int (e.g., '1' becomes 1)
            // If child does not exist, create new node
            if (temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            // Move to the next node
            temp = temp.child[index];
        }
    }
    
    // Find the length of the common prefix
    public int findPrefix(String word) {
        Node temp = root;
        int len = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - '0';
            // If child is not present, no prefix exists
            if (temp.child[index] == null) {
                break;
            }
            // Move to the next node
            temp = temp.child[index];
            len++;
        }
        return len;
    }
}

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int maxLen = Integer.MIN_VALUE;
        
        // Insert elements from arr1 into the trie
        for (int arr : arr1) {
            trie.addWord(Integer.toString(arr));
        }
        
        // Check the prefix length for elements in arr2
        for (int arr : arr2) {
            int len = trie.findPrefix(Integer.toString(arr));
            maxLen = Math.max(maxLen, len);
        }
        
        return maxLen;
    }
}
