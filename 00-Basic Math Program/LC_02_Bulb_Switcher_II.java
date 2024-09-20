public class LC_02_Bulb_Switcher_II {
    public static void main(String[] args) {
        // Example test cases
        int n1 = 1;
        int presses1 = 1;

        int n2 = 2;
        int presses2 = 1;

        int n3 = 3;
        int presses3 = 1;

        Solution solution = new Solution();

        System.out.println("Test case 1: n = " + n1 + ", presses = " + presses1);
        System.out.println("Possible configurations: " + solution.flipLights(n1, presses1)); // Expected output: 2

        System.out.println("Test case 2: n = " + n2 + ", presses = " + presses2);
        System.out.println("Possible configurations: " + solution.flipLights(n2, presses2)); // Expected output: 3

        System.out.println("Test case 3: n = " + n3 + ", presses = " + presses3);
        System.out.println("Possible configurations: " + solution.flipLights(n3, presses3)); // Expected output: 4
    }
}

class Solution {
    public int flipLights(int n, int presses) {
        // If no presses, the bulbs remain in the original state
        if (presses == 0) {
            return 1;
        }
        
        // If there is only one bulb
        if (n == 1) {
            return 2; // On or off
        }
        
        // If there are two bulbs
        if (n == 2) {
            return presses == 1 ? 3 : 4; // 3 configurations if 1 press, 4 if 2 or more presses
        }

        // If there are three or more bulbs
        if (n >= 3) {
            if (presses == 1) {
                return 4; // 4 configurations if 1 press
            } else if (presses == 2) {
                return 7; // 7 configurations if 2 presses
            } else {
                return 8; // 8 configurations if 3 or more presses
            }
        }

        return 1; // Default return in case no condition matches
    }
}
