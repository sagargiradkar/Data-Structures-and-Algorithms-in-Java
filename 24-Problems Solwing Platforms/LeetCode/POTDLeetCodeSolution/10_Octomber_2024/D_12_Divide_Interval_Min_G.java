
public class D_12_Divide_Interval_Min_G {

    // Method to find the minimum number of groups of intervals without overlap
    public int minGroups(int[][] intervals) {
        // Find the range of intervals
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = intervals.length;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }

        // Create event count array
        int eventCount[] = new int[max + 2];

        // Increment and decrement for interval starts and ends
        for (int i = 0; i < n; i++) {
            eventCount[intervals[i][0]]++;
            eventCount[intervals[i][1] + 1]--;
        }

        // Calculate maximum overlaps
        int maxOverlaps = 0;
        int sum = 0;
        for (int i = min; i < max + 2; i++) {
            sum += eventCount[i];
            maxOverlaps = Math.max(maxOverlaps, sum);
        }

        return maxOverlaps;
    }

    // Main method
    public static void main(String[] args) {
        D_12_Divide_Interval_Min_G solution = new D_12_Divide_Interval_Min_G();

        // Test case 1
        int[][] intervals1 = { { 1, 3 }, { 2, 4 }, { 3, 5 } };
        System.out.println("Minimum number of groups (Test 1): " + solution.minGroups(intervals1)); // Output: 2

        // Test case 2
        int[][] intervals2 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        System.out.println("Minimum number of groups (Test 2): " + solution.minGroups(intervals2)); // Output: 1

        // Test case 3
        int[][] intervals3 = { { 1, 10 }, { 2, 6 }, { 8, 10 }, { 10, 12 } };
        System.out.println("Minimum number of groups (Test 3): " + solution.minGroups(intervals3)); // Output: 3
    }
}
