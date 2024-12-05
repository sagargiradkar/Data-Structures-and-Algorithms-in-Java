import java.util.*;

public class D_05_Sort_012 {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int zeros = 0, ones = 0;

        // Count the number of 0s and 1s
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeros++;
            } else if (arr[i] == 1) {
                ones++;
            }
        }

        // Fill the array based on the counts of 0s, 1s, and 2s
        for (int i = 0; i < arr.length; i++) {
            if (zeros > 0) {
                arr[i] = 0;
                zeros--;
            } else if (ones > 0) {
                arr[i] = 1;
                ones--;
            } else {
                arr[i] = 2;
            }
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        D_05_Sort_012 solution = new D_05_Sort_012();
        int[] arr = {0, 2, 1, 2, 0, 1, 2, 0};
        
        System.out.println("Before sorting: " + Arrays.toString(arr));
        solution.sort012(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));
    }
}
