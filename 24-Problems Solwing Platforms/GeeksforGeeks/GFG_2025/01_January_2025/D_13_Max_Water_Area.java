// D_13_Max_Water_Area.java
public class D_13_Max_Water_Area {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum water area for arr1: " + solution.maxWater(arr1)); // Expected: 49

        int[] arr2 = {1, 1};
        System.out.println("Maximum water area for arr2: " + solution.maxWater(arr2)); // Expected: 1

        int[] arr3 = {4, 3, 2, 1, 4};
        System.out.println("Maximum water area for arr3: " + solution.maxWater(arr3)); // Expected: 16

        int[] arr4 = {1, 2, 1};
        System.out.println("Maximum water area for arr4: " + solution.maxWater(arr4)); // Expected: 2
    }
}

class Solution {
    public int maxWater(int[] arr) {
        int left = 0; // Start pointer
        int right = arr.length - 1; // End pointer
        int maxArea = 0; // To store the maximum water area

        // Loop until the two pointers meet
        while (left < right) {
            // Calculate the area
            int height = Math.min(arr[left], arr[right]);
            int width = right - left;
            int currentArea = height * width;
            
            // Update maximum area
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter height
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
