// Filename: D_28_Find_Triplets.java
import java.util.ArrayList;
import java.util.List;

public class D_28_Find_Triplets {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {0, -1, 2, -3, 1}; // Example input
        List<List<Integer>> result = solution.findTriplets(arr);
        System.out.println("Triplets with zero sum:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }
    }
}

// User function Template for Java
class Solution {
    public static List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;

        // Brute-force approach to find triplets with a zero sum
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            for (int j = i + 1; j < n; j++) {
                int b = arr[j];
                for (int k = j + 1; k < n; k++) {
                    int c = arr[k];
                    if (a + b + c == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(a);
                        triplet.add(b);
                        triplet.add(c);
                        ans.add(triplet);
                    }
                }
            }
        }
        return ans;
    }
}
