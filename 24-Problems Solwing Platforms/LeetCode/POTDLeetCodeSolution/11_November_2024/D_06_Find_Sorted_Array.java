public class D_06_Find_Sorted_Array {
    public boolean canSortArray(int[] nums) {
        // Current Segment
        int numOfSetBits = Integer.bitCount(nums[0]);
        int maxOfSegment = nums[0];
        int minOfSegment = nums[0];
        int maxOfPrevSegment = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            if (Integer.bitCount(nums[i]) == numOfSetBits) { // Elements belong to the same segment
                maxOfSegment = Math.max(maxOfSegment, nums[i]);
                minOfSegment = Math.min(minOfSegment, nums[i]);
            } else { // Element belongs to a new segment
                if (minOfSegment < maxOfPrevSegment) { // Check proper segment arrangement
                    return false;
                }
                // Update the previous segment's max
                maxOfPrevSegment = maxOfSegment;
                // Start new segment
                maxOfSegment = nums[i];
                minOfSegment = nums[i];
                numOfSetBits = Integer.bitCount(nums[i]);
            }
        }

        // Final check for the last segment
        if (minOfSegment < maxOfPrevSegment) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        D_06_Find_Sorted_Array solution = new D_06_Find_Sorted_Array();

        int[] nums = {3, 5, 8, 10, 14};  // Example input

        boolean result = solution.canSortArray(nums);
        System.out.println("Can the array be sorted by segments? " + result);
    }
}
