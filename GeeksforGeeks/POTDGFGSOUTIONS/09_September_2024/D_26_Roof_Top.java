class D_26_Roof_Top {

    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        int consecutiveSteps = 0, maxi = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                consecutiveSteps++;
                maxi = Math.max(maxi, consecutiveSteps);
            } else {
                consecutiveSteps = 0;
            }
        }
        return maxi;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        D_26_Roof_Top solution = new D_26_Roof_Top();
        
        // Test case 1
        int[] arr1 = {1, 2, 2, 3, 2};
        System.out.println("Maximum consecutive steps in test case 1: " + solution.maxStep(arr1));

        // Test case 2
        int[] arr2 = {10, 12, 14, 15, 5, 7, 10, 11};
        System.out.println("Maximum consecutive steps in test case 2: " + solution.maxStep(arr2));

        // Test case 3
        int[] arr3 = {1, 2, 3, 4, 5, 6};
        System.out.println("Maximum consecutive steps in test case 3: " + solution.maxStep(arr3));
    }
}
