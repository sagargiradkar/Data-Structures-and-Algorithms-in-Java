public class D_03_MinDilIn {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String str1_1 = "heap";
        String str2_1 = "pea";
        System.out.println("Result for str1 = \"" + str1_1 + "\", str2 = \"" + str2_1 + "\": " + solution.minOperations(str1_1, str2_1));
        // Expected Output: 3 (2 deletions and 1 insertion)

        // Test case 2
        String str1_2 = "geeksforgeeks";
        String str2_2 = "geeks";
        System.out.println("Result for str1 = \"" + str1_2 + "\", str2 = \"" + str2_2 + "\": " + solution.minOperations(str1_2, str2_2));
        // Expected Output: 8 (8 deletions)

        // Test case 3
        String str1_3 = "abc";
        String str2_3 = "def";
        System.out.println("Result for str1 = \"" + str1_3 + "\", str2 = \"" + str2_3 + "\": " + solution.minOperations(str1_3, str2_3));
        // Expected Output: 6 (3 deletions and 3 insertions)

        // Additional Test case
        String str1_4 = "abcdef";
        String str2_4 = "ace";
        System.out.println("Result for str1 = \"" + str1_4 + "\", str2 = \"" + str2_4 + "\": " + solution.minOperations(str1_4, str2_4));
        // Expected Output: 6 (4 deletions and 2 insertions)
    }

    static class Solution {
        public int minOperations(String str1, String str2) {
            int m = str1.length();
            int n = str2.length();
            
            // Create a 2D array to store lengths of longest common subsequence.
            int[][] dp = new int[m + 1][n + 1];
            
            // Fill the dp array
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            
            // Length of Longest Common Subsequence
            int lcsLength = dp[m][n];
            
            // Minimum number of deletions and insertions
            int deletions = m - lcsLength;
            int insertions = n - lcsLength;
            
            return deletions + insertions;
        }
    }
}
