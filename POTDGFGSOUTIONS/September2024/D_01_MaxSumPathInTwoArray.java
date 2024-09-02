package September2024;
import java.util.ArrayList;
import java.util.List;

public class D_01_MaxSumPathInTwoArray {

    // Method to compute the maximum path sum
    public int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0;
        int ans = 0;

        // Traverse both arrays until one of them is exhausted
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) < arr2.get(j)) {
                // Accumulate sum from arr1
                sum1 += arr1.get(i++);
            } else if (arr1.get(i) > arr2.get(j)) {
                // Accumulate sum from arr2
                sum2 += arr2.get(j++);
            } else {
                // Found a common element, take the maximum of the two sums
                ans += Math.max(sum1, sum2) + arr1.get(i);
                sum1 = 0;  // Reset sums for the next segment
                sum2 = 0;
                i++;
                j++;
            }
        }

        // Accumulate remaining elements in arr1
        while (i < arr1.size()) {
            sum1 += arr1.get(i++);
        }

        // Accumulate remaining elements in arr2
        while (j < arr2.size()) {
            sum2 += arr2.get(j++);
        }

        // Add the maximum of the remaining sums
        ans += Math.max(sum1, sum2);

        return ans;
    }

    // Main method to test the maxPathSum function
    public static void main(String[] args) {
        // Create sample lists
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        // Populate the lists with sample data
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        arr1.add(10);
        arr1.add(15);
        
        arr2.add(3);
        arr2.add(6);
        arr2.add(7);
        arr2.add(10);
        arr2.add(15);
        
        // Create an instance of the class
        D_01_MaxSumPathInTwoArray solution = new D_01_MaxSumPathInTwoArray();
        
        // Call the method and print the result
        int result = solution.maxPathSum(arr1, arr2);
        System.out.println("The maximum path sum is: " + result);
    }
}
