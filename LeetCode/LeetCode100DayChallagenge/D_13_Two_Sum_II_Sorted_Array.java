public class D_13_Two_Sum_II_Sorted_Array {

    // Solution class containing the twoSum method
    public static class Solution {
        // Function to find two numbers that add up to the target in a sorted array
        public int[] twoSum(int[] numbers, int target) {
            int[] ans = new int[2];
            int start = 0;
            int end = numbers.length - 1;

            while (start < end) {
                int sum = numbers[start] + numbers[end];

                if (sum == target) {
                    ans[0] = start + 1;  // Indices are 1-based, so add 1
                    ans[1] = end + 1;
                    return ans;
                } else if (sum > target) {
                    end--;
                } else {
                    start++;
                }
            }
            return ans;
        }
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.println("Test Case 1 Result: [" + result1[0] + ", " + result1[1] + "]");  // Expected Output: [1, 2]

        // Test Case 2
        int[] numbers2 = {1, 3, 5, 7, 9};
        int target2 = 10;
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.println("Test Case 2 Result: [" + result2[0] + ", " + result2[1] + "]");  // Expected Output: [1, 5]

        // Test Case 3
        int[] numbers3 = {1, 2, 3, 4, 4, 9};
        int target3 = 8;
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.println("Test Case 3 Result: [" + result3[0] + ", " + result3[1] + "]");  // Expected Output: [4, 5]
    }
}
