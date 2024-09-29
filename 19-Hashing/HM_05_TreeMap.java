
import java.util.TreeMap;

public class HM_05_TreeMap {

    public static void main(String[] args) {
        // Creating a TreeMap
        TreeMap<String, Integer> lhm = new TreeMap<>();

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
        System.out.println("TreeMap (Insertion Order):");
        System.out.println(lhm);

    }
}
