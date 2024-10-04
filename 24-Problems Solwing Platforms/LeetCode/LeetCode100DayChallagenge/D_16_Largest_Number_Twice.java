public class D_16_Largest_Number_Twice {

    // Method to find the dominant index
    public int dominantIndex(int[] nums) {
        int max = -1;
        int smax = -1;  // second maximum
        int maxIdx = 0;

        // Traverse the array to find max and second max
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                smax = max;
                max = nums[i];
                maxIdx = i;
            } else if (smax < nums[i]) {
                smax = nums[i];
            }
        }

        // Check if the largest number is at least twice as large as the second largest
        if (smax * 2 <= max) {
            return maxIdx;
        } else {
            return -1;
        }
    }

    // Main method
    public static void main(String[] args) {
        D_16_Largest_Number_Twice solution = new D_16_Largest_Number_Twice();

        // Example input array
        int[] nums = {3, 6, 1, 0};

        // Get the dominant index
        int result = solution.dominantIndex(nums);

        // Output the result
        System.out.println("Dominant Index: " + result);  // Expected output: 1
    }
}
