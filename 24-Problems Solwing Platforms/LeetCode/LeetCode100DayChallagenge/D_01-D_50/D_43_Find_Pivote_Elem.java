public class D_43_Find_Pivote_Elem {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivotIndex = solution.pivotIndex(nums);
        
        System.out.println("The pivot index is: " + pivotIndex);
    }
}

class Solution {
    public int pivotIndex(int[] nums) {
        int rsum = 0;

        for (int ele : nums) {
            rsum += ele;
        }

        int lsum = 0;

        for (int i = 0; i < nums.length; i++) {
            rsum -= nums[i];

            if (rsum == lsum) {
                return i;
            }

            lsum += nums[i];
        }

        return -1;
    }
}
