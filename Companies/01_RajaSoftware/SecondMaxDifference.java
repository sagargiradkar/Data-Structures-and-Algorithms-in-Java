import java.util.Arrays;

public class SecondMaxDifference {

    public static void main(String[] args) {
        int[] arr = {14, 12, 70, 15, 95, 65, 22, 30};
        System.out.println(secondMaxDifference(arr));
    }
    
    public static int secondMaxDifference(int[] arr) {
        if (arr.length < 2) {
            return -1; // Not enough elements to find a difference
        }
        
        // Sort the array
        Arrays.sort(arr);
        
        // Calculate the differences between all pairs of elements
        int maxDifference = Integer.MIN_VALUE;
        int secondMaxDifference = Integer.MIN_VALUE;
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = arr[j] - arr[i];
                if (diff > maxDifference) {
                    secondMaxDifference = maxDifference;
                    maxDifference = diff;
                } else if (diff > secondMaxDifference && diff != maxDifference) {
                    secondMaxDifference = diff;
                }
            }
        }
        
        return secondMaxDifference;
    }
}
