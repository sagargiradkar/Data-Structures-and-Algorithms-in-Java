import java.util.HashMap;
import java.util.LinkedHashMap;

public class HM_04_LinkedHashMap {

    public static void main(String[] args) {
        // Creating a LinkedHashMap
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        // Adding at least 10 records to LinkedHashMap
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Nepal", 10);
        lhm.put("Australia", 30);
        lhm.put("Germany", 80);
        lhm.put("Japan", 60);
        lhm.put("Brazil", 40);
        lhm.put("Canada", 70);
        lhm.put("Russia", 90);

        // Printing LinkedHashMap (insertion order is preserved)
        System.out.println("LinkedHashMap (Insertion Order):");
        System.out.println(lhm);

        // Creating a HashMap
        HashMap<String, Integer> hm = new HashMap<>();

        // Adding the same records to HashMap
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 10);
        hm.put("Australia", 30);
        hm.put("Germany", 80);
        hm.put("Japan", 60);
        hm.put("Brazil", 40);
        hm.put("Canada", 70);
        hm.put("Russia", 90);

        // Printing HashMap (no specific order)
        System.out.println("HashMap (Unordered):");
        System.out.println(hm);
    }
}
