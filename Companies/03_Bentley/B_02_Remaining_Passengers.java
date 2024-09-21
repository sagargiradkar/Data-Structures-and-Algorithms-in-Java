import java.util.Arrays;

class B_02_Remaining_Passengers {
    public int solution(int[] P, int[] S) {
        int N = P.length;
        
        // Step 1: Calculate total passengers and total seats
        int totalPassengers = 0;
        for (int i = 0; i < N; i++) {
            totalPassengers += P[i];
        }
        
        // Step 2: Sort cars by available seats in descending order (most capacity first)
        // Calculate free space (S[i] - P[i]) for each car, to maximize redistribution
        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) {
            indices[i] = i;
        }
        
        // Sort based on free seats in descending order
        Arrays.sort(indices, (a, b) -> Integer.compare(S[b] - P[b], S[a] - P[a]));
        
        // Step 3: Try to minimize the number of cars
        int usedCars = 0;
        int remainingPassengers = totalPassengers;
        
        // Step 4: Fill cars starting from the ones with the most capacity
        for (int i = 0; i < N && remainingPassengers > 0; i++) {
            int idx = indices[i];
            if (remainingPassengers <= S[idx]) {
                usedCars++;
                break;  // All passengers can fit in this car
            }
            remainingPassengers -= S[idx];
            usedCars++;
        }
        
        return usedCars;
    }
    
    public static void main(String[] args) {
        B_02_Remaining_Passengers solution = new B_02_Remaining_Passengers();
        
        // Test Case 1
        int[] P1 = {1, 4, 1};
        int[] S1 = {1, 5, 1};
        System.out.println("Test Case 1: " + solution.solution(P1, S1));  // Expected output: 2

        // Test Case 2
        int[] P2 = {4, 4, 2};
        int[] S2 = {5, 5, 3};
        System.out.println("Test Case 2: " + solution.solution(P2, S2));  // Expected output: 2

        // Test Case 3
        int[] P3 = {2, 3, 4};
        int[] S3 = {2, 5, 5};
        System.out.println("Test Case 3: " + solution.solution(P3, S3));  // Expected output: 2

        // Test Case 4
        int[] P4 = {3, 2, 3};
        int[] S4 = {4, 3, 3};
        System.out.println("Test Case 4: " + solution.solution(P4, S4));  // Expected output: 2

        // Test Case 5
        int[] P5 = {5, 5, 1, 1};
        int[] S5 = {6, 6, 2, 2};
        System.out.println("Test Case 5: " + solution.solution(P5, S5));  // Expected output: 3
    }
}
