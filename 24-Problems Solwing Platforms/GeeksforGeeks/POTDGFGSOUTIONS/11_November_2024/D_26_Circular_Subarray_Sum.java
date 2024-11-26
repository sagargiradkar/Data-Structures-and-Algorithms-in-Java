public class D_26_Circular_Subarray_Sum {
    public static void main(String[] args) {
        // Example input
        int[] arr = {8, -8, 9, -9, 10, -11, 12};

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calling the circularSubarraySum function
        int result = solution.circularSubarraySum(arr);

        // Printing the result
        System.out.println("Maximum Circular Subarray Sum: " + result);
    }
}

class Solution {
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        
        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxKadane = kadane(arr, n);
        
        // Step 2: Calculate the total array sum
        int arraySum = 0;
        for (int i = 0; i < n; i++) {
            arraySum += arr[i];
        }
        
        // Step 3: Find the minimum subarray sum using Kadane's algorithm on inverted values
        int minKadane = kadaneForMin(arr, n);
        
        // Step 4: Compute the maximum circular subarray sum
        int maxCircular = arraySum - minKadane;

        // Step 5: Handle the edge case where all elements are negative
        if (maxCircular == 0) { 
            return maxKadane; 
        }

        // Return the maximum of the two cases
        return Math.max(maxKadane, maxCircular);
    }

    // Function to find maximum subarray sum (Kadane's algorithm)
    private int kadane(int[] arr, int n) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];
        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // Function to find minimum subarray sum (Kadane's algorithm on inverted values)
    private int kadaneForMin(int[] arr, int n) {
        int minEndingHere = arr[0];
        int minSoFar = arr[0];
        for (int i = 1; i < n; i++) {
            minEndingHere = Math.min(arr[i], minEndingHere + arr[i]);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        return minSoFar;
    }
}
