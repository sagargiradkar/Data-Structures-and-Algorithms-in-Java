import java.util.*;

public class D_01_Swap_Maximize {

    public long maxSum(Long[] arr) {
        // Sort the array to arrange elements in ascending order
        Arrays.sort(arr);

        List<Long> rearranged = new ArrayList<>();
        int n = arr.length;

        // Use two pointers: one at the start, one at the end of the sorted array
        int left = 0, right = n - 1;

        // Alternate between the largest and smallest remaining elements
        while (left <= right) {
            if (left == right) {
                rearranged.add(arr[left]);
            } else {
                rearranged.add(arr[left]);
                rearranged.add(arr[right]);
            }
            left++;
            right--;
        }

        // Calculate the sum of absolute differences in the rearranged list
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += Math.abs(rearranged.get(i) - rearranged.get((i + 1) % n));
        }

        return maxSum;
    }

    public static void main(String[] args) {
        D_01_Swap_Maximize solution = new D_01_Swap_Maximize();

        Long[] arr1 = {4L, 2L, 1L, 8L};
        System.out.println("Max Sum for arr1: " + solution.maxSum(arr1));  // Expected output: 18

        Long[] arr2 = {10L, 12L};
        System.out.println("Max Sum for arr2: " + solution.maxSum(arr2));  // Expected output: 4
    }
}
