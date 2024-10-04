import java.util.Arrays;

public class D_12_Square_Sorted_Array {

    public int[] sortedSquares(int[] nums) {
        int ans[] = new int[nums.length];

        int start = 0;
        int end = nums.length - 1;

        int ptr = ans.length - 1;

        while (start <= end) {
            int ss = nums[start] * nums[start];
            int es = nums[end] * nums[end];

            if (ss > es) {
                ans[ptr] = ss;
                start++;
            } else {
                ans[ptr] = es;
                end--;
            }
            ptr--;
        }
        return ans;
    }

    public static void main(String[] args) {
        D_12_Square_Sorted_Array solution = new D_12_Square_Sorted_Array();

        // Example 1
        int[] nums1 = {-4, -1, 0, 3, 10};
        int[] result1 = solution.sortedSquares(nums1);
        System.out.println("Sorted squares of nums1: " + Arrays.toString(result1));
        // Output: [0, 1, 9, 16, 100]

        // Example 2
        int[] nums2 = {-7, -3, 2, 3, 11};
        int[] result2 = solution.sortedSquares(nums2);
        System.out.println("Sorted squares of nums2: " + Arrays.toString(result2));
        // Output: [4, 9, 9, 49, 121]
    }
}
