import java.util.PriorityQueue;

public class D_11_Min_Cost_Rope {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input array (lengths of ropes)
        long[] arr = {4, 3, 2, 6};
        
        // Calculating the minimum cost to connect the ropes
        long result = solution.minCost(arr);
        
        // Printing the result
        System.out.println("Minimum cost of connecting the ropes: " + result);
    }
}

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public long minCost(long[] arr) {
        long cost = 0;
        
        // Using a PriorityQueue of Long since the input array is of type long[]
        PriorityQueue<Long> q = new PriorityQueue<>();
        
        // Adding all elements from the array into the priority queue
        for (long value : arr) {
            q.add(value);
        }
        
        // Process the ropes until only one rope is left in the queue
        while (q.size() > 1) {
            long a = q.poll(); // Get and remove the smallest rope
            long b = q.poll(); // Get and remove the second smallest rope
            
            long newRope = a + b; // The cost of connecting the two ropes
            cost += newRope; // Add the cost to the total
            
            q.add(newRope); // Add the newly formed rope back into the queue
        }
        
        return cost; // Return the total cost
    }
}
