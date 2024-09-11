
public class SDE_04_Missing_in_Array {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int n = 5;
        int[] arr = {1, 2, 3, 5};
        
        // Finding the missing number
        int missingNumber = solution.missingNumber(n, arr);
        int missingNumber1 = solution.missingNumber1(n, arr);
        
        // Printing the result
        System.out.println("The missing number is: " + missingNumber);
        System.out.println("The missing number is: " + missingNumber1);
    }
}

class Solution {
    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {
        // Calculate the expected sum of numbers from 1 to n
        int expectedSum = n * (n + 1) / 2;
        
        // Calculate the actual sum of elements in the array
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num;
        }
        
        // The missing number is the difference between the expected sum and actual sum
        return expectedSum - actualSum;
    }
    int missingNumber1(int n, int arr[]) {
        int a = 1;
        for(int i=2; i<=n; i++){
            a = a^i;
            
        }
        int b = arr[0];
        for(int i=1; i<arr.length; i++){
            b = b ^ arr[i];
        }
        return a^b;
     }
}
