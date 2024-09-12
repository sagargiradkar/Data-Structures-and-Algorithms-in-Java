public class Recursion_Basic{
    public static void printDec(int n){
        if(n == 1) {
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }
    public static void printIncreasing(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        printIncreasing(n-1);
        System.out.print(n+" ");
    }
    public static void main(String []args){
        printDec(10);
        System.out.println();
        printIncreasing(10);
    }
}