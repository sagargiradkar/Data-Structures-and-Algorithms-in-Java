import java.util.ArrayList;
import java.util.Arrays;

public class SDE_02_Reverse_Array_Group {
    public static void main(String[] args) {
        // Initialize an ArrayList of Longs
        ArrayList<Long> arr = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        int k = 3;  // Group size for reversing

        // Create an instance of Solution and call the reverseInGroups method
        Solution solution = new Solution();
        solution.reverseInGroups(arr, k);

        // Print the result
        System.out.println("Array after reversing in groups of " + k + ": " + arr);
    }
}

class Solution {
    // Method to reverse a sub-array within the specified group size
    void reverse(ArrayList<Long> arr, int i, int n, int k) {
        int left = i;
        int right = Math.min(n - 1, i + k - 1);
        while (left < right) {
            long temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            left++;
            right--;
        }
    }

    // Function to reverse every sub-array group of size k
    void reverseInGroups(ArrayList<Long> arr, int k) {
        int n = arr.size();
        for (int i = 0; i < n; i += k) {
            reverse(arr, i, n, k);
        }
    }
}
