
import java.util.Arrays;

public class DP_04_Climbing_Stairs_Variation {

    public static int countWays(int n, int ways[]) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways) + countWays(n - 3, ways);
        return ways[n];
    }

    public static void main(String[] args) {
        int n = 50;
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n, ways));
    }
}
