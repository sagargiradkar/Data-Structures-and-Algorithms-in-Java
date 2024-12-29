import java.util.*;

public class D_29_Intersection_With_Duplicates {
    static class Solution {
        public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
            // Use HashSet to store unique elements
            Set<Integer> setA = new HashSet<>();
            Set<Integer> result = new HashSet<>();

            // Add all elements of array a to setA
            for (int num : a) {
                setA.add(num);
            }

            // Check for common elements in array b
            for (int num : b) {
                if (setA.contains(num)) {
                    result.add(num); // Add common elements to the result set
                }
            }

            // Convert the result set to ArrayList
            return new ArrayList<>(result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for first array
        System.out.println("Enter the size of the first array:");
        int n = scanner.nextInt();
        int[] a = new int[n];
        System.out.println("Enter the elements of the first array:");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // Input for second array
        System.out.println("Enter the size of the second array:");
        int m = scanner.nextInt();
        int[] b = new int[m];
        System.out.println("Enter the elements of the second array:");
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        // Find intersection
        Solution solution = new Solution();
        ArrayList<Integer> intersection = solution.intersectionWithDuplicates(a, b);

        // Output result
        System.out.println("Intersection of the arrays with duplicates:");
        System.out.println(intersection);

        scanner.close();
    }
}
