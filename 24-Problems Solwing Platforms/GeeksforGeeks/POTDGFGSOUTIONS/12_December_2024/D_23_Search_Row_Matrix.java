public class D_23_Search_Row_Matrix {
    public static void main(String[] args) {
        // Example matrix and target value
        int[][] mat = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;

        // Call the function and display the result
        Solution solution = new Solution();
        boolean result = solution.searchRowMatrix(mat, target);
        if (result) {
            System.out.println("Element found in the matrix.");
        } else {
            System.out.println("Element not found in the matrix.");
        }
    }
}

class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            if (x < mat[i][0] || x > mat[i][m - 1]) continue;
            int low = 0, high = m - 1, mid;
            while (low <= high) {
                mid = (low + high) / 2;
                int temp = mat[i][mid];
                if (temp == x) return true;
                else if (temp < x) low = mid + 1;
                else high = mid - 1;
            }
        }
        return false;
    }
}
