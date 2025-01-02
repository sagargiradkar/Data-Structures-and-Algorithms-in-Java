// D_02_Vowel_Strings.java
import java.util.HashSet;
import java.util.Set;

public class D_02_Vowel_Strings {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String[] words = {"apple", "orange", "idea", "eagle"};
        int[][] queries = {{0, 2}, {1, 3}, {0, 3}};
        int[] results = solution.vowelStrings(words, queries);

        // Print results
        System.out.println("Results of queries:");
        for (int result : results) {
            System.out.println(result);
        }
    }
}

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        // Precompute a prefix sum array to store the cumulative count of vowel strings
        int n = words.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (isVowelString(word, vowels)) {
                prefixSum[i + 1] = prefixSum[i] + 1;
            } else {
                prefixSum[i + 1] = prefixSum[i];
            }
        }

        // Process each query using the prefix sum array
        int m = queries.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefixSum[right + 1] - prefixSum[left];
        }

        return result;
    }

    private boolean isVowelString(String word, Set<Character> vowels) {
        if (word.isEmpty()) return false;
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return vowels.contains(first) && vowels.contains(last);
    }
}
