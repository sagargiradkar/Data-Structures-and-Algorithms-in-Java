// D_04_Count_Triplets.java
import java.util.Arrays;

public class D_04_Count_Triplets {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 9;
        int result = solution.countTriplets(arr, target);
        System.out.println("Number of triplets with sum equal to " + target + ": " + result);
    }
}

class Solution {
    public int countTriplets(int[] arr, int target) {
        int count = 0;
        for (int x = 0; x < arr.length - 2; x++) {
            int i = x + 1;
            int j = arr.length - 1;
            int sum = 0;
            while (i < j) {
                sum = arr[i] + arr[j] + arr[x];
                if (sum == target) {
                    count++;
                    int temp = i + 1;
                    while (temp < j && arr[temp] == arr[temp - 1]) {
                        count++;
                        temp++;
                    }
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return count;
    }
}
