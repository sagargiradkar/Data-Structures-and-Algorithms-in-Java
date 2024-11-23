import java.util.Scanner;

class Solution {
    public boolean rotateString(String s, String goal) {
        // Check if lengths are equal; if not, rotation is impossible
        if (s.length() != goal.length()) {
            return false;
        }

        // Concatenate s with itself
        String doubleS = s + s;

        // Check if goal is a substring of the concatenated string
        return doubleS.contains(goal);
    }
}

public class D_03_Rotate_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string s: ");
        String s = scanner.nextLine();

        System.out.print("Enter the string goal: ");
        String goal = scanner.nextLine();

        Solution solution = new Solution();
        boolean result = solution.rotateString(s, goal);

        System.out.println("Can \"" + s + "\" be rotated to become \"" + goal + "\"? " + result);
        
        scanner.close();
    }
}
