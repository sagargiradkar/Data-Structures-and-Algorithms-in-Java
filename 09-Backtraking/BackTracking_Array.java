public class BackTracking_Array{
    public static void changeArray(int arr[],int i,int val){
        //base case
        if(i == arr.length){
            printArr(arr);
            return;
        }
        //kaam recurion
        arr[i] = val;
        changeArray(arr, i+1, val+1);
        arr[i] = arr[i] - 2;

    }
    public static void printArr(int arr[]){
        for(int i:arr){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        printArr(arr);
    }
}