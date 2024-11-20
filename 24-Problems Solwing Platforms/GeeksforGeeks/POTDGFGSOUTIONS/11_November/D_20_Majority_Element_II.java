import java.util.ArrayList;
import java.util.List;

public class D_20_Majority_Element_II {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Step 1: Identify potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Step 3: Return result in sorted order
        result.sort(Integer::compareTo);
        return result;
    }

    // Main method
    public static void main(String[] args) {
        D_20_Majority_Element_II solution = new D_20_Majority_Element_II();

        // Test case 1
        int[] arr1 = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println("Test Case 1: " + solution.findMajority(arr1)); // Output: [5, 6]

        // Test case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + solution.findMajority(arr2)); // Output: []

        // Test case 3
        int[] arr3 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Test Case 3: " + solution.findMajority(arr3)); // Output: [4]
    }
}
