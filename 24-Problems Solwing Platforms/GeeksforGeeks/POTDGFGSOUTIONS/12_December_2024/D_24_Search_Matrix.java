import java.util.Scanner;

public class D_24_Search_Matrix {
    static class Solution {
        // Function to search a given number in row-column sorted matrix.
        public boolean searchMatrix(int[][] mat, int x) {
            int n = mat.length;      // Number of rows
            int m = mat[0].length;   // Number of columns
            
            int left = 0, right = n * m - 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midValue = mat[mid / m][mid % m]; // Map 1D index to 2D matrix
                
                if (midValue == x) {
                    return true; // Found the element
                } else if (midValue < x) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
            
            return false; // Element not found
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example matrix input
        System.out.println("Enter the number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int m = scanner.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the number to search:");
        int x = scanner.nextInt();

        Solution solution = new Solution();
        boolean result = solution.searchMatrix(mat, x);

        System.out.println("Element found: " + result);
        scanner.close();
    }
}
