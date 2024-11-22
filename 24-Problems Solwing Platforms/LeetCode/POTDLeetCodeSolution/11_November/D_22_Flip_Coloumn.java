import java.util.*;

public class D_22_Flip_Coloumn {

    static class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            Map<String, Integer> rowPatterns = new HashMap<>(); // To store row patterns and their frequencies

            for (int[] row : matrix) { // Loop over each row
                StringBuilder rowPattern = new StringBuilder();
                int firstVal = row[0];

                // Generate the pattern for the current row
                for (int col = 0; col < n; col++) {
                    rowPattern.append(row[col] == firstVal ? "S" : "B");
                }

                // Increment the frequency of the row pattern
                rowPatterns.put(rowPattern.toString(), rowPatterns.getOrDefault(rowPattern.toString(), 0) + 1);
            }

            int maxRows = 0;

            // Find the maximum frequency of any row pattern
            for (int count : rowPatterns.values()) {
                maxRows = Math.max(maxRows, count);
            }

            return maxRows;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int m = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int n = scanner.nextInt();

        int[][] matrix = new int[m][n];
        System.out.println("Enter the matrix elements (0 or 1):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Solution();
        int result = solution.maxEqualRowsAfterFlips(matrix);

        System.out.println("Maximum equal rows after flips: " + result);

        scanner.close();
    }
}