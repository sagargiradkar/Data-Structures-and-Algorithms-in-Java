import java.util.HashMap;
import java.util.Map;

public class D_30_MaxDiff_Pair {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int k = 2;
        int result = findMaxDiffPair(arr, k);
        System.out.println("The result is: " + result);
    }

    public static int findMaxDiffPair(int[] arr, int k) {
        int ans = 0;
        Map<Integer, Integer> mm = new HashMap<>();
        
        for (int x : arr) {
            mm.put(x, mm.getOrDefault(x, 0) + 1);
        }
        
        for (int x : arr) {
            ans += mm.getOrDefault(x + k, 0);
        }
        
        return ans;
    }
}