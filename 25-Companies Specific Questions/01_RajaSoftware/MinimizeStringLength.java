public class MinimizeStringLength {
    public static int minimizeLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar != rightChar) {
                break;
            }

            // Move left pointer to the right past the left prefix
            while (left < right && s.charAt(left) == leftChar) {
                left++;
            }

            // Move right pointer to the left past the right suffix
            while (left <= right && s.charAt(right) == rightChar) {
                right--;
            }
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "ca";
        System.out.println(minimizeLength(s1));  // Output: 2

        String s2 = "aabccabba";
        System.out.println(minimizeLength(s2));  // Output: 3

        String s3 = "abccba";
        System.out.println(minimizeLength(s3));  // Output: 0

        String s4 = "abc";
        System.out.println(minimizeLength(s4));  // Output: 3
    }
}
