// D_06_Sum_Closest.java
import java.util.*;

public class D_06_Sum_Closest {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {10, 22, 28, 29, 30, 40};
        int target = 54;
        List<Integer> result = solution.sumClosest(arr, target);
        System.out.println("Pair with the closest sum to target: " + result);
    }
}

// User function Template for Java
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: If there are less than 2 elements, return an empty list
        if (arr.length < 2) {
            return result;
        }
        
        // Sort the array
        Arrays.sort(arr);
        int n = arr.length;

        // Initialize variables
        int closestSum = Integer.MAX_VALUE;
        int maxDiff = -1; // To store the max absolute difference
        int left = 0, right = n - 1;

        // Two-pointer approach
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // Check if the current sum is closer to the target
            if (Math.abs(sum - target) < Math.abs(closestSum - target) ||
                (Math.abs(sum - target) == Math.abs(closestSum - target) && (arr[right] - arr[left]) > maxDiff)) {
                closestSum = sum;
                maxDiff = arr[right] - arr[left];
                result = Arrays.asList(arr[left], arr[right]);
            }
            
            // Move pointers based on the comparison of sum and target
            if (sum < target) {
                left++;
            } else {
                right
