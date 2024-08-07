import java.util.Arrays;

public class MergeSortedArray {
    public static void mergeSortedArray(int arr1[], int arr2[], int n1, int n2, int arr3[]) {
        int i = 0, j = 0, k = 0;

        // Merge the arrays
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }
        // Copy remaining elements of arr1[], if any
        while (i < n1)
            arr3[k++] = arr1[i++];
        
        // Copy remaining elements of arr2[], if any
        while (j < n2)
            arr3[k++] = arr2[j++];

        // Print the merged array
        for (int t : arr3) {
            System.out.print(t + " ");
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 3, 65, 4, 765, 6, 4, 8, 7, 8};
        int arr2[] = {34, 46, 5, 56, 45, 7, 88, 68, 5, 2};
        // Sort the arrays before merging
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        int n1 = arr1.length;
        int n2 = arr2.length;
        int arr3[] = new int[n1 + n2];
        
        mergeSortedArray(arr1, arr2, n1, n2, arr3);
    }
}
