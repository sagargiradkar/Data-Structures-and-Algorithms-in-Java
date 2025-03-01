import java.util.*;

public class ReverseNumber {
    public static void main(String[] args) {
        int ans = 0, rem = 0;
        int num = 12345;
        while (num > 0) {
            int digit = num % 10;
            ans = ans * 10 + digit;
            num = num / 10;
        }
        System.out.println(ans);
    }
}
