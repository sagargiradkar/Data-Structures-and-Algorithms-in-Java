public class DiamondPattern {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a diamond pattern of height '2n' using '*'.
     * - The first 'n' rows form an increasing pyramid.
     * - The last 'n' rows form a mirrored decreasing pyramid.
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (to keep the pattern within reasonable limits).
     *
     * Approach:
     * - Each row consists of two parts:
     *   1. Leading spaces (n - i spaces)
     *   2. Stars (2*i - 1 stars)
     * - The second half mirrors the first half.
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(1) (only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void diamondPattern(int n) {
        // Upper Half (including middle row)
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // Lower Half (excluding middle row)
        for (int i = n - 1; i >= 1; i--) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using Single Loop)
     * ========================================
     * Instead of two separate loops, we use a single loop and compute row numbers accordingly.
     */
    public static void optimizedDiamondPattern(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int row = (i <= n) ? i : (2 * n - i); // Row number mapping
            int spaces = n - row; // Spaces in the row
            int stars = 2 * row - 1; // Stars in the row

            // Print leading spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Nested loops printing n rows of n elements)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same nested loop structure but avoids redundancy)
     * - Space Complexity: O(1) (Same as original)
     */

    public static void main(String[] args) {
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("Diamond Pattern (n = 5):");
        diamondPattern(5);
        
        System.out.println("\nOptimized Diamond Pattern (n = 5):");
        optimizedDiamondPattern(5);

        System.out.println("\nDiamond Pattern (n = 3):");
        diamondPattern(3);

        System.out.println("\nDiamond Pattern (n = 1):");
        diamondPattern(1);

        System.out.println("\nDiamond Pattern (n = 4):");
        diamondPattern(4);
    }
}
