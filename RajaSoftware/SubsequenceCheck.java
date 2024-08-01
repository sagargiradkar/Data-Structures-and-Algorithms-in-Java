public class SubsequenceCheck {
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLength = s.length();
        int tLength = t.length();

        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == sLength;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "abc";
        String t1 = "ahbgdc";
        System.out.println(isSubsequence(s1, t1));  // Output: true

        String s2 = "axc";
        String t2 = "ahbgdc";
        System.out.println(isSubsequence(s2, t2));  // Output: false

        String s3 = "agb";
        String t3 = "ahbgdc";
        System.out.println(isSubsequence(s3, t3));  // Output: false
    }
}
