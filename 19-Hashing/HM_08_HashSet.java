import java.util.HashSet;

public class HM_08_HashSet {
    public static void main(String[] args) {
        // Initialize the HashSet
        HashSet<Integer> set = new HashSet<>();

        // Adding elements to the set
        set.add(1);
        set.add(2);
        set.add(4);
        set.add(1); // Duplicate element, will not be added

        // Printing the set (duplicates won't be included)
        System.out.println("Set after adding elements: " + set);

        // Checking if a specific element exists in the set
        if (set.contains(2)) {
            System.out.println("Set contains 2");
        } else {
            System.out.println("Set does not contain 2");
        }

        // Checking if an element that doesn't exist is in the set
        if (set.contains(3)) {
            System.out.println("Set contains 3");
        } else {
            System.out.println("Set does not contain 3");
        }

        // Removing an element from the set
        set.remove(2);
        System.out.println("Set after removing 2: " + set);

        // Checking the size of the set
        System.out.println("Size of the set: " + set.size());

        // Iterating over the elements in the set
        System.out.println("Iterating over set elements:");
        for (int num : set) {
            System.out.println(num);
        }

        // Clearing the set (removing all elements)
        set.clear();
        System.out.println("Set after clearing all elements: " + set);

        // Checking if the set is empty
        if (set.isEmpty()) {
            System.out.println("Set is empty");
        } else {
            System.out.println("Set is not empty");
        }
    }
}
