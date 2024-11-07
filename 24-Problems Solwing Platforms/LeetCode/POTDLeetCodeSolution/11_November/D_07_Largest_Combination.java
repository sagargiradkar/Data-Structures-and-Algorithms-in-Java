public class D_07_Largest_Combination {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case
        int[] candidates = {16, 17, 71, 62, 12, 24, 14};
        int result = solution.largestCombination(candidates);
        
        System.out.println("The largest combination size is: " + result);
    }
}

class Solution {
    public int largestCombination(int[] candidates) {
        int result = 0;

        for (int i = 0; i < 24; i++) { // O(24)
            int countIth = 0;

            for (int num : candidates) { // O(n)
                if ((num & (1 << i)) != 0) {
                    countIth++;
                }
            }

            result = Math.max(result, countIth);
        }

        return result;
    }
}