
public class validTriangle {
    public static void main(String[] args) {
        int a, b, c;
        a = 10;
        b = 34;
        c = 43;
        int r;
        if ((a + b > c) && (a + c > b) && (c + b) > a) {
            System.out.println("Valid Trangle");
        } else {
            System.out.println("Invalid Traingle");
        }

    }

}
