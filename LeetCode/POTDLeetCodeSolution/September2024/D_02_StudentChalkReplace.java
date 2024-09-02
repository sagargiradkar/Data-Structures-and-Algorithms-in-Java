public class D_02_StudentChalkReplace {

    // Method to determine the index of the student who needs to replace the chalk
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long totalChalk = 0;
        
        // Calculate total chalk usage for one full round
        for (int c : chalk) {
            totalChalk += c;
        }
        
        // Find the remaining chalk after full rounds
        k %= totalChalk;
        
        // Determine which student will need to replace the chalk
        for (int i = 0; i < n; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }
        
        return -1;  // This should not be reached
    }
    
    // Main method to test the chalkReplacer method
    public static void main(String[] args) {
        D_02_StudentChalkReplace solution = new D_02_StudentChalkReplace();
        
        // Test Case 1
        int[] chalk1 = {5, 1, 5};
        int k1 = 22;
        int result1 = solution.chalkReplacer(chalk1, k1);
        System.out.println("Test Case 1: " + result1); // Expected output: 0
        
        // Test Case 2
        int[] chalk2 = {3, 4, 1, 2};
        int k2 = 25;
        int result2 = solution.chalkReplacer(chalk2, k2);
        System.out.println("Test Case 2: " + result2); // Expected output: 1
        
        // Test Case 3
        int[] chalk3 = {10, 5, 1};
        int k3 = 12;
        int result3 = solution.chalkReplacer(chalk3, k3);
        System.out.println("Test Case 3: " + result3); // Expected output: 2
        
        // Test Case 4 (Edge Case)
        int[] chalk4 = {1};
        int k4 = 100;
        int result4 = solution.chalkReplacer(chalk4, k4);
        System.out.println("Test Case 4: " + result4); // Expected output: 0
    }
}
