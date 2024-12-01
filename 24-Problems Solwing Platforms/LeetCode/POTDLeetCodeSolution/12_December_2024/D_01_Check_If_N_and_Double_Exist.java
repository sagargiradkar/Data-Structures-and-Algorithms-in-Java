import java.util.HashSet;

public class D_01_Check_If_N_and_Double_Exist {
    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 2, 5, 3};
        int[] arr2 = {7, 1, 14, 11};
        int[] arr3 = {3, 1, 7, 11};

        System.out.println(checkIfExist(arr1)); // Output: true
        System.out.println(checkIfExist(arr2)); // Output: true
        System.out.println(checkIfExist(arr3)); // Output: false
    }
}
