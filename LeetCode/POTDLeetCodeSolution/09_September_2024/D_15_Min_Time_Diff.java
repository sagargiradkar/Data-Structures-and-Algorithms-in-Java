import java.util.*;

public class D_15_Min_Time_Diff {

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("23:59", "00:00", "12:30", "08:45");
        Solution solution = new Solution();
        int minDifference = solution.findMinDifference(timePoints);
        System.out.println("The minimum time difference is: " + minDifference + " minutes.");
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];

        for (int i = 0; i < n; i++) {
            String time = timePoints.get(i);
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int mins = Integer.parseInt(parts[1]);

            minutes[i] = hours * 60 + mins;
        }

        Arrays.sort(minutes);
        int result = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            result = Math.min(result, minutes[i] - minutes[i - 1]);
        }

        result = Math.min(result, (24 * 60 - minutes[n - 1]) + minutes[0]);
        return result;
    }
}
