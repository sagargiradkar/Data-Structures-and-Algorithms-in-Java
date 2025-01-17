// D_17_Product_Except_Self.java
import java.util.Arrays;

public class D_17_Product_Except_Self {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] arr1 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(arr1))); // Expected: [24, 12, 8, 6]

        // Test case 2
        int[] arr2 = {10, 3, 5, 6, 2};
        System.out.println(Arrays.toString(solution.productExceptSelf(arr2))); // Expected: [180, 600, 360, 300, 900]

        // Test case 3
        int[] arr3 = {0, 1, 2, 3};
        System.out.println(Arrays.toString(solution.productExceptSelf(arr3))); // Expected: [6, 0, 0, 0]
    }
}

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;

        // Create arrays for prefix and suffix products
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        // Calculate prefix products
        prefix[0] = 1; // No element to the left of the first element
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];
        }

        // Calculate suffix products
        suffix[n - 1] = 1; // No element to the right of the last element
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        // Calculate result array
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}
