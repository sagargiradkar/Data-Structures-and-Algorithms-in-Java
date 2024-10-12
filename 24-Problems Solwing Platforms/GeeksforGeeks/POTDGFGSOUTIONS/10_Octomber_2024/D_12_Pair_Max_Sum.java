import java.util.Scanner;

public class D_12_Pair_Max_Sum {

    // Method to find the pair with the maximum sum
    public static int pairWithMaxSum(int[] arr) {
        int maxi = -1;
        for (int i = 1; i < arr.length; i++) {
            maxi = Math.max(maxi, arr[i] + arr[i - 1]);
        }
        return maxi;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Output the result
        System.out.println("The maximum sum of adjacent pairs is: " + pairWithMaxSum(arr));

        scanner.close();
    }
}