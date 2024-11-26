import java.util.Arrays;
import java.util.Scanner;

public class D_44_Boats_To_Save_People {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for the number of people
        System.out.println("Enter the number of people:");
        int n = sc.nextInt();
        
        // Take input for the weights of the people
        int[] people = new int[n];
        System.out.println("Enter the weights of the people:");
        for (int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }

        // Take input for the weight limit of the boat
        System.out.println("Enter the weight limit of the boat:");
        int limit = sc.nextInt();
        
        // Create an instance of the Solution class and call the numRescueBoats method
        Solution solution = new Solution();
        int result = solution.numRescueBoats(people, limit);

        // Print the result
        System.out.println("The minimum number of boats required is: " + result);
        
        sc.close();
    }
}

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people); // Sort the array of people's weights
        int start = 0;
        int end = people.length - 1;
        int count = 0;

        // Two-pointer approach to pair the heaviest and lightest people
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start++;
                end--;
            } else {
                end--; // If pairing doesn't work, send the heaviest person alone
            }
            count++; // Count each boat used
        }
        return count;
    }
}
