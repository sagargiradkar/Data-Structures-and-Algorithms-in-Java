public class Max_Sum_Prefix_Array {
    public static void prefixSubarraySum(int numbers[]) {
        System.out.println("Prefix SubArray");
        int ts = 0; // ts stands for total subarrays
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        // Step 1: Calculate prefix array
        prefix[0] = numbers[0]; // Initialize first element
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i]; // Accumulate sum for prefix array
        }

        // Step 2: Iterate through subarrays and calculate their sums using the prefix
        // array
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                // Calculate sum for subarray from index i to j
                int currentSum = i == 0 ? prefix[j] : (prefix[j] - prefix[i - 1]);

                ts++; // Increment total subarrays count
                System.out.println("Subarray Sum: " + currentSum);

                // Step 3: Update maxSum if currentSum is greater
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
            System.out.println(); // Add extra line for separation of subarrays
        }

        // Final output
        System.out.println("Total Subarrays = " + ts);
        System.out.println("Max Sum = " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10 }; // Test array
        prefixSubarraySum(numbers); // Call the function
    }
}
