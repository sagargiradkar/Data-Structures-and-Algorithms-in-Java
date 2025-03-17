public class FloydsTriangle {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print Floyd's Triangle with 'n' rows.
     * - Floyd’s Triangle is a right-angled triangle filled with consecutive numbers.
     *
     * Constraints:
     * 1 ≤ n ≤ 1000 (to ensure efficient execution)
     *
     * Approach:
     * - Use a counter starting from 1.
     * - For each row i, print i numbers.
     * - Increase the counter after each print.
     *
     * Time Complexity: O(n²) (nested loops iterate over n rows)
     * Space Complexity: O(1) (only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void floydsTriangle(int n) {
        int counter = 1; // Start counter at 1

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter + " ");
                counter++; // Increment counter
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using Single Print Statement)
     * ========================================
     * - Instead of two loops, use an array and StringBuilder to optimize printing.
     * - This reduces the number of System.out.print calls, making it more efficient.
     */
    public static void optimizedFloydsTriangle(int n) {
        int counter = 1;
        StringBuilder sb = new StringBuilder(); // StringBuilder for efficient printing

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sb.append(counter).append(" ");
                counter++;
            }
            sb.append("\n");
        }
        System.out.print(sb.toString()); // Print the entire triangle at once
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Nested loops over n rows)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same nested loop structure)
     * - Space Complexity: O(n²) (StringBuilder holds the full output before printing)
     * - The optimized method reduces I/O overhead by minimizing calls to System.out.print()
     */

    public static void main(String[] args) {
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("Floyd's Triangle (n = 5):");
        floydsTriangle(5);

        System.out.println("\nOptimized Floyd's Triangle (n = 5):");
        optimizedFloydsTriangle(5);

        System.out.println("\nFloyd's Triangle (n = 3):");
        floydsTriangle(3);

        System.out.println("\nFloyd's Triangle (n = 1):");
        floydsTriangle(1);

        System.out.println("\nFloyd's Triangle (n = 7):");
        floydsTriangle(7);
    }
}
