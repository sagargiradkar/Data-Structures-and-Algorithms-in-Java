import java.util.Scanner;

public class D_06_Kadane_Algorithm {

    // Solution class containing the method for Kadane's Algorithm
    static class Solution {

        public long maxSubarraySum(int[] arr) {
            // Initializing sum to 0 and maxi to the first element of the array
            long sum = 0;
            long maxi = arr[0];

            // Loop through the array
            for (int i = 0; i < arr.length; i++) {
                // Add current element to sum
                sum += arr[i];
                
                // Update maxi if the current sum is greater than maxi
                maxi = Math.max(sum, maxi);
                
                // If sum becomes negative, reset it to 0
                if (sum < 0) sum = 0;
            }

            // Return the maximum subarray sum
            return maxi;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Input the elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Create an instance of the Solution class and call the method to find the maximum subarray sum
        Solution solution = new Solution();
        long maxSum = solution.maxSubarraySum(arr);

        // Output the result
        System.out.println("The maximum subarray sum is: " + maxSum);

        sc.close();
    }
}
