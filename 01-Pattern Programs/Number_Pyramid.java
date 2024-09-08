class Solution{
    public void number_pyramid(int n){
        System.out.println("Number Pyramid");
        //outer loop
        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }
            //Numbers
            for(int j=1; j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
public class Number_Pyramid {
    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.number_pyramid(7);
    }
}
