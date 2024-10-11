import java.util.List;
import java.util.ArrayList;

public class D_11_Rearrange {
    public List<Integer> rearrange(List<Integer> arr) {
        // CodeGenius
        for (int i = 0; i < arr.size(); i++) {
            while (arr.get(i) != -1 && arr.get(i) != i) {
                // Swap arr[i] with arr[arr[i]]
                int temp = arr.get(i);
                arr.set(i, arr.get(temp));
                arr.set(temp, temp);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        D_11_Rearrange solution = new D_11_Rearrange();
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(-1);
        arr.add(1);
        arr.add(4);
        arr.add(5);
        arr.add(3);

        List<Integer> result = solution.rearrange(arr);
        System.out.println(result);
    }
}