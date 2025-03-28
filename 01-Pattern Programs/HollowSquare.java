import java.util.Scanner;

public class HollowSquare {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a hollow square pattern using '*'.
     * - The first and last rows should be filled with '*'.
     * - The first and last columns should be filled with '*'.
     * - The inner part should be empty (printed as spaces).
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (to maintain efficiency)
     *
     * Approach:
     * - Iterate through rows (i) and columns (j).
     * - If we are at the first row (i == 0) or last row (i == n - 1),
     *   OR at the first column (j == 0) or last column (j == n - 1), print '*'.
     * - Otherwise, print a space.
     *
     * Time Complexity: O(n²) (Each cell is processed once)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void hollowSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using StringBuilder)
     * ========================================
     * - Uses StringBuilder to reduce excessive System.out.print() calls.
     * - Improves efficiency by minimizing I/O operations.
     */
    public static void optimizedHollowSquare(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    sb.append("* ");
                } else {
                    sb.append("  ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString()); // Print all at once
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each cell is processed once)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same logic but efficient printing)
     * - Space Complexity: O(n²) (StringBuilder stores the full output)
     * - The optimized method reduces I/O overhead by using a single print operation.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the hollow square (n): ");
        int n = sc.nextInt();
        sc.close();

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nHollow Square (n = " + n + "):");
        hollowSquare(n);

        System.out.println("\nOptimized Hollow Square (n = " + n + "):");
        optimizedHollowSquare(n);

        System.out.println("\nHollow Square (n = 5):");
        hollowSquare(5);

        System.out.println("\nHollow Square (n = 7):");
        hollowSquare(7);

        System.out.println("\nHollow Square (n = 3):");
        hollowSquare(3);
    }
}
