import java.util.*;
public class GA_03_Minimum_Sum{
    public static void main(String[] args) {
        int A[] = {1,2,3};
        int B[] = {2,1,3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minDiff = 0;

        for(int i=0; i<A.length; i++){
            minDiff += Math.abs(A[i] - B[i]);
        }

        System.out.println("Min absolute diff of pairs is : "+ minDiff);
    }
}