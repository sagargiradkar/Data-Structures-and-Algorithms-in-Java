import java.util.Arrays;

public class D_10_Non_Overlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println("Minimum removals: " + minRemoval(intervals));
    }

    static int minRemoval(int[][] intervals) {
        // Sort intervals based on their end times
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        // Iterate through the intervals
        for (int[] interval : intervals) {
            // If the current interval overlaps with the last selected interval
            if (interval[0] < lastEnd) {
                count++;  // We need to remove this interval
            } else {
                lastEnd = interval[1];  // Update lastEnd to the current interval's end
            }
        }

        return count;
    }
}
