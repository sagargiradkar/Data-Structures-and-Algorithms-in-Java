import java.util.*;
public class PascleTriangle {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number :: ");
        n = sc.nextInt();
        for(int i=0 ; i<n;i++)
        {
            int c = 1;
            for(int j = 1;j<=i;j++){
                System.out.print(c+" ");
                c = c * (i-j)/j;
            }
            System.out.println();
        }
    }
}
