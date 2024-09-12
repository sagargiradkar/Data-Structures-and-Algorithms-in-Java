public class Fibonacci_Number{
    public static int printFib(int n){
        if(n==0|| n==1){
            return n;
        }
        int fnm1 = printFib(n-1);
        int fnm2 = printFib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    public static void main(String[] args) {
        System.out.println(printFib(50));
    }
}