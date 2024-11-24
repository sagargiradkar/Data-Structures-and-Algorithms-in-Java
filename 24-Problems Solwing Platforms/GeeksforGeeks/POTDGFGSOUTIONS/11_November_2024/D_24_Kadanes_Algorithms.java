//Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class D_24_Kadanes_Algorithms {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // Calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}
//Driver Code Ends

// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0]; // Initialize to the first element
        int currentMax = arr[0]; // Maximum sum of subarray ending at current index

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]); // Extend or start new subarray
            maxSoFar = Math.max(maxSoFar, currentMax); // Update the global maximum
        }

        return maxSoFar; // Return the maximum sum found
    }
}