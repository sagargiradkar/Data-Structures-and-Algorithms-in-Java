import java.util.Scanner;

public class D_19_Nearest_Multiple {

    public static String nearestMultiple(String str) {
        int n = str.length() - 1;
        char temp[] = str.toCharArray();
        if (temp[n] <= '5') {
            temp[n] = '0';
            return new String(temp);
        }
        temp[n] = '0';
        n--;
        while (n >= 0 && temp[n] == '9') {
            temp[n] = '0';
            n--;
        }
        if (n == -1) return '1' + new String(temp);
        temp[n] += 1;
        return new String(temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String input = sc.nextLine();
        String result = nearestMultiple(input);
        System.out.println("Nearest multiple: " + result);
        sc.close();
    }
}