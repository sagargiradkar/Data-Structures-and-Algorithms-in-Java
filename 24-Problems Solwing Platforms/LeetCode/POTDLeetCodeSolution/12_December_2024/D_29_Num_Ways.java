import java.util.*;

public class D_29_Num_Ways {
    static class Solution {
        public int numWays(String[] words, String target) {
            int mod = 1_000_000_007;
            int m = target.length();
            int n = words[0].length();

            // Count the frequency of each character in each column
            int[][] freq = new int[26][n];
            for (String word : words) {
                for (int j = 0; j < n; j++) {
                    freq[word.charAt(j) - 'a'][j]++;
                }
            }

            // DP array: dp[i][j] = number of ways to form the first i characters of target using the first j columns of words
            long[][] dp = new long[m + 1][n + 1];

            // Base case: dp[0][j] = 1 (1 way to form an empty target from any prefix of columns)
            for (int j = 0; j <= n; j++) {
                dp[0][j] = 1;
            }

            // Fill the DP table
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // Case 1: Skip the current column
                    dp[i][j] = dp[i][j - 1];

                    // Case 2: Use the current column (if the character matches)
                    char targetChar = target.charAt(i - 1);
                    if (freq[targetChar - 'a'][j - 1] > 0) {
                        dp[i][j] += dp[i - 1][j - 1] * freq[targetChar - 'a'][j - 1];
                        dp[i][j] %= mod;
                    }
                }
            }

            return (int) dp[m][n];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for words array
        System.out.println("Enter the number of words:");
        int numWords = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] words = new String[numWords];
        System.out.println("Enter the words:");
        for (int i = 0; i < numWords; i++) {
            words[i] = scanner.nextLine();
        }

        // Input for target string
        System.out.println("Enter the target string:");
        String target = scanner.nextLine();

        // Solution instance
        Solution solution = new Solution();
        int result = solution.numWays(words, target);

        // Output result
        System.out.println("Number of ways to form the target string: " + result);

        scanner.close();
    }
}
