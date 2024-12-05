
public class D_05_Can_Change {

    // Function to determine if the transformation is possible
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            // Skip underscores in the start string
            while (i < n && start.charAt(i) == '_') {
                i++;
            }

            // Skip underscores in the target string
            while (j < n && target.charAt(j) == '_') {
                j++;
            }

            // Check if both pointers have reached the end
            if (i == n || j == n) {
                return i == n && j == n;
            }

            // If the characters at i and j are different, transformation is not possible
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            // Check for invalid moves
            if (start.charAt(i) == 'L' && i < j) {
                return false;  // 'L' can't move to the right
            }
            if (start.charAt(i) == 'R' && i > j) {
                return false;  // 'R' can't move to the left
            }

            // Move both pointers forward
            i++;
            j++;
        }

        return true;
    }

    // Main method to test the function
    public static void main(String[] args) {
        D_05_Can_Change solution = new D_05_Can_Change();

        String start1 = "_L__R__R_";
        String target1 = "L______RR";
        System.out.println(solution.canChange(start1, target1)); // true

        String start2 = "R_L_";
        String target2 = "__LR";
        System.out.println(solution.canChange(start2, target2)); // false

        String start3 = "_R";
        String target3 = "R_";
        System.out.println(solution.canChange(start3, target3)); // false
    }
}
