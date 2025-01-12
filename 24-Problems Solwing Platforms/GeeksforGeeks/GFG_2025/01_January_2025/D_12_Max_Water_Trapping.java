// D_12_Max_Water_Trapping.java
public class D_12_Max_Water_Trapping {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = solution.maxWater(heights);
        System.out.println("Maximum water that can be trapped: " + result);
    }
}

class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        if (n < 2) return 0; // No water can be trapped if there are less than 2 blocks

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    water += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    water += rightMax - arr[right];
                }
                right--;
            }
        }

        return water;
    }
}
