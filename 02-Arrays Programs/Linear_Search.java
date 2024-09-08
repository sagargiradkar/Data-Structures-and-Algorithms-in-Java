public class Linear_Search {
    public static int linearSearch(int arr[],int key)
    {
        for(int i=0; i<arr.length; i++){
            if(arr[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,4,6,7,8,10,11,12,14,16};
        int key = 10;

        int index = linearSearch(arr, key);
        if(index == -1){
            System.out.println("Key Not Found");
        }else{
            System.out.println("Key found at :: "+index);
        }
    }
}
