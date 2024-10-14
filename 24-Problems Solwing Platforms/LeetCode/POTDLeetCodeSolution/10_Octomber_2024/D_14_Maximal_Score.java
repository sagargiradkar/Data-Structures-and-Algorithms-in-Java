import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // Use a max-heap to get the largest element first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements from nums into the priority queue
        for (int num : nums) {
            pq.offer(num);
        }

        long score = 0;

        // Process k elements from the priority queue
        while (k > 0) {
            int val = pq.poll();  // Get the largest element
            score += val;         // Add it to the score
            pq.offer((int) Math.ceil(val / 3.0)); // Add ceil(val / 3.0) back to the heap
            k--;  // Decrement k
        }

        return score;
    }
}

public class D_14_Maximal_Score {
    public static void main(String[] args) {
        // Example input
        int[] nums = {9, 5, 12, 7};
        int k = 3;

        // Creating an instance of Solution class
        Solution solution = new Solution();

        // Calling the maxKelements method and printing the result
        long result = solution.maxKelements(nums, k);
        System.out.println("Maximal score: " + result);
    }
}
