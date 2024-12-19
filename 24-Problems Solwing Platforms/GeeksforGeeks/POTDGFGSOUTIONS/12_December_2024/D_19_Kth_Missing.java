public class D_19_Kth_Missing {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        // Call the function and display the result
        int result = solution.kthMissing(arr, k);
        System.out.println("The " + k + "th missing number is: " + result);
    }
}

class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int current = 1; // Start from the first positive integer
        int i = 0; // Index for the array
        while (i < n) {
            // If the current number is not in the array, it's missing
            if (arr[i] != current) {
                k--; // One missing number found
                if (k == 0) {
                    return current; // We've found the kth missing number
                }
            } else {
                i++; // Move to the next element in the array if current number is found
            }
            current++; // Move to the next positive integer
        }

        // If we finish the array and haven't found the kth missing number, continue after the last number in the array
        return current + (k - 1);
    }
}
