import java.util.HashSet;

public class D_06_Max_Count {

    public static int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }

        int count = 0;
        int sum = 0;

        for (int num = 1; num <= n; num++) {
            if (set.contains(num)) {
                continue;
            }

            if (sum + num <= maxSum) {
                count++;
                sum += num;
            } else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] banned = {1, 4, 6};
        int n = 10;
        int maxSum = 20;
        System.out.println("Maximum count of numbers: " + maxCount(banned, n, maxSum));
    }
}
