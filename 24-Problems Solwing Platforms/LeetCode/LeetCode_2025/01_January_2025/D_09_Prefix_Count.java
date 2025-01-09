// D_09_Prefix_Count.java
public class D_09_Prefix_Count {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String[] words = {"apple", "app", "application", "banana", "apply"};
        String prefix = "app";
        int result = solution.prefixCount(words, prefix);
        System.out.println("Number of words with prefix '" + prefix + "': " + result);
    }
}

// User function Template for Java
class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0; // Counter for words with the prefix

        for (String word : words) {
            // Check if the word starts with the given prefix
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count; // Return the total count
    }
}
