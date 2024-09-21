public class Binary_String_Problem {
    public static void printBinaryString(int n, int lastPlace, StringBuilder str) {
        // base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // kaam
        if (lastPlace == 0) {
            // sit 0 on chair
            printBinaryString(n - 1, 0, str.append("0"));
            printBinaryString(n - 1, 1, str.append("1"));
        } else {
            printBinaryString(n - 1, 0, str.append("0"));
        }
    }

    public static void main(String[] args) {

        printBinaryString(3, 0, new StringBuilder(""));
    }
}