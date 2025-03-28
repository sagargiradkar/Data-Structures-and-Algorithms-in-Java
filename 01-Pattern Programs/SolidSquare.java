public class SolidSquare {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a **solid square pattern** of size 'n x n'.
     *
     * Example for n = 5:
     * * * * * *
     * * * * * *
     * * * * * *
     * * * * * *
     * * * * * *
     *
     * Approach:
     * - Use two nested loops:
     *   - Outer loop runs 'n' times for rows.
     *   - Inner loop runs 'n' times for columns, printing '* '.
     * - The pattern is simple and symmetric.
     *
     * Time Complexity: O(n²) (Each row has 'n' operations)
     * Space Complexity: O(1) (No extra data structures used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void solidSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) { // Fixed: It should be 'j < n' to print n stars
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using StringBuilder for Efficiency)
     * ========================================
     * - Uses **StringBuilder** to reduce print calls and improve performance.
     * - Avoids multiple `System.out.print()` calls in the inner loop.
     */
    public static void optimizedSolidSquare(int n) {
        StringBuilder row = new StringBuilder();
        for (int j = 0; j < n; j++) {
            row.append("* ");
        }
        for (int i = 0; i < n; i++) {
            System.out.println(row);
        }
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each row processes n elements)
     * - Space Complexity: O(1) (Only loop variables used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same logic, but reduces print overhead)
     * - Space Complexity: O(n) (Uses a StringBuilder for row storage)
     */

    public static void main(String[] args) {
        System.out.println("Solid Square (Original Method)");
        solidSquare(5);

        System.out.println("\nSolid Square (Optimized Method)");
        optimizedSolidSquare(5);

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nTest Case 1: n = 3");
        optimizedSolidSquare(3);

        System.out.println("\nTest Case 2: n = 4");
        optimizedSolidSquare(4);

        System.out.println("\nTest Case 3: n = 6");
        optimizedSolidSquare(6);

        System.out.println("\nTest Case 4: n = 8");
        optimizedSolidSquare(8);

        System.out.println("\nTest Case 5: n = 10");
        optimizedSolidSquare(10);
    }
}
