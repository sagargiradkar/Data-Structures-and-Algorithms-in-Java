import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D_04_All_Triplets_With_Zero {

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
                        triplet.add(i);
                        triplet.add(j);
                        triplet.add(k);
                        ans.add(triplet);
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read input array
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Find all triplets with zero sum
        List<List<Integer>> result = findTriplets(arr);

        // Print the result
        System.out.println("Triplets with zero sum:");
        for (List<Integer> triplet : result) {
            System.out.println(triplet);
        }

        scanner.close();
    }
}
