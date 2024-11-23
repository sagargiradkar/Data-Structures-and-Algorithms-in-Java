public class D_15_Shortest_Subarray {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        
        // If the entire array is already sorted
        if (left == n - 1) {
            return 0;
        }
        
        // Step 2: Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        
        // Step 3: Calculate minimum removal
        // Remove all elements from one side
        int minRemoval = Math.min(n - left - 1, right);
        
        // Merge prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minRemoval = Math.min(minRemoval, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        
        return minRemoval;
    }

    public static void main(String[] args) {
        D_15_Shortest_Subarray solution = new D_15_Shortest_Subarray();
        
        int[] arr1 = {1, 2, 3, 10, 4, 2, 3, 5};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr3 = {1, 2, 3, 4, 5};

        System.out.println("Example 1: " + solution.findLengthOfShortestSubarray(arr1)); // Output: 3
        System.out.println("Example 2: " + solution.findLengthOfShortestSubarray(arr2)); // Output: 4
        System.out.println("Example 3: " + solution.findLengthOfShortestSubarray(arr3)); // Output: 0
    }
}
