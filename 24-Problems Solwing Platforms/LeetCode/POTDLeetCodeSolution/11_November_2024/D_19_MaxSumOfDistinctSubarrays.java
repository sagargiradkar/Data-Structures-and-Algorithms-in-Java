import java.util.*;
public class D_19_MaxSumOfDistinctSubarrays {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, currentSum = 0;
        int left = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            currentSum += num;

            // If the subarray has more than `k` elements or contains duplicates, shrink the window
            while (freqMap.size() < right - left + 1) {
                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                currentSum -= leftNum;
                left++;
            }

            // If the subarray has exactly `k` distinct elements, update the max sum
            if (freqMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumOfDistinctSubarrays solution = new MaxSumOfDistinctSubarrays();
        int[] nums = {4, 2, 4, 5, 6};
        int k = 3;
        System.out.println("Maximum Sum: " + solution.maximumSubarraySum(nums, k));
    }
}

