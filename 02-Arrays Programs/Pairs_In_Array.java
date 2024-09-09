public class Pairs_In_Array {
    public static void printPairs(int numbers[]) {
        System.out.println("Print Pairs in Array");
        int tp = 0; // tp stands for total pairs
        for (int i = 0; i < numbers.length; i++) {
            int curr = numbers[i]; // Current number
            for (int j = i + 1; j < numbers.length; j++) { // Start j from i + 1 to avoid duplicate pairs
                System.out.print("( " + curr + " , " + numbers[j] + " ) ");
                tp++;
            }
            System.out.println(); // To print pairs in separate lines
        }
        System.out.println("Total Pairs = " + tp);
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10};
        printPairs(numbers);
    }
}
