
public class D_30_Trapping_Rainwater {
    public static void main(String[] args) {
        // Example array for height of bars
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        // Create an instance of Solution
        Solution sol = new Solution();

        // Calculate the amount of trapped water
        int result = sol.trap(height);

        // Print the result
        System.out.println("Trapped Water: " + result);  // Expected output: 6
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0; // Edge case for empty array

        // Calculate left max boundary - array
        int leftMax[] = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {  // Start from 1 instead of 0
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // Calculate right max boundary - array
        int rightMax[] = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int trappedWater = 0;
        // Loop through the array to calculate trapped water
        for (int i = 0; i < n; i++) {
            // Water level = min(leftMax boundary, rightMax boundary)
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // Trapped water = waterLevel - height[i]
            trappedWater += waterLevel - height[i];
        }
        return trappedWater;
    }
}
