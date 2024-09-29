import java.util.Scanner;

public class D_29_Total_Count {
    
    static class Solution {
        int totalCount(int k, int[] arr) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / k;  // Add full chunks
                if (arr[i] % k != 0) {  // Add one more if there's a remainder
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input for array length and the divisor k
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // Array input
        int[] arr = new int[n];
        System.out.println("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Create a solution object
        Solution solution = new Solution();

        // Get the total count
        int result = solution.totalCount(k, arr);

        // Output the result
        System.out.println("Total count of chunks: " + result);
        
        sc.close();
    }
}
