import java.util.Arrays;

public class D_21_Rotate_Matrix_90_AntiClockwise {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(mat);

        // Rotate the matrix
        solution.rotateby90(mat);

        System.out.println("Rotated Matrix:");
        printMatrix(mat);
    }

    // Utility function to print the matrix
    private static void printMatrix(int[][] mat) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    static void rotateby90(int[][] mat) {
        int n = mat.length;

        // Step 1: Transpose the matrix (swap mat[i][j] with mat[j][i])
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }
}
