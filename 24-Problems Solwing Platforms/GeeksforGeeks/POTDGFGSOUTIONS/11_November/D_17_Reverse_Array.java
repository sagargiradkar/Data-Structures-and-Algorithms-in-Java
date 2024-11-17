import java.io.*;
import java.util.*;

public class D_17_Reverse_Array {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            // Parsing input into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution obj = new Solution();

            // Reversing the array
            obj.reverseArray(arr);

            // Printing the reversed array
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~"); // Separator for test cases
        }
    }
}

class Solution {
    public void reverseArray(int arr[]) {
        int start = 0, end = arr.length - 1;

        // Swap elements from start and end moving towards the center
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}