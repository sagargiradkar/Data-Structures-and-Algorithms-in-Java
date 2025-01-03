// D_03_Subarray_Xor.java
import java.util.HashMap;
import java.util.Map;

public class D_03_Subarray_Xor {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        long result = solution.subarrayXor(arr, k);
        System.out.println("Count of subarrays with XOR equal to " + k + ": " + result);
    }
}

class Solution {
    public long subarrayXor(int arr[], int k) {
        // Initialize variables
        long count = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate over the array
        for (int num : arr) {
            // Calculate prefix XOR
            xor ^= num;
            
            // If the XOR equals k, increment count
            if (xor == k) {
                count++;
            }
            
            // Check if there exists a prefix with XOR `xor ^ k`
            int target = xor ^ k;
            if (map.containsKey(target)) {
                count += map.get(target);
            }
            
            // Update the frequency map for the current XOR
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}
