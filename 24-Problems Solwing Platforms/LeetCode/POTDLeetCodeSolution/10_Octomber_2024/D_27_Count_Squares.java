public class D_27_Count_Squares {

    static class Solution {
        public int countSquares(int[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;

            int[][] dp = new int[m][n];
            int result = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        if (matrix[i][j] == 1) {
                            dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                        }
                    }
                    result += dp[i][j];
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] matrix1 = {
            {1, 0, 1},
            {1, 1, 0},
            {1, 1, 0}
        };
        
        int[][] matrix2 = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {0, 1, 1, 1}
        };

        System.out.println("Test Case 1: " + solution.countSquares(matrix1));  // Expected: 5
        System.out.println("Test Case 2: " + solution.countSquares(matrix2));  // Expected: 15
    }
}