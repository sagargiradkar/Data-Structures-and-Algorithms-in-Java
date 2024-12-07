// Filename: D_07_minimumSize.java
import java.util.Arrays;

public class D_07_minimumSize {
    public boolean isPossible(int[] nums, int maxOps, int mid) {
        int totalOps = 0; // To bring each number <= mid

        for (int num : nums) {
            int ops = num / mid;

            if (num % mid == 0) {
                ops -= 1;
            }

            totalOps += ops;
        }

        return totalOps <= maxOps;
    }

    public int minimumSize(int[] nums, int maxOperations) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt(); // Find max in nums
        
        int result = r; // We have to minimize this

        // Binary search: O(n * log(MAX))
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(nums, maxOperations, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        D_07_minimumSize solution = new D_07_minimumSize();
        int[] nums = {9, 7, 15, 3};
        int maxOperations = 5;

        System.out.println("Minimum possible maximum ball size: " + solution.minimumSize(nums, maxOperations));
        // Expected output: the minimum maximum size that can be achieved.
    }
}
