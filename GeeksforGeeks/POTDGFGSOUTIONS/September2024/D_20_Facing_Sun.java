public class D_20_Facing_Sun {
    // Returns count of buildings that can see sunlight
    public int countBuildings(int[] height) {
        int count = 1;  // First building always sees the sun
        int maxi = height[0];
        
        for (int i = 1; i < height.length; i++) {
            if (height[i] > maxi) {
                count++;
                maxi = height[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        D_20_Facing_Sun solution = new D_20_Facing_Sun();
        
        // Example input
        int[] heights = {7, 4, 8, 2, 9};
        
        // Call the method to count buildings that can see sunlight
        int result = solution.countBuildings(heights);
        
        // Print the result
        System.out.println("Number of buildings that can see sunlight: " + result);
    }
}
