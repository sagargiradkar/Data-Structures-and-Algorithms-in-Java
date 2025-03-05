import java.util.*;

public class D_02_Subarray_Bitwise_Array {

    public static int distnctBitwiseOR(int[] arr) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> prevValue = new HashSet<>();

        for (int n : arr) {
            Set<Integer> currentValue = new HashSet<>();
            currentValue.add(n);
            for (int x : prevValue)
                currentValue.add(x | n);
            prevValue = currentValue;

            result.addAll(prevValue);

        }
        return result.size();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4 };
        System.out.println(distnctBitwiseOR(arr));
    }
}
