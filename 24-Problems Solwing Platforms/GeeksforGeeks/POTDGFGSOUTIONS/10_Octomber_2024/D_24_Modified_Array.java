import java.util.ArrayList;
import java.util.Arrays;

public class D_24_Modified_Array {
    
    public static ArrayList<Integer> modifyArray(int[] arr) {
        int n = arr.length;
        
        // Step 1: Combine consecutive duplicates
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1] && arr[i] != 0) {
                arr[i] *= 2;
                arr[i + 1] = 0;
                i++;
            }
        }
        
        // Step 2: Shift non-zero elements to the front
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        
        // Step 3: Store result in ArrayList
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            ans.add(x);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        // Sample array for testing
        int[] arr = {2, 2, 0, 4, 4, 8};
        
        // Call the modifyArray method
        ArrayList<Integer> result = modifyArray(arr);
        
        // Print the result
        System.out.println("Modified array: " + result);
    }
}