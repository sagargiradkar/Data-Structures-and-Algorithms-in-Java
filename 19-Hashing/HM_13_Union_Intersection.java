import java.util.HashSet;

public class HM_13_Union_Intersection {

    public static void main(String[] args) {
        int[] arr1 = {7, 3, 9};
        int[] arr2 = {6, 3, 9, 2, 9, 4};
        
        HashSet<Integer> set = new HashSet<>();
        
        // Union
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union size = " + set.size());
        System.out.print("Union elements: ");
        for (Integer i : set) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        set.clear();  // Clear the set for intersection operation

        // Intersection
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int intersectionCount = 0;
        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                intersectionCount++;
                intersectionSet.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }
        System.out.println("Intersection size = " + intersectionCount);
        System.out.print("Intersection elements: ");
        for (Integer i : intersectionSet) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
