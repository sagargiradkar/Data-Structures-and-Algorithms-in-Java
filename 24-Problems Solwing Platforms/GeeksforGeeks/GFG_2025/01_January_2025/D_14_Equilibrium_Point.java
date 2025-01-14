// D_14_Equilibrium_Point.java
public class D_14_Equilibrium_Point {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {1, 3, 5, 2, 2};
        System.out.println("Equilibrium index for arr1: " + solution.findEquilibrium(arr1)); // Expected: 2

        int[] arr2 = {1, 2, 3};
        System.out.println("Equilibrium index for arr2: " + solution.findEquilibrium(arr2)); // Expected: -1

        int[] arr3 = {2, 4, -6, 2, 2, 1, 2};
        System.out.println("Equilibrium index for arr3: " + solution.findEquilibrium(arr3)); // Expected: 3

        int[] arr4 = {10};
        System.out.println("Equilibrium index for arr4: " + solution.findEquilibrium(arr4)); // Expected: 0
    }
}

class Solution {
    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        int totalSum = 0, leftSum = 0;

        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        // Iterate through the array to find the equilibrium point
        for (int i = 0; i < arr.length; i++) {
            // Right sum is totalSum - leftSum - arr[i]
            if (leftSum == totalSum - leftSum - arr[i]) {
                return i; // Equilibrium index found
            }
            leftSum += arr[i]; // Update left sum
        }

        return -1; // No equilibrium index found
    }
}
