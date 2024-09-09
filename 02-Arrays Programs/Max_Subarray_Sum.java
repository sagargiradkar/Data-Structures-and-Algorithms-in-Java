public class Max_Subarray_Sum {
    public static void maxSubarraySum(int numbers[]) {
        System.out.println("Print SubArray");
        int ts = 0; // ts stands for total subarrays
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int currentSum = 0; // Reset currentSum for every new subarray

                // Calculate the sum of subarray from index i to j
                for (int k = i; k <= j; k++) {
                    currentSum += numbers[k];
                }

                ts++;
                System.out.println("Subarray Sum: " + currentSum);

                // Update maxSum if currentSum is greater
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
            System.out.println(); // Add extra line for separation
        }
        System.out.println("Total Subarrays = " + ts);
        System.out.println("Max Sum = " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        maxSubarraySum(numbers);
    }
}
