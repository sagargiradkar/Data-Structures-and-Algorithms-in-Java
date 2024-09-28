class D_08_Minimum_Jump {
    static int minJumps(int[] arr) {
        int n = arr.length;
        
        // If the array has only one element or we are already at the end
        if (n <= 1) {
            return 0;
        }
        
        // If the first element is 0, we cannot move forward
        if (arr[0] == 0) {
            return -1;
        }
        
        // Initialize variables:
        int jumps = 1; // Number of jumps made
        int farthest = arr[0]; // The farthest we can reach in the current range
        int currentEnd = arr[0]; // The end of the current range
        
        for (int i = 1; i < n; i++) {
            // If we have reached the last element, return the number of jumps
            if (i == n - 1) {
                return jumps;
            }
            
            // Update the farthest we can reach
            farthest = Math.max(farthest, i + arr[i]);
            
            // If we reach the end of the current range
            if (i == currentEnd) {
                jumps++; // We need to make another jump
                
                // If the current farthest point is less than or equal to the current index,
                // we cannot move further, so return -1
                if (farthest <= i) {
                    return -1;
                }
                
                // Update the current range to the farthest we can reach
                currentEnd = farthest;
            }
        }
        
        // If we exit the loop, it means we cannot reach the end
        return -1;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum jumps needed: " + minJumps(arr1)); // Output: 3

        // Test case 2
        int[] arr2 = {1, 4, 3, 2, 6, 7};
        System.out.println("Minimum jumps needed: " + minJumps(arr2)); // Output: 2

        // Test case 3
        int[] arr3 = {0, 10, 20};
        System.out.println("Minimum jumps needed: " + minJumps(arr3)); // Output: -1
    }
}
