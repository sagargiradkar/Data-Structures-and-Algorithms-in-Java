public class ButterflyPattern {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a butterfly pattern of height '2n' using '*'.
     * The pattern consists of two symmetrical halves:
     * - The first 'n' rows increase in width.
     * - The last 'n' rows mirror the first 'n' rows in reverse order.
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (to keep the pattern within reasonable limits).
     *
     * Approach:
     * - Each row consists of three parts:
     *   1. Left stars (i stars for row 'i')
     *   2. Middle spaces (2*(n-i) spaces)
     *   3. Right stars (i stars for row 'i')
     * - The second half is a mirror of the first half.
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(1) (only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void butterflyPatterns(int n) {
        // Upper Half of the Butterfly Pattern
        for (int i = 1; i <= n; i++) {
            // Print left side stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Print middle spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }

            // Print right side stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // Lower Half of the Butterfly Pattern (Mirrored)
        for (int i = n; i >= 1; i--) {
            // Print left side stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            // Print middle spaces
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }

            // Print right side stars
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using Single Loop)
     * ========================================
     * Instead of writing two loops for upper and lower halves separately,
     * we use a single loop and compute row numbers accordingly.
     */
    public static void optimizedButterflyPatterns(int n) {
        for (int i = 1; i <= 2 * n; i++) {
            int stars = (i <= n) ? i : (2 * n - i); // Star count for current row
            int spaces = 2 * (n - stars); // Space count for current row

            // Print left side stars
            for (int j = 1; j <= stars; j++) {
                System.out.print("* ");
            }

            // Print middle spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            // Print right side stars
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
     * - Time Complexity: O(n²) (Still has nested loops, but reduces redundancy)
     * - Space Complexity: O(1) (Same as original)
     */

    public static void main(String[] args) {
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("Butterfly Pattern (n = 5):");
        butterflyPatterns(5);
        
        System.out.println("\nOptimized Butterfly Pattern (n = 5):");
        optimizedButterflyPatterns(5);

        System.out.println("\nButterfly Pattern (n = 3):");
        butterflyPatterns(3);

        System.out.println("\nButterfly Pattern (n = 1):");
        butterflyPatterns(1);

        System.out.println("\nButterfly Pattern (n = 4):");
        butterflyPatterns(4);
    }
}
