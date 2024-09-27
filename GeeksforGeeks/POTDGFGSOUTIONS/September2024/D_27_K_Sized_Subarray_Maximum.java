import java.util.*;

public class D_27_K_Sized_Subarray_Maximum {
    public static void main(String[] args) {
        // Example array and subarray size k
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        // Create an instance of Solution
        Solution sol = new Solution();

        // Get the maximum of each subarray of size k
        ArrayList<Integer> result = sol.max_of_subarrays(k, arr);

        // Print the result
        System.out.println(result);  // Expected output: [3, 3, 5, 5, 6, 7]
    }
}

class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // Remove the elements that are out of the current window
            if (!dq.isEmpty() && dq.getFirst() == i - k) {
                dq.removeFirst();
            }

            // Remove elements smaller than the current element from the deque
            while (!dq.isEmpty() && arr[dq.getLast()] <= arr[i]) {
                dq.removeLast();
            }

            // Add the current element index to the deque
            dq.addLast(i);

            // Once the window size reaches k, add the max to the result
            if (i >= k - 1) {
                ans.add(arr[dq.getFirst()]);
            }
        }
        return ans;
    }
}
