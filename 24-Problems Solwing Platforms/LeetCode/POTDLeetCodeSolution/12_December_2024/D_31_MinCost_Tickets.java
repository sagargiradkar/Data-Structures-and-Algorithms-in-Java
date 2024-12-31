public class D_31_MinCost_Tickets {
    static class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int lastDay = days[days.length - 1];
            int[] dp = new int[lastDay + 1];
            boolean[] isTravelDay = new boolean[lastDay + 1];
            
            // Mark travel days
            for (int day : days) {
                isTravelDay[day] = true;
            }
            
            for (int i = 1; i <= lastDay; i++) {
                if (!isTravelDay[i]) {
                    dp[i] = dp[i - 1];
                    continue;
                }
                int oneDayPass = dp[i - 1] + costs[0];
                int sevenDayPass = dp[Math.max(0, i - 7)] + costs[1];
                int thirtyDayPass = dp[Math.max(0, i - 30)] + costs[2];
                dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
            }
            
            return dp[lastDay];
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] days1 = {1, 4, 6, 7, 8, 20};
        int[] costs1 = {2, 7, 15};
        System.out.println("Minimum cost: " + solution.mincostTickets(days1, costs1)); // Output: 11

        int[] days2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs2 = {2, 7, 15};
        System.out.println("Minimum cost: " + solution.mincostTickets(days2, costs2)); // Output: 17

        int[] days3 = {1, 15, 30, 45};
        int[] costs3 = {2, 7, 15};
        System.out.println("Minimum cost: " + solution.mincostTickets(days3, costs3)); // Output: 8

        int[] days4 = {1, 2, 3, 4, 365};
        int[] costs4 = {3, 13, 45};
        System.out.println("Minimum cost: " + solution.mincostTickets(days4, costs4)); // Output: 49
    }
}
