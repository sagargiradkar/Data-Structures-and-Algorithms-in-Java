import java.util.ArrayList;

public class D_14_Alternate_Pos_Neg {

    // Method to rearrange the array
    public static void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Separate positive and negative numbers
        for (int x : arr) {
            if (x >= 0)
                positive.add(x);
            else
                negative.add(x);
        }

        int i = 0, j = 0, k = 0;

        // Alternate between positive and negative numbers
        while (i < positive.size() && j < negative.size()) {
            if (k % 2 == 1)
                arr.set(k++, negative.get(j++));
            else
                arr.set(k++, positive.get(i++));
        }

        // Add remaining positive numbers (if any)
        while (i < positive.size()) 
            arr.set(k++, positive.get(i++));

        // Add remaining negative numbers (if any)
        while (j < negative.size()) 
            arr.set(k++, negative.get(j++));
    }

    public static void main(String[] args) {
        // Input array
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(-2);
        arr.add(3);
        arr.add(-4);
        arr.add(5);
        arr.add(-6);

        // Rearrange the array
        rearrange(arr);

        // Print the rearranged array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
