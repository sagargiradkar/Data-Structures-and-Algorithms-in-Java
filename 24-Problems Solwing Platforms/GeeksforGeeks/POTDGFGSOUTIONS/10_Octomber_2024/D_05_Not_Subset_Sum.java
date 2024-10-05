public class D_05_Not_Subset_Sum {

    public static void main(String[] args) {
       
        // Example usage:
        int[] arr1 = {1, 2, 3};
        long smallest1 = findSmallest(arr1);
        System.out.println("Smallest number not in the subset of " + java.util.Arrays.toString(arr1) + " is: " + smallest1); // Output: 4

        int[] arr2 = {1, 1, 1, 3};
        long smallest2 = findSmallest(partialSum(arr2)); // Handle potential overflow with partialSum
        System.out.println("Smallest number not in the subset of " + java.util.Arrays.toString(arr2) + " is: " + smallest2); // Output: 6
    }

    public static long findSmallest(int[] arr) {
        long sum = 1;  // Start with 1 as the smallest possible positive integer

        for (int num : arr) {
            if (sum > Long.MAX_VALUE - num) {  // Check for potential overflow before adding
                return sum;
            }
            sum += num;
        }

        return sum;
    }

    // Helper function to calculate partial sum for handling potential overflow (optional)
    public static int[] partialSum(int[] arr) {
        int[] partialSums = new int[arr.length];
        partialSums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            partialSums[i] = partialSums[i - 1] + arr[i];
        }
        return partialSums;
    }
}