import java.util.Scanner;

public class D_10_Shortest_SubArray {

    static class Solution {

        private int val(int[] cnt) {
            int temp = 0;
            for (int i = 0; i < 30; i++) {
                if (cnt[i] != 0) {
                    temp ^= 1 << i;
                }
            }
            return temp;
        }

        public int minimumSubarrayLength(int[] nums, int k) {
            int[] cnt = new int[30];
            int p = 0;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < 30; j++) {
                    cnt[j] += (nums[i] >> j) & 1;
                }
                while (p <= i && val(cnt) >= k) {
                    res = Math.min(res, i - p + 1);
                    for (int j = 0; j < 30; j++) {
                        cnt[j] -= (nums[p] >> j) & 1;
                    }
                    p++;
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input the target value k
        System.out.print("Enter the target value k: ");
        int k = scanner.nextInt();

        Solution solution = new Solution();
        int result = solution.minimumSubarrayLength(nums, k);

        // Output the result
        if (result == -1) {
            System.out.println("No subarray meets the criteria.");
        } else {
            System.out.println("Minimum subarray length with XOR value >= " + k + " is: " + result);
        }

        scanner.close();
    }
}
