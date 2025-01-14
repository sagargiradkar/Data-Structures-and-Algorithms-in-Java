// D_14_Find_The_Prefix_Common_Array.java
import java.util.HashSet;

public class D_14_Find_The_Prefix_Common_Array {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] A1 = {1, 3, 2, 4};
        int[] B1 = {3, 1, 4, 2};
        printArray(solution.findThePrefixCommonArray(A1, B1)); // Expected: [0, 2, 2, 4]

        int[] A2 = {2, 4, 6, 8};
        int[] B2 = {8, 6, 4, 2};
        printArray(solution.findThePrefixCommonArray(A2, B2)); // Expected: [0, 0, 0, 4]

        int[] A3 = {1, 2, 3};
        int[] B3 = {1, 2, 3};
        printArray(solution.findThePrefixCommonArray(A3, B3)); // Expected: [1, 2, 3]
    }

    // Helper method to print an array
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        HashSet<Integer> seenInA = new HashSet<>();
        HashSet<Integer> seenInB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            seenInA.add(A[i]);
            seenInB.add(B[i]);

            // Count the common elements in both sets
            int commonCount = 0;
            for (int num : seenInA) {
                if (seenInB.contains(num)) {
                    commonCount++;
                }
            }

            C[i] = commonCount;
        }

        return C;
    }
}
