public class D_19_Max_Chunks_To_Sorted {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int[] arr = {4, 3, 2, 1, 0};

        // Call the function and display the result
        int result = solution.maxChunksToSorted(arr);
        System.out.println("Maximum chunks that can be sorted: " + result);
    }
}

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int maxSoFar = Integer.MIN_VALUE;
        
        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            
            // If the max element so far equals the current index, it's a chunk
            if (maxSoFar == i) {
                chunks++;
            }
        }
        
        return chunks;
    }
}
