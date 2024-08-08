import java.util.*;
public class neumericHalfPyramid
{
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :: ");
        n = sc.nextInt();
        for(int row=0 ; row<n ; row++)
        {
            for(int col=0;col<=row ; col++)
            {
                if(col==0|| col==row||row==n-1)
                {
                    System.out.print(col+1);
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}