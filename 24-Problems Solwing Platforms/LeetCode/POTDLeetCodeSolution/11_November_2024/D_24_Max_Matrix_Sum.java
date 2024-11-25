public class D_24_Max_Matrix_Sum {
    public static void main(String[] args) {
        // Example input
        int[][] matrix = {
            {1, -1, 3},
            {-1, 5, -6},
            {7, 8, -9}
        };

        // Creating an instance of Solution
        Solution solution = new Solution();

        // Calling the maxMatrixSum function
        long result = solution.maxMatrixSum(matrix);

        // Printing the result
        System.out.println("Maximum Matrix Sum: " + result);
    }
}

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        long sum = 0;
        int countNegatives = 0;
        int smallestAbsoluteValue = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);

                if (matrix[i][j] < 0) {
                    countNegatives++;
                }

                smallestAbsoluteValue = Math.min(smallestAbsoluteValue, Math.abs(matrix[i][j]));
            }
        }

        if (countNegatives % 2 == 0) {
            return sum;
        }

        return sum - 2L * smallestAbsoluteValue;
    }
}