/*
Problem Statement:
There are `n` bulbs, all initially turned on. You can perform `presses` number of operations. 
Each operation consists of pressing one of the following four buttons:
1. Toggle all bulbs.
2. Toggle bulbs at even positions.
3. Toggle bulbs at odd positions.
4. Toggle bulbs at positions (1, 4, 7, 10, ...).
Return the number of different possible configurations of bulbs after performing `presses` operations.

Time Complexity Analysis:
- The function runs in O(1) time since the number of distinct bulb states depends only on `n` and `presses`.
- The space complexity is O(1) as we use only a few variables.

Test Cases:
Test case 1: n = 1, presses = 1 → Expected output: 2
Test case 2: n = 2, presses = 1 → Expected output: 3
Test case 3: n = 3, presses = 1 → Expected output: 4
Test case 4: n = 3, presses = 2 → Expected output: 7
Test case 5: n = 4, presses = 3 → Expected output: 8
*/

public class LC_02_Bulb_Switcher_II {
    public static void main(String[] args) {
        int n1 = 1, presses1 = 1;
        int n2 = 2, presses2 = 1;
        int n3 = 3, presses3 = 1;
        int n4 = 3, presses4 = 2;
        int n5 = 4, presses5 = 3;

        Solution solution = new Solution();

        System.out.println("Test case 1: n = " + n1 + ", presses = " + presses1);
        System.out.println("Possible configurations: " + solution.flipLights(n1, presses1)); // Expected output: 2

        System.out.println("Test case 2: n = " + n2 + ", presses = " + presses2);
        System.out.println("Possible configurations: " + solution.flipLights(n2, presses2)); // Expected output: 3

        System.out.println("Test case 3: n = " + n3 + ", presses = " + presses3);
        System.out.println("Possible configurations: " + solution.flipLights(n3, presses3)); // Expected output: 4

        System.out.println("Test case 4: n = " + n4 + ", presses = " + presses4);
        System.out.println("Possible configurations: " + solution.flipLights(n4, presses4)); // Expected output: 7

        System.out.println("Test case 5: n = " + n5 + ", presses = " + presses5);
        System.out.println("Possible configurations: " + solution.optimizedFlipLights(n5, presses5)); // Expected output: 8
    }
}

class Solution {
    // Your original method
    public int flipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return presses == 1 ? 3 : 4;
        if (n >= 3) {
            if (presses == 1) return 4;
            if (presses == 2) return 7;
            return 8;
        }
        return 1;
    }

    // Optimized version of the method
    public int optimizedFlipLights(int n, int presses) {
        if (presses == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return Math.min(4, presses * 2 + 1);
        return Math.min(8, presses * 3 + 1);
    }
}

/*
Optimized Code Explanation:
- Instead of multiple if-else conditions, we use `Math.min()` to cap the results at their maximum possible configurations.
- For `n == 2`, the configurations are at most 4.
- For `n >= 3`, the configurations are at most 8.
- This makes the function more concise and still provides correct results.
*/
