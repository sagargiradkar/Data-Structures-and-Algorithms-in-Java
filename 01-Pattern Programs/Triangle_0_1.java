public class Triangle_0_1 {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a **triangle pattern** where:
     * - The first element of each row starts with 1.
     * - Elements are alternatively '0' and '1' based on (i + j) % 2.
     *
     * Example for n = 5:
     * 1
     * 0 1
     * 1 0 1
     * 0 1 0 1
     * 1 0 1 0 1
     *
     * Approach:
     * - Use two nested loops:
     *   - Outer loop runs 'n' times for rows.
     *   - Inner loop prints numbers based on the condition (i + j) % 2.
     * - If (i + j) is even, print "1", otherwise print "0".
     *
     * Time Complexity: O(n²) (Each row has 'i' elements)
     * Space Complexity: O(1) (No extra data structures used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void triangleZeroOne(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) { // even condition
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
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
    public static void optimizedTriangleZeroOne(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                row.append((i + j) % 2 == 0 ? "1 " : "0 ");
            }
            System.out.println(row);
        }
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each row processes 'i' elements)
     * - Space Complexity: O(1) (Only loop variables used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same logic, but reduces print overhead)
     * - Space Complexity: O(n) (Uses a StringBuilder for row storage)
     */

    public static void main(String[] args) {
        System.out.println("Triangle 0/1 (Original Method)");
        triangleZeroOne(5);

        System.out.println("\nTriangle 0/1 (Optimized Method)");
        optimizedTriangleZeroOne(5);

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nTest Case 1: n = 3");
        optimizedTriangleZeroOne(3);

        System.out.println("\nTest Case 2: n = 4");
        optimizedTriangleZeroOne(4);

        System.out.println("\nTest Case 3: n = 6");
        optimizedTriangleZeroOne(6);

        System.out.println("\nTest Case 4: n = 8");
        optimizedTriangleZeroOne(8);

        System.out.println("\nTest Case 5: n = 10");
        optimizedTriangleZeroOne(10);
    }
}
