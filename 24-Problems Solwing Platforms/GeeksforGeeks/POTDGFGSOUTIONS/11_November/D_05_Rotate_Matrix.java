import java.util.Arrays;

public class D_05_Rotate_Matrix {
    static void rotate(int mat[][]) {
        int n = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }

        rotate(mat);

        System.out.println("\nRotated Matrix by 90 degrees clockwise:");
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
    }
}