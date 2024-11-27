public class D_27_Missing_Number {
    public static void main(String[] args) {
        // Example input array
        int[] arr = {3, 4, -1, 1};

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calling the missingNumber function
        int result = solution.missingNumber(arr);

        // Printing the result
        System.out.println("The smallest missing positive number is: " + result);
    }
}

class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Partition the array: Place each positive number at its correct index
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            while (num > 0 && num <= n && arr[num - 1] != num) {
                swap(arr, i, num - 1);
                num = arr[i];
            }
        }

        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positive numbers are present, the missing number is n+1
        return n + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
