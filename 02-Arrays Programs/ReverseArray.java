public class ReverseArray{
    public static void reverseArray(int arr[],int len)
    {
        for(int i=0 ; i<(len/2) ; ++i)
        {
            int temp = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = temp;
        }
    }
    public static void main(String[] args) {
        
        int arr[] = {1,3,4,2,4,4,6,4,98,938};
        reverseArray(arr, 10);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}