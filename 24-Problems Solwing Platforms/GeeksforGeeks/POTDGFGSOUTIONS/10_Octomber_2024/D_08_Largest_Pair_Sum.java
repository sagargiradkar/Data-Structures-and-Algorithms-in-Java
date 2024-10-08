public class D_08_Largest_Pair_Sum {

    public static int pairSum(int[] arr) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x > secondLargest) {
                secondLargest = x;
            }
        }
        return largest + secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 10, 6, 40 };
        System.out.println("Largest pair sum: " + pairSum(arr));
    }
}
