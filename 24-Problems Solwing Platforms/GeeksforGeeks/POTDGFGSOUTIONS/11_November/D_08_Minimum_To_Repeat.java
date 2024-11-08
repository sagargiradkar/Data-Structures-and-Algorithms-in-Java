public class D_08_Minimum_To_Repeat {
    public static int minRepeats(String s1, String s2) {
        String temp = s1;
        int count = 1;
        
        while (s1.length() < s2.length()) {
            s1 += temp;
            count++;
        }
        
        if (s1.contains(s2)) {
            return count;
        }
        
        s1 += temp;
        count++;
        
        if (s1.contains(s2)) {
            return count;
        }
        
        return -1;
    }

    public static void main(String[] args) {
        // Test case
        String s1 = "abcd";
        String s2 = "cdabcdab";
        
        int result = minRepeats(s1, s2);
        System.out.println("Minimum repeats required: " + result);
    }
}
