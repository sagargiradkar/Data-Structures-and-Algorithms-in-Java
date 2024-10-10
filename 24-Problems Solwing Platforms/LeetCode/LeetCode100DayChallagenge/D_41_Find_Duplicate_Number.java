public class D_41_Find_Duplicate_Number {

    // Method to find the duplicate number in the array
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int ele = Math.abs(nums[i]);

            if (nums[ele] < 0) {
                return ele;
            }

            nums[ele] = -nums[ele];
        }
        return -1; // In case no duplicate is found (which shouldn't happen given the problem
                   // constraints)
    }

    // Main method to test the function
    public static void main(String[] args) {
        D_41_Find_Duplicate_Number solution = new D_41_Find_Duplicate_Number();

        // Example test case
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println("Duplicate number: " + solution.findDuplicate(nums));
    }
}
