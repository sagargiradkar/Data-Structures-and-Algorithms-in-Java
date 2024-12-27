// Filename: D_27_Max_Score_Sightseeing_Pair.java
public class D_27_Max_Score_Sightseeing_Pair {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] values = {8, 1, 5, 2, 6}; // Example input
        int result = solution.maxScoreSightseeingPair(values);
        System.out.println("Maximum Score of a Sightseeing Pair: " + result);
    }
}

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxPrefix = values[0] + 0; // Initialize with the first value + its index

        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the current pair
            maxScore = Math.max(maxScore, maxPrefix + values[j] - j);

            // Update maxPrefix with the current value + its index
            maxPrefix = Math.max(maxPrefix, values[j] + j);
        }

        return maxScore;
    }
}
