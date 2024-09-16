public class D_17_Container_With_Most_Water {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // Example input
        Solution solution = new Solution();
        int maxWater = solution.maxArea(height);
        System.out.println("The maximum area of water that can be contained is: " + maxWater);
    }
}

class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            // Calculate the current area
            int width = right - left;
            int ht = Math.min(height[left], height[right]);
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}
