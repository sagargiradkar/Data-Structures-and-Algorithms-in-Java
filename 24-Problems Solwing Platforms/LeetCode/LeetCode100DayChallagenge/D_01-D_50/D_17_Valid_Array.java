// D_17_Valid_Array.java
public class D_17_Valid_Array {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] derived1 = {1, 0, 1};
        System.out.println(solution.doesValidArrayExist(derived1)); // Expected output: true

        int[] derived2 = {1, 1, 0};
        System.out.println(solution.doesValidArrayExist(derived2)); // Expected output: false

        int[] derived3 = {0, 0, 0};
        System.out.println(solution.doesValidArrayExist(derived3)); // Expected output: true
    }
}

class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        // Case 1: original[0] = 0
        if (isValid(derived, 0, n)) return true;

        // Case 2: original[0] = 1
        if (isValid(derived, 1, n)) return true;

        return false;
    }

    private boolean isValid(int[] derived, int first, int n) {
        int[] original = new int[n];
        original[0] = first;

        // Build the original array based on derived
        for (int i = 1; i < n; i++) {
            original[i] = derived[i - 1] ^ original[i - 1];
        }

        // Validate the circular condition
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
}
