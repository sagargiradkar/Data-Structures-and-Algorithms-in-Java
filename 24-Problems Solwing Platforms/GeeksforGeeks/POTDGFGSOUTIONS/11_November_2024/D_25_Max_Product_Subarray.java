public class D_25_Max_Product_Subarray {
    public static void main(String[] args) {
        // Example input
        int[] arr = {2, 3, -2, 4};

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calling the maxProduct function
        int result = solution.maxProduct(arr);

        // Printing the result
        System.out.println("Maximum Product Subarray: " + result);
    }
}

class Solution {
    // Function to find the maximum product subarray
    int maxProduct(int[] arr) {
        // Base case: if the array is empty, return 0
        if (arr.length == 0) return 0;

        // Initialize variables
        int maxProduct = arr[0]; // Stores the maximum product found so far
        int currentMax = arr[0]; // Stores the maximum product ending at the current position
        int currentMin = arr[0]; // Stores the minimum product ending at the current position

        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            // If the current number is negative, swap currentMax and currentMin
            if (num < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }

            // Update currentMax and currentMin
            currentMax = Math.max(num, currentMax * num);
            currentMin = Math.min(num, currentMin * num);

            // Update maxProduct
            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }
}
