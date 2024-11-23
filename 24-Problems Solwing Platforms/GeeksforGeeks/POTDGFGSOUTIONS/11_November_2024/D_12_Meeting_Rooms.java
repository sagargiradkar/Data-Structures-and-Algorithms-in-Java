import java.util.Arrays;

public class D_12_Meeting_Rooms {

    public static void main(String[] args) {
        int[][] meetings = {
            {1, 3},
            {2, 4},
            {5, 6}
        };

        boolean result = canAttend(meetings);
        System.out.println("Can attend all meetings: " + result);
    }

    static boolean canAttend(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < n; i++) {
            if (arr[i - 1][1] > arr[i][0]) {
                return false;
            }
        }
        return true;
    }
}
