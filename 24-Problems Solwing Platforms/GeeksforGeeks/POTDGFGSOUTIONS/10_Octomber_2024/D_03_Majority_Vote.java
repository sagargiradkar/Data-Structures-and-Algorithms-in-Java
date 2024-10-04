import java.util.*;
public class D_03_Majority_Vote {

    // Function to find the majority elements in the array
    public static List<Integer> findMajority(List<Integer> nums) {
        int n = nums.size();
        int can1 = Integer.MIN_VALUE, can2 = Integer.MIN_VALUE;
        int counter1 = 0, counter2 = 0;

        for (int i = 0; i < n; i++) {
            if (nums.get(i) == can1) {
                counter1++;
            } else if (nums.get(i) == can2) {
                counter2++;
            } else if (counter1 == 0) {
                can1 = nums.get(i);
                counter1 = 1;
            } else if (counter2 == 0) {
                can2 = nums.get(i);
                counter2 = 1;
            } else {
                counter1--;
                counter2--;
            }
        }

        int vote1 = 0, vote2 = 0;
        for (int x : nums) {
            if (x == can1) {
                vote1++;
            }
            if (x == can2) {
                vote2++;
            }
        }

        List<Integer> ans = new ArrayList<>();
        if (vote1 > n / 3) {
            ans.add(can1);
        }
        if (vote2 > n / 3) {
            ans.add(can2);
        }
        if (ans.isEmpty()) {
            ans.add(-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        nums.add(3);
        List<Integer> result = findMajority(nums);
        System.out.println("Majority elements: " + result);
    }
}