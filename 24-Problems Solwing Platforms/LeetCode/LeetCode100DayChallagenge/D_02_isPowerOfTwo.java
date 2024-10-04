public class D_02_isPowerOfTwo {
        public static boolean isPowerOfTwo(int n) {
            // if(n<1){
            //     return false;
            // }else if(n == 1){
            //     return true;
            // }else{
            //     while(n%2 == 0){
            //         n=n/2;
            //     }
    
            //     if(n==1){
            //         return true;
            //     }else{
            //         return false;
            //     }
            // }
            return n<0 ? false : Integer.bitCount(n)==1;
    }
    public static void main(String[] args) {
        boolean ans = isPowerOfTwo(256);
        System.out.println(ans);
    }
}
