import java.util.Scanner;

public class D_25_Set_Matrix_Zeroes {
    static class Solution {
        public void setMatrixZeroes(int[][] mat) {
            int n = mat.length; // Number of rows
            int m = mat[0].length; // Number of columns

            // Use the first row and the first column as markers
            boolean firstRowHasZero = false;
            boolean firstColHasZero = false;

            // Check if the first row has any zero
            for (int j = 0; j < m; j++) {
                if (mat[0][j] == 0) {
                    firstRowHasZero = true;
                    break;
                }
            }

            // Check if the first column has any zero
            for (int i = 0; i < n; i++) {
                if (mat[i][0] == 0) {
                    firstColHasZero = true;
                    break;
                }
            }

            // Use the first row and column to mark rows and columns that need to be zeroed
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (mat[i][j] == 0) {
                        mat[i][0] = 0; // Mark the first column of this row
                        mat[0][j] = 0; // Mark the first row of this column
                    }
                }
            }

            // Zero out marked rows and columns (excluding the first row and column)
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (mat[i][0] == 0 || mat[0][j] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }

            // Handle the first row if it had any zero
            if (firstRowHasZero) {
                for (int j = 0; j < m; j++) {
                    mat[0][j] = 0;
                }
            }

            // Handle the first column if it had any zero
            if (firstColHasZero) {
                for (int i = 0; i < n; i++) {
                    mat[i][0] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.println("Enter the number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int m = scanner.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        Solution solution = new Solution();
        solution.setMatrixZeroes(mat);

        System.out.println("Matrix after setting zeroes:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
