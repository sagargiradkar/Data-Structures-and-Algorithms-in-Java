public class D_22_Mat_Search {
    public static void main(String[] args) {
        // Example matrix and target value
        int[][] mat = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int target = 29;

        // Call the function and display the result
        boolean result = Solution.matSearch(mat, target);
        if (result) {
            System.out.println("Element found in the matrix.");
        } else {
            System.out.println("Element not found in the matrix.");
        }
    }
}

class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length;    // Number of rows
        int m = mat[0].length; // Number of columns

        int i = 0;       // Start from the first row
        int j = m - 1;   // Start from the last column

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true; // Element found
            } else if (mat[i][j] > x) {
                j--; // Move left
            } else {
                i++; // Move down
            }
        }
        return false; // Element not found
    }
}
