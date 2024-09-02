public class D_05_WaterBottle {
    
    // Method to compute the number of water bottles that can be drunk
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            int newBottles = numBottles / numExchange;
            int remBottles = numBottles % numExchange;

            ans = ans + newBottles;
            numBottles = newBottles + remBottles;
        }

        return ans;
    }

    // Main method to test the numWaterBottles function
    public static void main(String[] args) {
        // Create an instance of D_05_WaterBottle
        D_05_WaterBottle bottleSolver = new D_05_WaterBottle();
        
        // Example test cases
        int numBottles = 9;
        int numExchange = 3;
        int result = bottleSolver.numWaterBottles(numBottles, numExchange);
        System.out.println("Total water bottles drunk: " + result);

        numBottles = 15;
        numExchange = 4;
        result = bottleSolver.numWaterBottles(numBottles, numExchange);
        System.out.println("Total water bottles drunk: " + result);
    }
}
