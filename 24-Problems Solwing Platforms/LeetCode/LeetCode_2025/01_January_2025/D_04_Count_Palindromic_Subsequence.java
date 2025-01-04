// D_04_Count_Palindromic_Subsequence.java
import java.util.HashSet;
import java.util.Set;

public class D_04_Count_Palindromic_Subsequence {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String s = "aabca";
        int result = solution.countPalindromicSubsequence(s);
        System.out.println("Number of unique palindromic subsequences: " + result);
    }
}

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int result = 0;
        Set<String> uniquePalindromes = new HashSet<>();

        // Iterate through each character as the middle character
        for (char middle = 'a'; middle <= 'z'; middle++) {
            int firstIndex = -1, lastIndex = -1;

            // Find the first and last occurrence of the current character
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == middle) {
                    if (firstIndex == -1) firstIndex = i;
                    lastIndex = i;
                }
            }

            // If there's a valid gap, count unique characters in between
            if (firstIndex != -1 && lastIndex != -1 && lastIndex - firstIndex > 1) {
                boolean[] seen = new boolean[26]; // Check characters in between
                for (int i = firstIndex + 1; i < lastIndex; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                // Add all unique middle characters for the current outer pair
                for (int i = 0; i < 26; i++) {
                    if (seen[i]) {
                        uniquePalindromes.add("" + middle + (char) (i + 'a') + middle);
                    }
                }
            }
        }

        return uniquePalindromes.size();
    }
}
