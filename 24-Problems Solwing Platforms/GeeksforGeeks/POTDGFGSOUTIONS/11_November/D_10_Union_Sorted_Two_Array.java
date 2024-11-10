import java.util.ArrayList;
import java.util.HashSet;

public class D_10_Union_Sorted_Two_Array {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> union = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        // Add elements from the first array to the set
        for (int num : a) {
            set.add(num);
        }

        // Add elements from the second array to the set
        for (int num : b) {
            set.add(num);
        }

        // Convert the set to an ArrayList and sort it
        union.addAll(set);
        union.sort(null);

        return union;
    }

    public static void main(String[] args) {
        // Sample arrays
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 6, 7};

        // Find the union
        ArrayList<Integer> result = findUnion(arr1, arr2);

        // Print the union
        System.out.println("Union of the arrays:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}