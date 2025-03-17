public class SolidRhombus {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a **solid rhombus pattern** of size 'n'.
     *
     * Example for n = 5:
     *         * * * * * 
     *        * * * * * 
     *       * * * * * 
     *      * * * * * 
     *     * * * * * 
     *
     * Approach:
     * - Use two loops:
     *   - First loop prints spaces (n-i) to create the rhombus shape.
     *   - Second loop prints 'n' stars in each row.
     * - The number of rows is equal to 'n'.
     *
     * Time Complexity: O(n²) (Each row has n operations)
     * Space Complexity: O(1) (No extra data structures used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // Print spaces for alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Print stars
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using StringBuilder for Efficiency)
     * ========================================
     * - Uses **StringBuilder** to build each row efficiently.
     * - Reduces multiple `System.out.print` calls.
     */
    public static void optimizedSolidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            // Append spaces
            for (int j = 1; j <= n - i; j++) {
                row.append("  ");
            }
            // Append stars
            for (int j = 1; j <= n; j++) {
                row.append("* ");
            }
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
        System.out.println("Solid Rhombus (Original Method)");
        solidRhombus(5);

        System.out.println("\nSolid Rhombus (Optimized Method)");
        optimizedSolidRhombus(5);

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nTest Case 1: n = 3");
        optimizedSolidRhombus(3);

        System.out.println("\nTest Case 2: n = 4");
        optimizedSolidRhombus(4);

        System.out.println("\nTest Case 3: n = 6");
        optimizedSolidRhombus(6);

        System.out.println("\nTest Case 4: n = 8");
        optimizedSolidRhombus(8);

        System.out.println("\nTest Case 5: n = 10");
        optimizedSolidRhombus(10);
    }
}
