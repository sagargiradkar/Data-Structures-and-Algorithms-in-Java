import java.io.*;
import java.util.*;

class D_02_Check_Duplicate_With_K {
    public static boolean checkDuplicatesWithinK(int[] arr, int k) {
        // HashSet to store the elements in the current window of size k
        Set<Integer> set = new HashSet<>();

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Check if arr[i] is already in the set
            if (set.contains(arr[i])) {
                return true; // Found a duplicate within k distance
            }

            // Add arr[i] to the set
            set.add(arr[i]);

            // If the set size exceeds k, remove the element at i - k position
            if (i >= k) {
                set.remove(arr[i - k]);
            }
        }

        // No duplicates found within k distance
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of test cases: ");
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            System.out.print("Enter elements of array separated by space: ");
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Convert input to an integer array
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            System.out.print("Enter value of k: ");
            int k = Integer.parseInt(br.readLine());

            // Call the function and print the result
            boolean result = checkDuplicatesWithinK(arr, k);
            System.out.println(result ? "true" : "false");
            System.out.println("~");
        }
    }
}