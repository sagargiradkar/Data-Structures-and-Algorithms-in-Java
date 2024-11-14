import java.util.Arrays;

public class D_14_Minimized_Maximize {

    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = Arrays.stream(quantities).max().getAsInt();
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            
            if (canDistribute(quantities, n, mid)) {
                high = mid;  // Try for a smaller maximum
            } else {
                low = mid + 1;  // Increase the minimum bound
            }
        }
        
        return low;
    }
    
    private boolean canDistribute(int[] quantities, int n, int maxProductsPerStore) {
        int requiredStores = 0;
        
        for (int quantity : quantities) {
            requiredStores += (quantity + maxProductsPerStore - 1) / maxProductsPerStore;
            if (requiredStores > n) {
                return false;  // Not feasible with this maxProductsPerStore
            }
        }
        
        return true;  // Feasible within the store limit
    }

    public static void main(String[] args) {
        D_14_Minimized_Maximize solution = new D_14_Minimized_Maximize();
        
        // Sample input
        int n = 6;
        int[] quantities = {11, 6};
        
        // Calculate the minimized maximum
        int result = solution.minimizedMaximum(n, quantities);
        
        // Output the result
        System.out.println("The minimized maximum of products any store receives is: " + result);
    }
}
