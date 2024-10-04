public class D_04_CountStairs {

    public static int nthStair(int n) {
        // Code here
        return (n / 2) + 1;
    }

    public static void main(String[] args) {
        // Example usage
        int numStairs = 4;
        int waysToClimb = nthStair(numStairs);
        System.out.println("Number of ways to climb " + numStairs + " stairs: " + waysToClimb);
    }
}