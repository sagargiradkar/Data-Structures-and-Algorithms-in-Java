
public class D_01_Check_If_Array_Pairs_Divisible_By_K {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample inputs
        int[] arr1 = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k1 = 5;
        System.out.println("Test 1: " + solution.canArrange(arr1, k1)); // Expected: true

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int k2 = 7;
        System.out.println("Test 2: " + solution.canArrange(arr2, k2)); // Expected: true

        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 5;
        System.out.println("Test 3: " + solution.canArrange(arr3, k3)); // Expected: false

        int[] arr4 = {-10, 10};
        int k4 = 2;
        System.out.println("Test 4: " + solution.canArrange(arr4, k4)); // Expected: true
    }
}

class Solution {

    public boolean canArrange(int[] arr, int k) {
        int map[] = new int[k];
        for (int element : arr) { //n
            int rem = ((element % k) + k) % k;
            map[rem]++;
        }
        if (map[0] % 2 != 0) {
            return false;
        }
        for (int rem = 1; rem <= k / 2; rem++) { //k/2
            int comp = k - rem;
            if (map[rem] != map[comp]) {
                return false;
            }
        }
        return true;
    }
}
