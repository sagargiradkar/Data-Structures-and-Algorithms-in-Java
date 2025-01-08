// D_07_Count_Triangles.java
import java.util.*;

public class D_08_Count_Triangles {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {4, 6, 3, 7};
        int result = solution.countTriangles(arr);
        System.out.println("Number of possible triangles: " + result);
    }
}

// User function Template for Java
class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        int n = arr.length;
        int count = 0;
        
        // Sort the array to easily apply the triangle inequality
        Arrays.sort(arr);
        
        // Traverse the array from the third element to the end
        for (int k = 2; k < n; k++) {
            int i = 0, j = k - 1;
            
            // Use two pointers to count valid pairs (i, j) such that arr[i] + arr[j] > arr[k]
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    // If arr[i] + arr[j] > arr[k], then all pairs (i, i+1, ..., j-1) with j are valid
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        
        return count;
    }
}
