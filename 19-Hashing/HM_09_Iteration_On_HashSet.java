import java.util.HashSet;
import java.util.Iterator;

public class HM_09_Iteration_On_HashSet {
    public static void main(String[] args) {
        // Create a HashSet and add some elements
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Mango");

        // Iterating using Enhanced For-Loop
        System.out.println("Iterating using Enhanced For-Loop:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Iterating using Iterator
        System.out.println("\nIterating using Iterator:");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }

        // Demonstrating element removal using Iterator
        iterator = set.iterator(); // Re-initialize the iterator to traverse again
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.equals("Banana")) {
                iterator.remove(); // Safely remove "Banana" during iteration
            }
        }

        // Print set after removal
        System.out.println("\nSet after removing 'Banana': " + set);
    }
}
