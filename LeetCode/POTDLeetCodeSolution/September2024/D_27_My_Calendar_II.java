import java.util.*;

public class D_27_My_Calendar_II {
    public static void main(String[] args) {
        // Create an instance of MyCalendarTwo
        MyCalendarTwo obj = new MyCalendarTwo();
        
        // Test booking some events
        System.out.println(obj.book(10, 20)); // Expected output: true
        System.out.println(obj.book(15, 25)); // Expected output: true (overlaps once)
        System.out.println(obj.book(20, 30)); // Expected output: true
        System.out.println(obj.book(5, 15));  // Expected output: false (overlaps twice)
        System.out.println(obj.book(5, 10));  // Expected output: true
    }
}

class MyCalendarTwo {
    List<int[]> bookings;
    TreeMap<Integer, Integer> overlappedMap;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlappedMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prevVal = overlappedMap.lowerKey(end);
        if (prevVal != null && start <= overlappedMap.get(prevVal) - 1) {
            return false;
        }

        for (int booking[] : bookings) {
            int commStart = Math.max(booking[0], start);
            int commEnd = Math.min(booking[1], end);
            if (commStart < commEnd) {
                overlappedMap.put(commStart, commEnd);
            }
        }
        bookings.add(new int[]{start, end});
        return true;
    }
}
