public class first_Occurance {
    public static int firstOcuurance(int arr[],int key,int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
       return firstOcuurance(arr, key, i+1);
    }
    public static void main(String[] args) {
        int arr[] = {8,3,6,9,5,10,2,5,3};
        System.out.println(firstOcuurance(arr, 5, 0));
    }
}
