import java.util.Arrays;

public class D_18_Defuse_Bomb {
    public static void main(String[] args) {
        // Sample test case
        int[] code = {5, 7, 1, 4};
        int k = 3;

        // Create an instance of the Solution class and call the decrypt method
        Solution solution = new Solution();
        int[] decryptedCode = solution.decrypt(code, k);

        // Print the result
        System.out.println("Decrypted code: " + Arrays.toString(decryptedCode));
    }
}

class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result; // {0, 0, 0, ...}
        }

        int i = -1, j = -1;
        if (k > 0) {
            i = 1;
            j = k;
        } else {
            i = n - Math.abs(k);
            j = n - 1;
        }

        int windowSum = 0;
        for (int pointer = i; pointer <= j; pointer++) {
            windowSum += code[pointer % n];
        }

        for (int x = 0; x < n; x++) { // result[x]
            result[x] = windowSum;

            windowSum -= code[i % n];
            i++;

            windowSum += code[(j + 1) % n];
            j++;
        }

        return result;
    }
}
