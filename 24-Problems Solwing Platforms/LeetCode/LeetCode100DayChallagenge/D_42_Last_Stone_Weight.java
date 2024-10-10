import java.util.Collections;
import java.util.PriorityQueue;

public class D_42_Last_Stone_Weight {

    // Method to calculate the last stone's weight
    public int lastStoneWeight(int[] stones) {
        // Create a max-heap using a priority queue with reversed order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Continue smashing stones until at most one stone is left
        while (maxHeap.size() > 1) {
            // Extract the two heaviest stones
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            // If the two stones have different weights, push the difference back into the
            // heap
            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2);
            }
        }

        // Return the weight of the last remaining stone, or 0 if none are left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test case: stones array
        int[] stones = { 2, 7, 4, 1, 8, 1 };

        // Create an instance of the class
        D_42_Last_Stone_Weight solution = new D_42_Last_Stone_Weight();

        // Call the lastStoneWeight method and print the result
        int result = solution.lastStoneWeight(stones);
        System.out.println("Last stone weight: " + result);
    }
}
