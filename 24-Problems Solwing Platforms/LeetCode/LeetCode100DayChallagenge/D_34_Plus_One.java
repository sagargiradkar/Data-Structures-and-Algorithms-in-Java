
public class D_34_Plus_One {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample inputs
        int[] digits1 = {1, 2, 3};
        int[] result1 = solution.plusOne(digits1);
        System.out.print("Test 1: ");
        printArray(result1); // Expected: [1, 2, 4]

        int[] digits2 = {4, 3, 2, 1};
        int[] result2 = solution.plusOne(digits2);
        System.out.print("Test 2: ");
        printArray(result2); // Expected: [4, 3, 2, 2]

        int[] digits3 = {9, 9, 9};
        int[] result3 = solution.plusOne(digits3);
        System.out.print("Test 3: ");
        printArray(result3); // Expected: [1, 0, 0, 0]

        int[] digits4 = {0};
        int[] result4 = solution.plusOne(digits4);
        System.out.print("Test 4: ");
        printArray(result4); // Expected: [1]
    }

    // Helper method to print arrays
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

class Solution {

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        if (digits[n - 1] != 9) {
            digits[n - 1] = digits[n - 1] + 1;
            return digits;
        }

        digits[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }

        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
