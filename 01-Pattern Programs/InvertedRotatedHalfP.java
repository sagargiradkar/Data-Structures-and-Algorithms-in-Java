
public class InvertedRotatedHalfP{

    public static void Inverted_Pyramid(int n){
        //oter loo
        for(int i=0 ; i<=n; i++){
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print("  ");
            }
            //stars
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.print("Inverted Rotated Half Pyramid");
        Inverted_Pyramid(15);
    }

}