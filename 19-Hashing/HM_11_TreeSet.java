import java.util.TreeSet;
import java.util.Iterator;

public class HM_11_TreeSet {
    public static void main(String[] args) {
        // Initialize TreeSet
        TreeSet<Integer> ts = new TreeSet<>();
        
        // Adding elements to TreeSet
        ts.add(50);
        ts.add(20);
        ts.add(40);
        ts.add(10);
        ts.add(30);
        
        // Display TreeSet (Elements will be in sorted order)
        System.out.println("TreeSet (sorted): " + ts);

        // Checking if an element exists
        if (ts.contains(30)) {
            System.out.println("TreeSet contains 30");
        } else {
            System.out.println("TreeSet does not contain 30");
        }

        // Removing an element
        ts.remove(40);
        System.out.println("After removing 40: " + ts);

        // Getting the first and last elements
        System.out.println("First element: " + ts.first());
        System.out.println("Last element: " + ts.last());

        // Getting a subset (all elements less than 30)
        System.out.println("HeadSet (less than 30): " + ts.headSet(30));

        // Getting a subset (all elements greater than or equal to 20)
        System.out.println("TailSet (greater than or equal to 20): " + ts.tailSet(20));

        // Getting a subset between 20 and 50 (inclusive of 20, exclusive of 50)
        System.out.println("SubSet (between 20 and 50): " + ts.subSet(20, 50));

        // Checking the size of the TreeSet
        System.out.println("Size of TreeSet: " + ts.size());

        // Iterating over the elements using enhanced for-loop
        System.out.println("Iterating using Enhanced For-Loop:");
        for (Integer num : ts) {
            System.out.println(num);
        }

        // Iterating using Iterator
        System.out.println("Iterating using Iterator:");
        Iterator<Integer> iterator = ts.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Clearing the TreeSet
        ts.clear();
        System.out.println("After clearing, TreeSet: " + ts);

        // Checking if the TreeSet is empty
        if (ts.isEmpty()) {
            System.out.println("TreeSet is empty");
        } else {
            System.out.println("TreeSet is not empty");
        }

        TreeSet<Integer> intSet = new TreeSet<>();
        intSet.add(50);
        intSet.add(20);
        intSet.add(40);
        intSet.add(10);
        intSet.add(30);

        // TreeSet for Character
        TreeSet<Character> charSet = new TreeSet<>();
        charSet.add('C');
        charSet.add('A');
        charSet.add('D');
        charSet.add('B');
        charSet.add('E');

        // Integer TreeSet operations
        System.out.println("TreeSet (Integer) - Sorted: " + intSet);
        System.out.println("First element (Integer): " + intSet.first());
        System.out.println("Last element (Integer): " + intSet.last());
        System.out.println("HeadSet (less than 30, Integer): " + intSet.headSet(30));
        System.out.println("TailSet (greater than or equal to 20, Integer): " + intSet.tailSet(20));
        System.out.println("SubSet (between 20 and 50, Integer): " + intSet.subSet(20, 50));

        // Iterating over Integer TreeSet
        System.out.println("Iterating Integer TreeSet using Enhanced For-Loop:");
        for (Integer num : intSet) {
            System.out.println(num);
        }

        System.out.println("Iterating Integer TreeSet using Iterator:");
        Iterator<Integer> intIterator = intSet.iterator();
        while (intIterator.hasNext()) {
            System.out.println(intIterator.next());
        }

        // Character TreeSet operations
        System.out.println("\nTreeSet (Character) - Sorted: " + charSet);
        System.out.println("First element (Character): " + charSet.first());
        System.out.println("Last element (Character): " + charSet.last());
        System.out.println("HeadSet (less than 'C', Character): " + charSet.headSet('C'));
        System.out.println("TailSet (greater than or equal to 'B', Character): " + charSet.tailSet('B'));
        System.out.println("SubSet (between 'B' and 'D', Character): " + charSet.subSet('B', 'D'));

        // Iterating over Character TreeSet
        System.out.println("Iterating Character TreeSet using Enhanced For-Loop:");
        for (Character ch : charSet) {
            System.out.println(ch);
        }

        System.out.println("Iterating Character TreeSet using Iterator:");
        Iterator<Character> charIterator = charSet.iterator();
        while (charIterator.hasNext()) {
            System.out.println(charIterator.next());
        }
    }
}
