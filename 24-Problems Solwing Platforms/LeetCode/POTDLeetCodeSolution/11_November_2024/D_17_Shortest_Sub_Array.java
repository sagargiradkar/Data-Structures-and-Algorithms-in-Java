import java.io.*;
import java.util.*;

public class D_17_Shortest_Sub_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Number of test cases
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            // Read the array size and k
            String[] inputs = br.readLine().split(" ");
            int n = Integer.parseInt(inputs[0]);
            int k = Integer.parseInt(inputs[1]);

            // Read the array
            int[] nums = new int[n];
            String[] numStrs = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(numStrs[i]);
            }

            // Call the method to find the shortest subarray
            Solution obj = new Solution();
            int result = obj.shortestSubarray(nums, k);

            // Print the result
            System.out.println(result);
        }
    }
}

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int N = nums.length;

        Deque<Integer> deq = new LinkedList<>();
        long[] cumulativeSum = new long[N];  // This stores the cumulative sum

        int result = Integer.MAX_VALUE;
        int j = 0;

        // Compute cumulative sum in the cumulativeSum array using while loop
        while (j < N) {
            if (j == 0)
                cumulativeSum[j] = nums[j];
            else
                cumulativeSum[j] = cumulativeSum[j - 1] + nums[j];

            // If the cumulative sum from the start to j is already >= k, update result
            if (cumulativeSum[j] >= k) 
                result = Math.min(result, j + 1);

            // Remove indices from the deque where the subarray sum is >= k
            while (!deq.isEmpty() && cumulativeSum[j] - cumulativeSum[deq.peekFirst()] >= k) {
                result = Math.min(result, j - deq.peekFirst());  // Calculate the length of the subarray
                deq.pollFirst();  // Remove the front index from the deque
            }

            // Maintain the monotonic property of the deque (increasing order of cumulative sums)
            while (!deq.isEmpty() && cumulativeSum[j] <= cumulativeSum[deq.peekLast()]) {
                deq.pollLast();  // Remove indices that won't be useful
            }

            // Add the current index to the deque
            deq.offerLast(j);

            j++;  // Increment j to move to the next index
        }

        // Return the result if we found a valid subarray, otherwise return -1
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}