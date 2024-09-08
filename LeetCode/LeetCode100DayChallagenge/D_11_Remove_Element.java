public class D_11_Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int ptr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
    }
    public static void main(String[] args) {

        
        // Sample input array and value to remove
        int[] nums = {3, 2, 2, 3};
        int val = 3;  // Element to remove
        
        // Call the removeElement method
        int newLength = removeElement(nums, val);
        
        // Output the result
        System.out.println("New length: " + newLength);
        System.out.print("Array after removal: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}