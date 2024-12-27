// Filename: D_27_Count_Pairs.java
import java.util.HashMap;

public class D_27_Count_Pairs {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 5, 7, 1}; // Example input array
        int target = 6; // Example target
        int result = solution.countPairs(arr, target);
        System.out.println("Number of pairs with given target: " + result);
    }
}

class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;
        
        for (int num : arr) {
            // Find the complement
            int complement = target - num;
            
            // If the complement exists, add its frequency to the count
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }
            
            // Update the frequency of the current number
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}
