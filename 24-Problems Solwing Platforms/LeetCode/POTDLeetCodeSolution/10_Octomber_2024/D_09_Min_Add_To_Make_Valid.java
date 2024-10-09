import java.util.Scanner;

public class D_09_Min_Add_To_Make_Valid {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading number of test cases
        int t = Integer.parseInt(scanner.nextLine().trim());

        while (t-- > 0) {
            // Read input string
            String s = scanner.nextLine().trim();

            // Create an instance of the solution class
            Solution obj = new Solution();
            // Call the minAddToMakeValid method and print the result
            int result = obj.minAddToMakeValid(s);
            System.out.println(result);
        }

        scanner.close();
    }
}

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                open++;
            } else {
                if (open <= 0) {
                    close++;
                } else {
                    open--;
                }
            }
        }

        return open + close;
    }
}
