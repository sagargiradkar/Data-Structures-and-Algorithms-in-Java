
import java.util.HashMap;
import java.util.Set;

public class HM_06_Majority_Element {

    public static void main(String[] args) {
        int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1}; // Example array
        HashMap<Integer, Integer> map = new HashMap<>();

        // Counting the frequency of each element in the array
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Finding the majority element (appears more than n/2 times)
        int n = nums.length;
        int majorityElement = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                majorityElement = key;
                break;
            }
        }

        // Printing the majority element if it exists
        if (majorityElement != -1) {
            System.out.println("Majority Element (n/2 times): " + majorityElement);
        } else {
            System.out.println("No Majority Element (n/2 times)");
        }

        // Printing elements that appear more than n/3 times
        System.out.println("Elements appearing more than n/3 times:");
        for (Integer key : map.keySet()) {
            if (map.get(key) > n / 3) {
                System.out.println(key);
            }
        }
    }
}
