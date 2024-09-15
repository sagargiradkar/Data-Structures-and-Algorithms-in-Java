import java.util.ArrayList;

public class Al_07_Coontainer_WIth_Water{
    
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        // brute force
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i; // Correcting the width calculation
                int currWater = ht * width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        // Test Case 1: Basic case
        ArrayList<Integer> heights1 = new ArrayList<>();
        heights1.add(1);
        heights1.add(8);
        heights1.add(6);
        heights1.add(2);
        heights1.add(5);
        heights1.add(4);
        heights1.add(8);
        heights1.add(3);
        heights1.add(7);
        System.out.println("Test Case 1: Expected: 49, Got: " + storeWater(heights1));  // Expected output: 49
        
        // Test Case 2: Heights with equal values
        ArrayList<Integer> heights2 = new ArrayList<>();
        heights2.add(3);
        heights2.add(3);
        heights2.add(3);
        heights2.add(3);
        System.out.println("Test Case 2: Expected: 9, Got: " + storeWater(heights2));  // Expected output: 9
        
        // Test Case 3: Increasing heights
        ArrayList<Integer> heights3 = new ArrayList<>();
        heights3.add(1);
        heights3.add(2);
        heights3.add(3);
        heights3.add(4);
        heights3.add(5);
        System.out.println("Test Case 3: Expected: 6, Got: " + storeWater(heights3));  // Expected output: 6
        
        // Test Case 4: Decreasing heights
        ArrayList<Integer> heights4 = new ArrayList<>();
        heights4.add(5);
        heights4.add(4);
        heights4.add(3);
        heights4.add(2);
        heights4.add(1);
        System.out.println("Test Case 4: Expected: 6, Got: " + storeWater(heights4));  // Expected output: 6
        
        // Test Case 5: Single height
        ArrayList<Integer> heights5 = new ArrayList<>();
        heights5.add(5);
        System.out.println("Test Case 5: Expected: 0, Got: " + storeWater(heights5));  // Expected output: 0
        
        // Test Case 6: Two heights
        ArrayList<Integer> heights6 = new ArrayList<>();
        heights6.add(1);
        heights6.add(2);
        System.out.println("Test Case 6: Expected: 1, Got: " + storeWater(heights6));  // Expected output: 1

        // Test Case 7: Large values
        ArrayList<Integer> heights7 = new ArrayList<>();
        heights7.add(1000);
        heights7.add(2000);
        heights7.add(3000);
        heights7.add(1000);
        System.out.println("Test Case 7: Expected: 3000, Got: " + storeWater(heights7));  // Expected output: 3000
    }
}
