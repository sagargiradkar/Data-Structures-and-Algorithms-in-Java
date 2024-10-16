
import java.util.*;

public class D_16_Two_Swap {

    // Method to check if the array can be sorted by at most two swaps
    public boolean checkSorted(List<Integer> arr) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != i + 1) {
                int temp = arr.get(i);
                arr.set(i, arr.get(arr.get(i) - 1));
                arr.set(temp - 1, temp);
                i--;
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return count == 2 || count == 0;
    }

    public static void main(String[] args) {
        D_16_Two_Swap obj = new D_16_Two_Swap();

        // Test case 1
        List<Integer> arr1 = Arrays.asList(1, 3, 2, 4);
        System.out.println("Test case 1: " + obj.checkSorted(arr1)); // Expected: true (can be sorted with one swap)

        // Test case 2
        List<Integer> arr2 = Arrays.asList(1, 5, 3, 4, 2);
        System.out.println("Test case 2: " + obj.checkSorted(arr2)); // Expected: false (more than 2 swaps needed)

        // Test case 3
        List<Integer> arr3 = Arrays.asList(1, 2, 3, 4);
        System.out.println("Test case 3: " + obj.checkSorted(arr3)); // Expected: true (already sorted)

        // Test case 4
        List<Integer> arr4 = Arrays.asList(4, 3, 2, 1);
        System.out.println("Test case 4: " + obj.checkSorted(arr4)); // Expected: false (requires more than 2 swaps)
    }
}
