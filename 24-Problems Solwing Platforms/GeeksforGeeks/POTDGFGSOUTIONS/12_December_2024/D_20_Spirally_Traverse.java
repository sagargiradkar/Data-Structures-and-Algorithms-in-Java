import java.util.ArrayList;

public class D_20_Spirally_Traverse {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example matrix
        int[][] mat1 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        int[][] mat2 = {
            {32, 44, 27, 23},
            {54, 28, 50, 62}
        };

        // Call the function and print the results
        System.out.println("Spiral Traversal: " + solution.spirallyTraverse(mat1));
        System.out.println("Spiral Traversal: " + solution.spirallyTraverse(mat2));
    }
}

class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        if (mat == null || mat.length == 0) return result;

        int top = 0, bottom = mat.length - 1, left = 0, right = mat[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse from right to left if still within bounds
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Traverse from bottom to top if still within bounds
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
