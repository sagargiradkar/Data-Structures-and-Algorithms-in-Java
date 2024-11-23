import java.util.Arrays;

public class D_16_Move_Zeros_To_End {
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int index = 0; // Pointer to place the next non-zero element

        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        // Fill the remaining positions with zeros
        while (index < n) {
            arr[index] = 0;
            index++;
        }
    }

    public static void main(String[] args) {
        D_16_Move_Zeros_To_End solution = new D_16_Move_Zeros_To_End();
        
        // Test Case 1
        int[] arr1 = {1, 2, 0, 4, 3, 0, 5, 0};
        solution.pushZerosToEnd(arr1);
        System.out.println("Test Case 1: " + Arrays.toString(arr1));
        // Output: [1, 2, 4, 3, 5, 0, 0, 0]

        // Test Case 2
        int[] arr2 = {10, 20, 30};
        solution.pushZerosToEnd(arr2);
        System.out.println("Test Case 2: " + Arrays.toString(arr2));
        // Output: [10, 20, 30]

        // Test Case 3
        int[] arr3 = {0, 0};
        solution.pushZerosToEnd(arr3);
        System.out.println("Test Case 3: " + Arrays.toString(arr3));
        // Output: [0, 0]

        // Test Case 4
        int[] arr4 = {0, 1, 0, 3, 12};
        solution.pushZerosToEnd(arr4);
        System.out.println("Test Case 4: " + Arrays.toString(arr4));
        // Output: [1, 3, 12, 0, 0]
    }
}
