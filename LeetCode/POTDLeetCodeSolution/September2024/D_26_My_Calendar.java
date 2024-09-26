import java.util.TreeMap;

public class D_26_My_Calendar {

    public static class MyCalendar {
        TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer prevVal = map.lowerKey(end);
            if (prevVal != null && start <= map.get(prevVal) - 1) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();

        // Test cases
        System.out.println(myCalendar.book(10, 20)); // Should return true
        System.out.println(myCalendar.book(15, 25)); // Should return false (overlap)
        System.out.println(myCalendar.book(20, 30)); // Should return true (no overlap)
        System.out.println(myCalendar.book(5, 10));  // Should return true (no overlap)
        System.out.println(myCalendar.book(25, 35)); // Should return true (no overlap)
    }
}
