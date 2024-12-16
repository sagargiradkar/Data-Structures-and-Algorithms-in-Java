import java.util.PriorityQueue;

public class D_16_Get_Final_State {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        // Priority queue to store pairs of (value, index) with a custom comparator
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int valueComparison = Integer.compare(a[0], b[0]);
            if (valueComparison == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return valueComparison;
        });

        // Initialize the heap with values and their indices
        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] { nums[i], i });
        }

        // Perform k iterations
        while (k-- > 0) {
            // Extract the smallest element
            int[] temp = heap.poll();
            int idx = temp[1];
            int number = temp[0];

            // Update the array and reinsert the updated value into the heap
            nums[idx] = number * multiplier;
            heap.offer(new int[] { nums[idx], idx });
        }

        return nums;
    }

    public static void main(String[] args) {
        D_16_Get_Final_State solution = new D_16_Get_Final_State();

        // Example inputs
        int[] nums = { 1, 2, 3, 4 };
        int k = 3;
        int multiplier = 2;

        // Get the final state of the array
        int[] result = solution.getFinalState(nums, k, multiplier);

        // Print the result
        System.out.println("Final state of the array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
