
import java.util.HashMap;

public class HM_15_Largest_SubArray_0_Sum {

    public static void main(String[] args) {
        int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            // If the sum is 0, update len (consider subarray from 0 to j)
            if (sum == 0) {
                len = j + 1;
            }

            // If the sum has been seen before, check the length of the subarray
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                // Store the first occurrence of the sum
                map.put(sum, j);
            }
        }

        System.out.println("Largest Subarray with sum 0 => " + len);
    }
}
