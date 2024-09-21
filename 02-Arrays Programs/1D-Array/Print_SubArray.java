public class Print_SubArray {
    public static void printSubarray(int numbers[]) {
        System.out.println("Print SubArray");
        int ts = 0; // ts stands for total subarrays
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                // Print subarray from index i to j
                for (int k = i; k <= j; k++) {
                    System.out.print("[" + numbers[k] + "] ");
                }
                ts++;
                System.out.println(); // Move to the next line after printing each subarray
            }
            System.out.println(); // Add extra line for separation
        }
        System.out.println("Total Subarrays = " + ts);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8, 10 };
        printSubarray(numbers);
    }
}
