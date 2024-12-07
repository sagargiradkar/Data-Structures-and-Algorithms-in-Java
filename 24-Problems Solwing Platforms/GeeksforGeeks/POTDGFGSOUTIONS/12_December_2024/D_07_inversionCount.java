// Filename: D_07_inversionCount.java

public class D_07_inversionCount {

    public static int inversionCount(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        return mergeSort(arr, temp, 0, n - 1);
    }

    // Merge sort function that counts inversions
    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int invCount = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in the left half
            invCount += mergeSort(arr, temp, left, mid);

            // Count inversions in the right half
            invCount += mergeSort(arr, temp, mid + 1, right);

            // Count inversions while merging both halves
            invCount += merge(arr, temp, left, mid, right);
        }
        return invCount;
    }

    // Merge function that counts split inversions
    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Starting index for the left subarray
        int j = mid + 1; // Starting index for the right subarray
        int k = left;    // Starting index for the merged array
        int invCount = 0;

        // Merge both halves while counting inversions
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                // Count inversions
                invCount += (mid - i + 1);
            }
        }

        // Copy remaining elements from the left subarray
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from the right subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged subarray back to the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 3, 5};
        int[] arr2 = {2, 3, 4, 5, 6};
        int[] arr3 = {10, 10, 10};

        System.out.println("Inversion Count for arr1: " + inversionCount(arr1)); // Output: 3
        System.out.println("Inversion Count for arr2: " + inversionCount(arr2)); // Output: 0
        System.out.println("Inversion Count for arr3: " + inversionCount(arr3)); // Output: 0
    }
}
