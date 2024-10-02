import java.util.HashMap;
import java.util.TreeSet;

public class D_02_Array_Rank_Transform {

    // Solution class containing the array rank transform logic
    static class Solution {
        public int[] arrayRankTransform(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            TreeSet<Integer> set = new TreeSet<>();
            
            // Add elements to a TreeSet to get sorted unique elements
            for (int element : arr) {
                set.add(element);
            }
            
            int rank = 1; // Rank starts from 1
            
            // Assign rank to each unique element
            for (int num : set) {
                map.put(num, rank);
                rank++;
            }
            
            // Replace each element in the original array with its rank
            for (int i = 0; i < arr.length; i++) {
                arr[i] = map.get(arr[i]);
            }
            
            return arr; // Return the ranked array
        }
    }

    // Main method to test the array rank transform
    public static void main(String[] args) {
        int[] arr = {40, 10, 20, 40, 30, 10};  // Input array
        
        Solution solution = new Solution();  // Create an instance of the Solution class
        int[] result = solution.arrayRankTransform(arr);  // Apply the array rank transform
        
        // Print the transformed array
        System.out.print("Rank Transformed Array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
