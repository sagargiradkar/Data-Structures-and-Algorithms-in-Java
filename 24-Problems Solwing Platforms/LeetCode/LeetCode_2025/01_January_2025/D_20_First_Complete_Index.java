public class D_20_First_Complete_Index {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[][] mat = {
            {1, 4},
            {2, 3}
        };

        Solution solution = new Solution();
        int result = solution.firstCompleteIndex(arr, mat);
        System.out.println("First complete index: " + result);
    }
}

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;    // Number of rows
        int n = mat[0].length; // Number of columns

        // Map each number to its (row, column) in mat
        int[][] position = new int[m * n + 1][]; // Use an array of int[]

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                position[mat[i][j]] = new int[]{i, j}; // Store (row, column) as an int[] array
            }
        }

        // Arrays to track how many cells are painted in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Process each number in arr
        for (int i = 0; i < arr.length; i++) {
            int[] pos = position[arr[i]];
            int row = pos[0];
            int col = pos[1];

            // Paint the cell
            rowCount[row]++;
            colCount[col]++;

            // Check if the row or column is fully painted
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        // No row or column is completely painted
        return -1;
    }
}
