import java.util.HashMap;

public class D_20_Find_Lucky_Integer {
    public static int findLucky(int[] arr) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int ele = arr[i];
            if(hm.containsKey(ele)){
                hm.put(ele, hm.get(ele) + 1);
            } else {
                hm.put(ele, 1);
            }
        }

        int ans = -1;

        for(int key : hm.keySet()){
            if(hm.get(key) == key){
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        
        // Example input
        int[] arr = {2, 2, 3, 4}; // You can change this to test with different inputs
        int result = findLucky(arr);
        
        // Print the result
        System.out.println("The lucky integer is: " + result);
    }
}
