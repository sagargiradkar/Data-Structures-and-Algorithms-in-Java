
import java.util.HashMap;

public class HM_16_Subarray_Sum_Equal_TO_K {

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize the map with the sum of 0 to handle the case where the subarray starts from index 0
        map.put(0, 1);

        int sum = 0; // Cumulative sum
        int ans = 0; // Count of subarrays with sum equal to k

        // Iterate through the array
        for (int j = 0; j < arr.length; j++) {
            sum += arr[j]; // Update cumulative sum

            // Check if there exists a subarray that sums to k
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k); // Increment count by the number of times (sum - k) has occurred
            }

            // Update the map with the current cumulative sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Number of subarrays with sum equal to " + k + " => " + ans);
    }
}
