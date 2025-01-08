// D_08_Count_Prefix_Suffix_Pairs.java
import java.util.*;

public class D_08_Count_Prefix_Suffix_Pairs {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String[] words = {"abc", "abcd", "bc", "ab", "ababc"};
        int result = solution.countPrefixSuffixPairs(words);
        System.out.println("Number of prefix-suffix pairs: " + result);
    }
}

// User function Template for Java
class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        
        // Iterate over all pairs (i, j) where i < j
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // Check if words[i] is both a prefix and a suffix of words[j]
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        
        return count;
    }

    // Helper function to check if str1 is both a prefix and suffix of str2
    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}
