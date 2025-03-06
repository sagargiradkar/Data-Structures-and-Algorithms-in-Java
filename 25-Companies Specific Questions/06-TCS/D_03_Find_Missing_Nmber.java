public class D_03_Find_Missing_Nmber {

    public static int missingNum(int[] arr) {

        int n = arr.length;
        int s = (n * (n + 1) / 2);
        int result = 0;

        for (int x : arr) {
            result = result + x;
        }
        return s-result;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 0, 1 };
        System.out.println(missingNum(arr));
    }
}