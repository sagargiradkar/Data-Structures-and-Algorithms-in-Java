import java.util.Arrays;
import java.util.Comparator;

public class D_18_Largest_Number {
    public static void main(String[] args) {
        // Test case
        int[] nums = {3, 30, 34, 5, 9};
        Solution solution = new Solution();
        String result = solution.largestNumber(nums);
        System.out.println("Largest number: " + result);
    }
}

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] elements = new String[n];
        
        for(int i = 0; i < n; i++) {
            elements[i] = Integer.toString(nums[i]);
        }
        
        Arrays.sort(elements, new Comparator<String>() {
            public int compare(String a, String b) {
                String first = a + b;
                String second = b + a;
                return second.compareTo(first);
            }
        });
        
        if (elements[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String val : elements) {
            sb.append(val);
        }
        
        return sb.toString();
    }
}
