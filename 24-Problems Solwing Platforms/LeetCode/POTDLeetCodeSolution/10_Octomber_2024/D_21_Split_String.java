import java.util.HashSet;
import java.util.Scanner;

public class D_21_Split_String {

    public int maxUniqueSplit(String s) {
        // Call the helper method to find the maximum split
        return backtrack(s, new HashSet<>(), 0);
    }

    private int backtrack(String s, HashSet<String> used, int start) {
        // Base case: if we reach the end of the string
        if (start == s.length()) {
            return 0;
        }

        int maxSplits = 0;

        // Try every possible substring starting from 'start' to the end
        for (int end = start + 1; end <= s.length(); end++) {
            String current = s.substring(start, end);

            // If the substring is not already used, proceed
            if (!used.contains(current)) {
                // Mark the substring as used
                used.add(current);

                // Recursively explore the rest of the string and count the splits
                int splits = 1 + backtrack(s, used, end);

                // Update the maximum number of splits found
                maxSplits = Math.max(maxSplits, splits);

                // Backtrack: remove the substring from the used set
                used.remove(current);
            }
        }

        return maxSplits;
    }

    // Main method to take input and run the solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input string
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        // Create instance of the class
        D_21_Split_String solution = new D_21_Split_String();

        // Get the result by calling the maxUniqueSplit method
        int result = solution.maxUniqueSplit(s);

        // Print the result
        System.out.println("Maximum number of unique splits: " + result);

        sc.close();
    }
}
