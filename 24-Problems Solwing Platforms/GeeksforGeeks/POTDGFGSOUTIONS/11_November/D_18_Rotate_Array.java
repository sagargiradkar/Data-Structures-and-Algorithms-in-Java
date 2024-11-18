import java.util.Arrays;

public class D_18_Rotate_Array {
    public static void main(String[] args) {
        // Sample test case
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2; // Number of positions to rotate

        // Call the rotateArr method
        rotateArr(arr, d);

        // Print the rotated array
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    // Function to reverse a portion of the array
    static void rev(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        d = d % n; // Ensure d is within array bounds
        rev(arr, 0, d - 1);
        rev(arr, d, n - 1);
        rev(arr, 0, n - 1);
    }
}
