

public class D_15_PeakElement {

    public int peakElement(int[] arr) {
        int n = arr.length;

        // Edge case: Single element is always a peak
        if (n == 1) {
            return 0;
        }

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if the mid element is a peak
            boolean isLeftSmaller = (mid == 0) || (arr[mid] > arr[mid - 1]);
            boolean isRightSmaller = (mid == n - 1) || (arr[mid] > arr[mid + 1]);

            if (isLeftSmaller && isRightSmaller) {
                return mid; // Found a peak element
            }

            // If the left neighbor is greater, move to the left subarray
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                high = mid - 1;
            } // Else, move to the right subarray
            else {
                low = mid + 1;
            }
        }

        return -1; // This should never be reached if input is valid
    }

    public static void main(String[] args) {
        D_15_PeakElement solution = new D_15_PeakElement();

        // Test cases
        int[] arr1 = {10, 20, 15, 2, 23, 90, 80};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 3, 2};

        System.out.println("Peak index in arr1: " + solution.peakElement(arr1)); // Output: 1 or 5
        System.out.println("Peak index in arr2: " + solution.peakElement(arr2)); // Output: 2
        System.out.println("Peak index in arr3: " + solution.peakElement(arr3)); // Output: 1
    }
}
