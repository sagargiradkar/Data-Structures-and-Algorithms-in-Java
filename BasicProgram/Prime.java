
public class Prime {
    public static void main(String[] args) {
        int n = 11;
        int i = 2;
        while(i<n)
        {
            if(n%i==0){
                System.out.println("Not Prime");
                i++;
            }
        }
        System.out.println("No is prime");
    }
}
