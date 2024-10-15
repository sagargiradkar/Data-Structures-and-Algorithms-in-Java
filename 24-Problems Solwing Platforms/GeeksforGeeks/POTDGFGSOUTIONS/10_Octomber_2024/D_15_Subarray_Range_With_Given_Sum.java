import java.util.HashMap;
import java.util.Scanner;

public class D_15_Subarray_Range_With_Given_Sum {
    
    // Function to count the number of subarrays which add to the given sum.
    static int subArraySum(int arr[], int tar) {
        // HashMap to store (cumulative sum, frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Initialize with cumulative sum 0 having frequency 1 (for subarrays starting at index 0)
        map.put(0, 1);
        
        int count = 0;
        int cumulativeSum = 0;
        
        for (int num : arr) {
            cumulativeSum += num;
            
            // Check if (cumulativeSum - target) exists in the map
            if (map.containsKey(cumulativeSum - tar)) {
                count += map.get(cumulativeSum - tar);
            }
            
            // Update the frequency of the current cumulative sum in the map
            map.put(cumulativeSum, map.getOrDefault(cumulativeSum, 0) + 1);
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Input target sum
        System.out.print("Enter the target sum: ");
        int tar = scanner.nextInt();
        
        // Call the subArraySum method and print the result
        int result = subArraySum(arr, tar);
        System.out.println("Number of subarrays with sum " + tar + " : " + result);
        
        scanner.close();
    }
}
