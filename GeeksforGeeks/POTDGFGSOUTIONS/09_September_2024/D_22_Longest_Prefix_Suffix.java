import java.util.Scanner;

public class D_22_Longest_Prefix_Suffix {

    // Method to calculate the Longest Prefix Suffix (LPS)
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

    // Main method
    public static void main(String[] args) {
        // Create an instance of the class
        D_22_Longest_Prefix_Suffix obj = new D_22_Longest_Prefix_Suffix();
        
        // Take input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = scanner.nextLine();
        
        // Calculate and print the LPS
        int result = obj.lps(str);
        System.out.println("The length of the longest prefix which is also a suffix: " + result);
    }
}