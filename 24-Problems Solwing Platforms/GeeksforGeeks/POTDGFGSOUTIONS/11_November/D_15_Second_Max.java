class D_15_Second_Max {
    public static void main(String[] args) {
        // Test the getSecondLargest method
        Solution solution = new Solution();
        int[] arr = {10, 20, 4, 45, 99, 45, 99}; // Sample input array
        int result = solution.getSecondLargest(arr);
        
        if (result != -1) {
            System.out.println("The second largest element is: " + result);
        } else {
            System.out.println("No second largest element found.");
        }
    }
}

class Solution {
    public int getSecondLargest(int[] arr) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2 && x != max1) {
                max2 = x;
            }
        }
        return max2 != Integer.MIN_VALUE ? max2 : -1;
    }
}
