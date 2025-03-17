import java.util.Scanner;

public class NumericHalfPyramid {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a numeric half-pyramid pattern with numbers.
     * - The first row contains '1'.
     * - Each subsequent row contains numbers from 1 to row number.
     * - Numbers should be printed at the start, end, and last row, with spaces in between.
     *
     * Example for n = 5:
     * 1
     * 12
     * 1 3
     * 1  4
     * 12345
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (Ensuring efficiency)
     *
     * Approach:
     * - Use nested loops:
     *   - Outer loop iterates over rows (0 to n-1).
     *   - Inner loop prints numbers:
     *     - Print number at the start (col == 0), end (col == row), and last row.
     *     - Otherwise, print space.
     * - Move to the next line after printing all numbers in a row.
     *
     * Time Complexity: O(n²) (Each cell is processed once)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void printNumericHalfPyramid(int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row || row == n - 1) {
                    System.out.print(col + 1);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using StringBuilder for Efficient Output)
     * ========================================
     * - Uses StringBuilder to reduce multiple System.out.print() calls.
     * - Reduces I/O overhead and improves efficiency.
     */
    public static void optimizedNumericHalfPyramid(int n) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row || row == n - 1) {
                    sb.append(col + 1);
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString()); // Print everything at once
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each row processes up to 'n' elements)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same logic but optimized printing)
     * - Space Complexity: O(n²) (StringBuilder stores the full output before printing)
     * - The optimized method reduces I/O overhead by printing in one go.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        sc.close();

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nNumeric Half Pyramid (n = " + n + "):");
        printNumericHalfPyramid(n);

        System.out.println("\nOptimized Numeric Half Pyramid (n = " + n + "):");
        optimizedNumericHalfPyramid(n);

        // Additional test cases
        System.out.println("\nNumeric Half Pyramid (n = 3):");
        printNumericHalfPyramid(3);

        System.out.println("\nNumeric Half Pyramid (n = 6):");
        printNumericHalfPyramid(6);

        System.out.println("\nNumeric Half Pyramid (n = 8):");
        printNumericHalfPyramid(8);
    }
}
