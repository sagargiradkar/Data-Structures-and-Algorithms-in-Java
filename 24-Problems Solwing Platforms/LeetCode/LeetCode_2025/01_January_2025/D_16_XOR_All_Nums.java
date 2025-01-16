// D_16_XOR_All_Nums.java
public class D_16_XOR_All_Nums {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1_1 = {2, 1, 3};
        int[] nums2_1 = {10, 2, 5, 0};
        System.out.println(solution.xorAllNums(nums1_1, nums2_1)); // Expected output: 13

        int[] nums1_2 = {1, 2};
        int[] nums2_2 = {3, 4};
        System.out.println(solution.xorAllNums(nums1_2, nums2_2)); // Expected output: 0

        int[] nums1_3 = {0, 1};
        int[] nums2_3 = {2, 3};
        System.out.println(solution.xorAllNums(nums1_3, nums2_3)); // Expected output: 2
    }
}

class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        // Compute XOR of nums1
        for (int num : nums1) {
            xor1 ^= num;
        }

        // Compute XOR of nums2
        for (int num : nums2) {
            xor2 ^= num;
        }

        // Initialize result
        int result = 0;

        // If nums2 length is odd, include xor1
        if (nums2.length % 2 == 1) {
            result ^= xor1;
        }

        // If nums1 length is odd, include xor2
        if (nums1.length % 2 == 1) {
            result ^= xor2;
        }

        return result;
    }
}
