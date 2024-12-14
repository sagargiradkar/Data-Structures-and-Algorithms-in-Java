public class D_14_Search_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key1 = 3;
        System.out.println("Index of " + key1 + ": " + solution.search(arr1, key1)); // Output: 8

        int[] arr2 = {3, 5, 1, 2};
        int key2 = 6;
        System.out.println("Index of " + key2 + ": " + solution.search(arr2, key2)); // Output: -1

        int[] arr3 = {33, 42, 72, 99};
        int key3 = 42;
        System.out.println("Index of " + key3 + ": " + solution.search(arr3, key3)); // Output: 1
    }
}

class Solution {
    int search(int[] arr, int key) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if the mid element is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Determine which part is sorted
            if (arr[low] <= arr[mid]) { 
                // Left half is sorted
                if (key >= arr[low] && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { 
                // Right half is sorted
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // Key not found
        return -1;
    }
}
