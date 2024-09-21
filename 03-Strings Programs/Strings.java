
import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd', 'e'};
        String str = "abcde";
        String str2 = new String("XYZ");
        System.out.println(arr[0] + str + str2);
        //tring are IMMUTABLE IN JAVA

        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.next();
        System.out.println(name);
        name = sc.nextLine();
        System.out.println(name);

        String fullName = "Sagar Giradkar";

        System.out.println(fullName.length());

        //String Concatenation
        String firtName = "Sagar";
        String lastName = "Giradkar";

        String fullName1 = firtName + " " + lastName;
        System.out.println(fullName1);
    }
}
