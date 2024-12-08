// D_08_Merge_Overlap.java
import java.util.*;

public class D_08_Merge_Overlap {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        List<int[]> result = mergeOverlap(arr);
        System.out.println("Merged Intervals: ");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static List<int[]> mergeOverlap(int[][] arr) {
        List<int[]> mergedIntervals = new ArrayList<>();

        // Sort intervals by their start times
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize with the first interval
        int[] currentInterval = arr[0];
        mergedIntervals.add(currentInterval);

        for (int i = 1; i < arr.length; i++) {
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = arr[i][0];
            int nextEnd = arr[i][1];

            if (nextStart <= currentEnd) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap, add the new interval
                currentInterval = arr[i];
                mergedIntervals.add(currentInterval);
            }
        }

        return mergedIntervals;
    }
}
