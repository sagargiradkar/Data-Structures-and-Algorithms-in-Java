public class Quick_Sort{
    public static void print(int arr[]){
        for(int i:arr ){
            System.out.print(i+" ");
        }
    }
    public static void quixkSort(int arr[],int si,int ei){
        if(si>=ei){
            return;
        }
        //last element
        int pidx = partition(arr,si,ei);
        quixkSort(arr, si, pidx-1);
        quixkSort(arr, pidx+1, ei);
    }
    public static int partition(int arr[],int si,int ei){
        int pivot = arr[ei];
        int i = si-1;//to make place for element smaller than pivote

        for(int j=si; j<ei; j++){
            if(arr[j] <= pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

    }
    public static void main(String[] args){
        int arr[] = {6,3,9,8,2,5};
        quixkSort(arr, 0, arr.length-1);
        print(arr);
    }
}