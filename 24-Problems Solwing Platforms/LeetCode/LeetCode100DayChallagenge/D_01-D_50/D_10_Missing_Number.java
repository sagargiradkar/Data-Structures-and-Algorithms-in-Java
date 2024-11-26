public class D_10_Missing_Number {

    public static void main(String[] args) {
       

        // Sample array with a missing number
        int[] nums = {1, 2, 3, 4, 6};

        // Find the missing number
        int missingNumber = missingNumber(nums);

        // Print the missing number
        System.out.println("The missing number in the array is: " + missingNumber);
    }

    public static int missingNumber(int[] nums) {
        int range = nums.length + 1; // Since the array is 0-based and has n-1 elements
        int actualSum = (range * (range + 1)) / 2; // n(n+1)/2

        // Actual sum when the missing number is present in the array
        int currentSum = 0;

        for (int i = 0; i < range - 1; i++) { // Iterate till range-1 to avoid out-of-bounds access
            currentSum += nums[i];
        }
        return actualSum - currentSum;
    }
}