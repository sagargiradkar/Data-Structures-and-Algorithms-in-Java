import java.util.Arrays;

public class SDE_03_Zig_Zag_Fation {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
        int n = arr.length;

        // Call the zigZag function
        Solution.zigZag(n, arr);

        // Print the result
        System.out.println("Zig-Zag fashion array: " + Arrays.toString(arr));
    }
}

class Solution {
    public static void zigZag(int n, int[] arr) {
        // code here
        boolean flag = true;
        for (int i = 0; i < n - 1; i++) {
            if (flag) {
                if (arr[i + 1] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                flag = false;
            } else {
                if (arr[i + 1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                flag = true;
            }
        }
    }
}
