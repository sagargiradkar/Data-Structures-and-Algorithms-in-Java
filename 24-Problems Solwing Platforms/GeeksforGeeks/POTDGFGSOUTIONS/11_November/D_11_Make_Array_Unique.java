import java.util.Arrays;
import java.util.Scanner;

public class D_11_Make_Array_Unique {
    public int minIncrements(int[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array
        int increments = 0;

        // Step 2: Iterate through the sorted array
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                // Step 3: Calculate how much we need to increment arr[i]
                int newValue = arr[i - 1] + 1;
                increments += newValue - arr[i];
                arr[i] = newValue; // Update arr[i] to its new incremented value
            }
        }

        return increments; // Step 4: Return total increments
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        D_11_Make_Array_Unique solution = new D_11_Make_Array_Unique();
        int result = solution.minIncrements(arr);

        System.out.println("Minimum increments required to make array unique: " + result);

        scanner.close();
    }
}
