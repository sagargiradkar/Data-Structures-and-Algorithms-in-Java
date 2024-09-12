import java.io.*;
import java.lang.*;

public class SDE_05_Rearrange_Array_Alternately {
    public static void main(String[] args) throws IOException {
        // Using BufferedReader for faster input reading
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        // Test cases input
        int t = Integer.parseInt(read.readLine());
        
        while (t-- > 0) {
            // Reading size of the array
            int n = Integer.parseInt(read.readLine());
            long[] arr = new long[n];
            
            // Reading array elements as a string and splitting it
            String str[] = read.readLine().trim().split(" ");
            
            // Adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(str[i]);
            }
            
            // Creating an instance of the Solution class
            Solution ob = new Solution();
            
            // Calling rearrange function
            ob.rearrange(arr, n);
            StringBuffer sb = new StringBuffer();
            
            // Appending the rearranged elements to the StringBuffer and printing
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}

class Solution {
    // Function to rearrange the array elements alternately.
    public static void rearrange(long arr[], int n) {
        // Two pointers, one from start and one from end
        int j = 0;
        int k = n - 1;
        long key = arr[n - 1] + 1; // Key to hold values greater than arr[n-1]

        // Alternating arrangement using modulus and division
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] = (arr[k] % key) * key + arr[i];
                k--;
            } else {
                arr[i] = (arr[j] % key) * key + arr[i];
                j++;
            }
        }

        // Final division to get the desired rearranged array
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / key;
        }
    }
}
