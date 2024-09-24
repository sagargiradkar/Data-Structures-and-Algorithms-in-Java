import java.util.Scanner;

public class D_23_Longest_Prefix {

    public static void main(String[] args) {
        // Input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Create an instance of Solution and call the lps method
        Solution solution = new Solution();
        int result = solution.lps(str);

        // Output the result
        System.out.println("Length of the longest proper prefix which is also a suffix: " + result);
    }
}

// User function template for Java
class Solution {

    int lps(String str) {
        // Find the length of the string
        int n = str.length();
        
        // Create an array to hold the LPS values
        int lps[] = new int[n];  // Longest prefix suffix array
        
        // Initialize variables
        int length = 0;  // Length of the previous longest prefix suffix
        int i = 1;  // Start from the second character
        
        // The first character's LPS is always 0
        lps[0] = 0;

        // Process the string to calculate LPS values
        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
                // Characters match, extend the prefix suffix
                length++;
                lps[i] = length;
                i++;
            } else {
                // Characters do not match
                if (length != 0) {
                    // Try the previous LPS value
                    length = lps[length - 1];
                } else {
                    // No proper prefix found, set LPS to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // Return the last value in the LPS array
        return lps[n - 1];
    }
}
