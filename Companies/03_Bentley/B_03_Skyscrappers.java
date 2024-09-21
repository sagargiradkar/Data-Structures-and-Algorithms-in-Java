import java.util.Arrays;

public class B_03_Skyscrappers {
    public int[] solution(int[] A) {
        int N = A.length;
        // Array to store the result heights
        int[] result = new int[N];
        
        // Create an array of pairs (A[i], index) to track original positions
        int[][] skyscrapers = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            skyscrapers[i][0] = A[i];  // A[i] is the max height
            skyscrapers[i][1] = i;     // i is the original index
        }
        
        // Sort the skyscrapers array by max height A[i] (ascending)
        Arrays.sort(skyscrapers, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Start assigning heights from 1 up to the maximum possible
        for (int i = 0; i < N; i++) {
            // The height to assign is min(i + 1, A[sorted skyscraper])
            result[skyscrapers[i][1]] = Math.min(i + 1, skyscrapers[i][0]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        B_03_Skyscrappers skyscrapers = new B_03_Skyscrappers();
        
        // Test Case 1
        int[] A1 = {1, 2, 3};
        System.out.println("Test Case 1: " + Arrays.toString(skyscrapers.solution(A1))); // Expected Output: [1, 2, 3]

        // Test Case 2
        int[] A2 = {9, 4, 3, 7};
        System.out.println("Test Case 2: " + Arrays.toString(skyscrapers.solution(A2))); // Expected Output: [3, 2, 1, 4] or another valid solution

        // Test Case 3
        int[] A3 = {5, 5, 5, 5};
        System.out.println("Test Case 3: " + Arrays.toString(skyscrapers.solution(A3))); // Expected Output: [1, 2, 3, 4]

        // Test Case 4
        int[] A4 = {3, 1, 2};
        System.out.println("Test Case 4: " + Arrays.toString(skyscrapers.solution(A4))); // Expected Output: [3, 1, 2]

        // Test Case 5
        int[] A5 = {6, 3, 8, 2, 1, 7};
        System.out.println("Test Case 5: " + Arrays.toString(skyscrapers.solution(A5))); // Expected Output: [5, 3, 6, 2, 1, 4]
    }
}
