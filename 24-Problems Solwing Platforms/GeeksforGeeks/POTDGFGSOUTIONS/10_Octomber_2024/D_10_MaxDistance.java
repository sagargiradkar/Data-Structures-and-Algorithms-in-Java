import java.util.HashMap;

public class D_10_MaxDistance {
    public int maxDistance(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0;

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) { // element exists
                maxi = Math.max(maxi, i - map.get(arr[i]));
            } else { // element does not exist
                map.put(arr[i], i);
            }
        }

        return maxi;
    }

    public static void main(String[] args) {
        D_10_MaxDistance solution = new D_10_MaxDistance();
        int[] arr = {1, 2, 3, 1, 2, 3};
        
        int result = solution.maxDistance(arr);
        System.out.println("The maximum distance between two same elements is: " + result);
    }
}