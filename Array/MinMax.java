public class MinMax {
    public static void minMax(int arr[],int n)
    {
        int i,min,max;
        if(n%2==0)
        {
            if(arr[0]>arr[1])
            {
                max = arr[0];
                min = arr[1];
            }
            else
            {
                min = arr[0];
                max = arr[1];
            }
            i = 2;
        }
        else
        {
            min = arr[0];
            max = arr[0];
            i = 1;
        }
        while(i < n - 1)
        {
            if(arr[i] > arr[i+1])
            {
                if(arr[i]>max) max = arr[i];
                if(arr[i+1]<min ) min = arr[i+1];

            }else{
                if(arr[i+1] > max ) max = arr[i+1];
                if(arr[i]<min) min = arr[i];
            }
            i+=2;

        }
        System.out.println("Max :: "+ max );
        System.out.println("Min :: "+ min);
    }
    public static void main(String[] args) {
        int arr[] = {-7871,4,5,5765753,7,58765};
        minMax(arr, 6);
    }
}
