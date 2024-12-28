import java.util.*;

public class D_28_Find_Triplets {
    static class Solution {
        public List<List<Integer>> findTriplets(int[] arr) {
            int n = arr.length;
            List<List<Integer>> ans = new ArrayList<>();
            HashMap<Integer, ArrayList<Integer>> mm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                mm.putIfAbsent(arr[i], new ArrayList<>());
                mm.get(arr[i]).add(i);
            }
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    int rem = 0 - (arr[i] + arr[j]);
                    if (mm.get(rem) != null) {
                        int size = mm.get(rem).size();
                        for (int k = size - 1; k >= 0; k--) {
                            if (mm.get(rem).get(k) <= j) break;
                            ans.add(new ArrayList<>(List.of(i, j, mm.get(rem).get(k))));
                        }
                    }
                }
            }
            Collections.sort(ans, (o1, o2) -> o1.get(2).compareTo(o2.get(2)));
            return ans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Solution();
        List<List<Integer>> triplets = solution.findTriplets(arr);

        // Output triplets
        System.out.println("Triplets with indices:");
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        scanner.close();
    }
}
