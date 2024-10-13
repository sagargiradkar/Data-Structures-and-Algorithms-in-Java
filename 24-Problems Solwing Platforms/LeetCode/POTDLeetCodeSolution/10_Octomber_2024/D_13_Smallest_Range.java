import java.util.*;

public class D_13_Smallest_Range {

    // Method to find the smallest range that includes at least one number from each
    // of the lists
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap to keep track of the smallest element in the current window
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0]; // Sort in increasing order of element values
            }
        });

        int k = nums.size(); // Number of lists
        int max = Integer.MIN_VALUE; // To keep track of the maximum element in the current window

        // Add the first element from each list to the heap
        for (int i = 0; i < k; i++) {
            int minVal = nums.get(i).get(0);
            pq.offer(new int[] { minVal, i, 0 }); // [element, listIndex, elementIndex]
            max = Math.max(max, minVal); // Update max to the highest first element
        }

        // Result to store the smallest range
        int[] minRange = { 0, Integer.MAX_VALUE };

        // Continue processing until one list is fully traversed
        while (true) {
            int[] top = pq.poll(); // Get the smallest element
            int minElement = top[0], listIndex = top[1], elementIndex = top[2];

            // Update the smallest range if the current window is smaller
            if (max - minElement < minRange[1] - minRange[0]) {
                minRange[0] = minElement;
                minRange[1] = max;
            }

            // If we've reached the end of one list, stop
            if (elementIndex == nums.get(listIndex).size() - 1)
                break;

            // Move to the next element in the same list
            int next = nums.get(listIndex).get(elementIndex + 1);
            max = Math.max(max, next); // Update max
            pq.offer(new int[] { next, listIndex, elementIndex + 1 });
        }

        return minRange;
    }

    // Main method
    public static void main(String[] args) {
        D_13_Smallest_Range solution = new D_13_Smallest_Range();

        // Test case 1
        List<List<Integer>> nums1 = new ArrayList<>();
        nums1.add(Arrays.asList(4, 10, 15, 24, 26));
        nums1.add(Arrays.asList(0, 9, 12, 20));
        nums1.add(Arrays.asList(5, 18, 22, 30));
        int[] result1 = solution.smallestRange(nums1);
        System.out.println("Smallest range (Test 1): [" + result1[0] + ", " + result1[1] + "]");

        // Test case 2
        List<List<Integer>> nums2 = new ArrayList<>();
        nums2.add(Arrays.asList(1, 2, 3));
        nums2.add(Arrays.asList(1, 2, 3));
        nums2.add(Arrays.asList(1, 2, 3));
        int[] result2 = solution.smallestRange(nums2);
        System.out.println("Smallest range (Test 2): [" + result2[0] + ", " + result2[1] + "]");
    }
}
