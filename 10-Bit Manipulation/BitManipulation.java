public class BitManipulation
{
    public static void oddOrEven(int n)
    {
        int bitMask = 1;
        if((n&bitMask) == 0){
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }
    }
    public static int getIthBit(int n,int i)
    {
        int bitMask = 1 << i;
        if((n&bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int n,int i){
        int bitMask = 1 <<i;
        return n | bitMask;
    }
    public static int clearIthBit(int n,int i)
    {
        int bitMasl = ~(1<<i);
        return n & bitMasl;
    }
    public static int updateIthBit(int n,int i,int newBit)
    {
        // if(newBit == 0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int bitMask = newBit<<i;
        return n | bitMask;
    }
    public static int clearithBits(int n,int i)
    {
        int bitMask = (~0) << i;
        return n & bitMask;
    }
    public static int clearBitsInRange(int n,int i,int j)
    {
        int a = ((~0) << (j+1));
        int b = (1<<i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }
    public static void main(String[] args) {
        System.out.println(~5);
        System.out.println(5<<2);
        System.out.println(6>>1);
        oddOrEven(3);
        oddOrEven(34);
        oddOrEven(244);
        oddOrEven(117);
        System.out.println(getIthBit(10, 3));
        System.out.println(setIthBit(10, 2));
        System.out.println(clearIthBit(10,2));
        System.out.println(updateIthBit(10, 1, 1));
        System.out.println(clearIthBit(10, 2));
        System.out.println(clearBitsInRange(10, 2,4));
    }
}