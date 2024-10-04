public class EquilibriumFinder {
    
    // Method to find the equilibrium element in the array
    public int findEquilibriumElement(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            // Right sum is total sum minus the current element and left sum
            int rightSum = totalSum - arr[i] - leftSum;
            
            if (leftSum == rightSum) {
                return arr[i];
            }
            
            // Update left sum for the next iteration
            leftSum += arr[i];
        }
        
        // Return 0 if no equilibrium element is found
        return 0;
    }
    
    public static void main(String[] args) {
        EquilibriumFinder finder = new EquilibriumFinder();
        
        int[] array1 = {1, 7, 5, 2, 6};
        int equilibrium1 = finder.findEquilibriumElement(array1);
        System.out.println("Equilibrium element in array1: " + equilibrium1); // Output: 5
        
        int[] array2 = {10, 1, 1, 9};
        int equilibrium2 = finder.findEquilibriumElement(array2);
        System.out.println("Equilibrium element in array2: " + equilibrium2); // Output: 1
        
        int[] array3 = {1, 2, 3, 4, 5};
        int equilibrium3 = finder.findEquilibriumElement(array3);
        System.out.println("Equilibrium element in array3: " + equilibrium3); // Output: 0
    }
}
