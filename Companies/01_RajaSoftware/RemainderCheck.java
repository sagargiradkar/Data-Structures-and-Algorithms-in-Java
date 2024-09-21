public class RemainderCheck {

    public static void main(String[] args) {
        int[] arr1 = {19, 10, 44, 3, 11, 129};
        int[] arr2 = {13, 4};
        
        printNumbersWithRemainderFour(arr1);
        printNumbersWithRemainderFour(arr2);
    }
    
    public static void printNumbersWithRemainderFour(int[] arr) {
        for (int num : arr) {
            if (num % 5 == 4) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}
