import java.util.LinkedHashSet;
import java.util.Iterator;

public class HM_10_Linked_HashSet {

    public static void main(String[] args) {
        // Initialize LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        
        // Adding elements
        lhs.add("Apple");
        lhs.add("Banana");
        lhs.add("Orange");
        lhs.add("Mango");
        lhs.add("Apple");  // Duplicate, will not be added
        lhs.add("Banana"); // Duplicate, will not be added

        // Display the set (Insertion order is preserved)
        System.out.println("LinkedHashSet: " + lhs);

        // Checking if an element exists
        if (lhs.contains("Banana")) {
            System.out.println("LinkedHashSet contains Banana");
        } else {
            System.out.println("LinkedHashSet does not contain Banana");
        }

        // Removing an element
        lhs.remove("Mango");
        System.out.println("After removing 'Mango': " + lhs);

        // Checking the size of the set
        System.out.println("Size of LinkedHashSet: " + lhs.size());

        // Iterating over the elements using enhanced for-loop
        System.out.println("Iterating using Enhanced For-Loop:");
        for (String fruit : lhs) {
            System.out.println(fruit);
        }

        // Iterating using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<String> iterator = lhs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Clearing the set
        lhs.clear();
        System.out.println("After clearing, LinkedHashSet: " + lhs);

        // Checking if the set is empty
        if (lhs.isEmpty()) {
            System.out.println("LinkedHashSet is empty");
        } else {
            System.out.println("LinkedHashSet is not empty");
        }
    }
}
