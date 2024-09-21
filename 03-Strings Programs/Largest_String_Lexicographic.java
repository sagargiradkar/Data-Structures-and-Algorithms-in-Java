public class Largest_String_Lexicographic {
    public static void main(String[] args) {
        String friuts[] = { "apple", "mango", "banana" };

        String largest = friuts[0];
        for (int i = 1; i < friuts.length; i++) {
            if (largest.compareTo(friuts[i]) < 0) {
                largest = friuts[i];
            }
        }
        System.out.println(largest);
    }
}
