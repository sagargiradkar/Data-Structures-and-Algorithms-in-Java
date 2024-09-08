public class InsertionSort {
    public static void insertionSort(int [] arr)
    {
        for(int i=0 ; i<arr.length ; i++)
        {
            int curr = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] < curr) 
            { 
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }
    public static void display(int [] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[]args){
        int array[] = {1,4,52,2,13,437,43};
        insertionSort(array);
        display(array);
        

    }
}
