public class D_03_Find_Missing_Nmber {

    public static int missingNum(int[] arr) {

        int n = arr.length;
        int s = (n * (n + 1) / 2);
        int result = 0;

        for (int x : arr) {
            result = result + x;
        }
        return s - result;
    }

    public static int missingXOR(int[] arr) {
        int n = arr.length;
        int totalXORSum = 0;
        int totalXORArraySum = 0;

        for (int i = 0; i <= n; i++) {
            totalXORSum = totalXORSum ^ i;
        }

        for (int x : arr) {
            totalXORArraySum = totalXORArraySum ^ x;
        }
        return totalXORSum ^ totalXORArraySum;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1, 2, 5 };
        System.out.println("Using Iterations :: " + missingNum(arr));
        System.out.println("Using XOR :: " + missingXOR(arr));
    }
}