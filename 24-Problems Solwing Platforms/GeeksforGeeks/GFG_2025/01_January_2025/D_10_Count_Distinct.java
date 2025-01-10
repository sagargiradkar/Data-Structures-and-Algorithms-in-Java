// D_10_Count_Distinct.java
import java.util.ArrayList;
import java.util.HashMap;

public class D_10_Count_Distinct {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {1, 2, 1, 3, 4, 2, 3};
        int k = 4;

        ArrayList<Integer> result = solution.countDistinct(arr, k);
        System.out.println("Distinct elements in each window: " + result);
    }
}

class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // Result list to store the count of distinct elements in each window
        ArrayList<Integer> result = new ArrayList<>();
        
        // HashMap to store the frequency of elements in the current window
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Initialize the first window
        for (int i = 0; i < k; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }
        // Add the count of distinct elements in the first window
        result.add(frequencyMap.size());
        
        // Slide the window across the array
        for (int i = k; i < arr.length; i++) {
            // Remove the frequency of the element that goes out of the window
            int outgoingElement = arr[i - k];
            frequencyMap.put(outgoingElement, frequencyMap.get(outgoingElement) - 1);
            if (frequencyMap.get(outgoingElement) == 0) {
                frequencyMap.remove(outgoingElement);
            }
            
            // Add the frequency of the new element in the window
            int incomingElement = arr[i];
            frequencyMap.put(incomingElement, frequencyMap.getOrDefault(incomingElement, 0) + 1);
            
            // Add the count of distinct elements in the current window
            result.add(frequencyMap.size());
        }
        
        return result;
    }
}
