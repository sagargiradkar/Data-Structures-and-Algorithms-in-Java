import java.util.Scanner;

public class D_05_MissingArray {
    
    // User function Template for Java
    static class Solution {

        // Note that the size of the array is n-1
        int missingNumber(int n, int arr[]) {
            // Calculate the sum of the first n natural numbers
            int totalSum = n * (n + 1) / 2;

            // Calculate the sum of elements in the array
            int arraySum = 0;
            for (int num : arr) {
                arraySum += num;
            }

            // The missing number is the difference between totalSum and arraySum
            return totalSum - arraySum;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input size n
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        
        // Input array of size n-1
        int[] arr = new int[n-1];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n-1; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Create Solution object and find the missing number
        Solution sol = new Solution();
        int missing = sol.missingNumber(n, arr);
        
        // Output the missing number
        System.out.println("The missing number is: " + missing);
        
        sc.close();
    }
}
