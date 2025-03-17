public class InvertedPyramidNumbers {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print an inverted pyramid pattern of numbers.
     * - The first row contains numbers from 1 to n.
     * - Each subsequent row decreases by one number.
     * - The last row contains only '1'.
     *
     * Example for n = 5:
     * 1 2 3 4 5
     * 1 2 3 4
     * 1 2 3
     * 1 2
     * 1
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (to maintain efficiency)
     *
     * Approach:
     * - Iterate through rows (i) from 0 to n.
     * - Print numbers from 1 to (n - i).
     * - Move to the next line after each row.
     *
     * Time Complexity: O(n²) (Each cell is printed once)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void invertedPyramidNumber(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                System.out.print(" " + j);
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
    public static void optimizedInvertedPyramidNumber(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                sb.append(" ").append(j);
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
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("Inverted Pyramid (n = 10):");
        invertedPyramidNumber(10);

        System.out.println("\nOptimized Inverted Pyramid (n = 10):");
        optimizedInvertedPyramidNumber(10);

        System.out.println("\nInverted Pyramid (n = 5):");
        invertedPyramidNumber(5);

        System.out.println("\nInverted Pyramid (n = 7):");
        invertedPyramidNumber(7);

        System.out.println("\nInverted Pyramid (n = 3):");
        invertedPyramidNumber(3);
    }
}
