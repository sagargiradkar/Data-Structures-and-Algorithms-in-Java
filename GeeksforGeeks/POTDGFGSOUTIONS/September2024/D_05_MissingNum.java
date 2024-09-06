import java.io.*;

class D_05_MissingNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());  // Number of test cases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());  // Size of the array + 1 (i.e., n)
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}

class Solution {

    // Method to find the missing number
    int missingNumber(int n, int arr[]) {
        // Calculate the sum of the first n natural numbers
        int totalSum = n * (n + 1) / 2;

        // Calculate the sum of elements in the array
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        // The missing number difference between totalSum and arraySum
        return totalSum - arraySum;
    }
}