public class HollowRectangle {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given the number of rows and columns, print a hollow rectangle pattern using '*'.
     * - The first and last row should be filled with '*'.
     * - The first and last column should be filled with '*'.
     * - The remaining inner space should be left blank.
     *
     * Constraints:
     * 1 ≤ totRows, totCols ≤ 100 (to maintain efficiency)
     *
     * Approach:
     * - Iterate through rows (i) and columns (j).
     * - If we are at the first row (i == 1) or last row (i == totRows),
     *   OR at the first column (j == 1) or last column (j == totCols), print '*'.
     * - Otherwise, print a space.
     *
     * Time Complexity: O(totRows * totCols) (Each cell is processed once)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void hollowRectangle(int totRows, int totCols) {
        for (int i = 1; i <= totRows; i++) {
            for (int j = 1; j <= totCols; j++) {
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
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
    public static void optimizedHollowRectangle(int totRows, int totCols) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= totRows; i++) {
            for (int j = 1; j <= totCols; j++) {
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
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
     * - Time Complexity: O(totRows * totCols) (Each cell is processed once)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(totRows * totCols) (Same logic but efficient printing)
     * - Space Complexity: O(totRows * totCols) (StringBuilder stores the full output)
     * - The optimized method reduces I/O overhead by using a single print operation.
     */

    public static void main(String[] args) {
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("Hollow Rectangle (10 x 7):");
        hollowRectangle(10, 7);

        System.out.println("\nOptimized Hollow Rectangle (10 x 7):");
        optimizedHollowRectangle(10, 7);

        System.out.println("\nHollow Rectangle (5 x 5):");
        hollowRectangle(5, 5);

        System.out.println("\nHollow Rectangle (3 x 10):");
        hollowRectangle(3, 10);

        System.out.println("\nHollow Rectangle (8 x 2):");
        hollowRectangle(8, 2);
    }
}
