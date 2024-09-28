
import java.util.HashMap;

public class HM_01_HashMap_Operations {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        //Insertion
        hm.put("India", 1234);
        hm.put("China", 150);
        hm.put("USA", 50);

        System.out.println(hm);

        //Get Operation
        int population = hm.get("India");
        System.out.println(population);

        // int population1 = hm.get("India1");
        // System.out.println(population1);

        //ContainsKey -O(1)
        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("hm"));

        // Remove - O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm);

        // Size
        System.out.println("size :: "+hm.size());

        //isEmpty 
        System.out.println("isEmpty :: "+hm.isEmpty());
        hm.clear();
        System.out.println(hm);
        System.out.println("isEmpty :: "+hm.isEmpty());
    }
}
