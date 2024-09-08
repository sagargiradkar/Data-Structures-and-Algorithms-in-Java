public class Triangle_0_1{
    public static void tringle_zero_ones(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                if((i+j)%2==0){//even 
                    System.out.print("1 ");
                }else{

                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String []args)
    {
        System.out.println("Triangle 0/1 ");
        tringle_zero_ones(5);
    }
}