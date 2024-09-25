import java.util.*;

public class D_25_Sum_Prefix_Score {

    public static void main(String[] args) {
        // Sample input for testing
        String[] words = {"abc", "ab", "bc", "b"};
        
        // Create an instance of the Solution class and call sumPrefixScores
        Solution solution = new Solution();
        int[] result = solution.sumPrefixScores(words);
        
        // Print the result
        System.out.println("Prefix Scores: " + Arrays.toString(result));
    }
}

class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        
        // Step 1: Insert all words into the trie
        for(String word : words) {
            trie.addWord(word);
        }
        
        // Step 2: Calculate prefix score for each word
        int[] result = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            result[i] = trie.findPrefixCount(words[i]);
        }
        
        return result;
    }
}

class Node {
    Node[] child;
    int count;
    
    Node() {
        child = new Node[26]; // for 'a' to 'z'
        count = 0;
    }
}

class Trie {
    Node root;
    
    Trie() {
        root = new Node();
    }
    
    // Adds a word to the trie
    public void addWord(String word) {
        Node temp = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(temp.child[index] == null) {
                temp.child[index] = new Node();
            }
            temp.child[index].count++;
            temp = temp.child[index];
        }
    }
    
    // Finds the prefix count for a word
    public int findPrefixCount(String word) {
        Node temp = root;
        int count = 0;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            count += temp.child[index].count;
            temp = temp.child[index];
        }
        return count;
    }
}
