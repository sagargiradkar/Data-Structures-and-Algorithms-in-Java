public class D_08_Minimum_Swap {

    public static int minSwaps(String s) {
        int imbalance = 0; // Tracks the excess closing brackets
        int maxImbalance = 0; // Tracks the maximum imbalance

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                imbalance--; // An opening bracket reduces the imbalance
            } else {
                imbalance++; // A closing bracket increases the imbalance
                maxImbalance = Math.max(maxImbalance, imbalance); // Track the worst-case imbalance
            }
        }

        // The minimum number of swaps needed is the ceiling of maxImbalance / 2
        return (maxImbalance + 1) / 2;
    }

    public static void main(String[] args) {
        String s = "[]][][";
        System.out.println("Minimum swaps required: " + minSwaps(s));
    }
}
