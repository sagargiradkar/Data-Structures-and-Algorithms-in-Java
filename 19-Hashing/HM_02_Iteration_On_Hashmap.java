
import java.util.HashMap;
import java.util.Set;

public class HM_02_Iteration_On_Hashmap {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        //Insertion
        hm.put("India", 1234);
        hm.put("China", 150);
        hm.put("USA", 50);

        System.out.println(hm);

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        //Iterator
        for (String string : keys) {
            System.out.println("key = " + string + " , " + " value = " + hm.get(string));
        }
    }
}
