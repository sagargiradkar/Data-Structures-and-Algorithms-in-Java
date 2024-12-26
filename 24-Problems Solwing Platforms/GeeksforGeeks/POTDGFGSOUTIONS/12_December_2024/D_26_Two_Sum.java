import java.util.HashSet;

public class D_26_Two_Sum {
    // Method to check if two numbers in the array sum up to the target
    boolean twoSum(int arr[], int target) {
        // Create a HashSet to store elements of the array
        HashSet<Integer> seen = new HashSet<>();
        
        // Traverse the array
        for (int num : arr) {
            int complement = target - num;
            // Check if the complement exists in the HashSet
            if (seen.contains(complement)) {
                return true;
            }
            // Add the current number to the HashSet
            seen.add(num);
        }
        // If no pair is found, return false
        return false;
    }

    // Main method
    public static void main(String[] args) {
        D_26_Two_Sum solution = new D_26_Two_Sum();
        
        // Example 1
        int[] arr1 = {1, 4, 45, 6, 10, 8};
        int target1 = 16;
        System.out.println(solution.twoSum(arr1, target1)); // Output: true

        // Example 2
        int[] arr2 = {1, 2, 4, 3, 6};
        int target2 = 11;
        System.out.println(solution.twoSum(arr2, target2)); // Output: false

        // Example 3
        int[] arr3 = {11};
        int target3 = 11;
        System.out.println(solution.twoSum(arr3, target3)); // Output: false
    }
}