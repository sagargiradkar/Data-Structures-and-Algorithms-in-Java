public class InvertedRotatedHalfP {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print an inverted, rotated half-pyramid pattern of stars.
     * - The pattern should be right-aligned.
     * - The first row contains 1 star, the second row contains 2 stars, and so on.
     * - The last row contains 'n' stars.
     *
     * Example for n = 5:
     *         * 
     *       * * 
     *     * * * 
     *   * * * * 
     * * * * * * 
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (to ensure efficiency)
     *
     * Approach:
     * - Iterate through rows from 0 to n.
     * - First, print spaces (n - i) times to align the stars to the right.
     * - Then, print '*' i times for the current row.
     * - Move to the next line after printing all characters in a row.
     *
     * Time Complexity: O(n²) (Each cell is processed once)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void Inverted_Pyramid(int n) {
        // Outer loop for rows
        for (int i = 0; i <= n; i++) {
            // Spaces for right alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Stars for the pyramid
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
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
    public static void optimizedInvertedPyramid(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            // Append spaces
            sb.append("  ".repeat(n - i));
            // Append stars
            sb.append("* ".repeat(i)).append("\n");
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
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("Inverted Rotated Half Pyramid (n = 5):");
        Inverted_Pyramid(5);

        System.out.println("\nOptimized Inverted Rotated Half Pyramid (n = 5):");
        optimizedInvertedPyramid(5);

        System.out.println("\nInverted Rotated Half Pyramid (n = 7):");
        Inverted_Pyramid(7);

        System.out.println("\nInverted Rotated Half Pyramid (n = 3):");
        Inverted_Pyramid(3);

        System.out.println("\nInverted Rotated Half Pyramid (n = 10):");
        Inverted_Pyramid(10);
    }
}
