public class LL_07_Remove_Cycle {

    public LL_07_Remove_Cycle() {
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;

    // Method to remove the cycle from the linked list
    public static void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                cycle = true;
                break;
            }
        }

        // If there is no cycle, return
        if (!cycle) {
            return;
        }

        // Find the meeting point
        slow = head;
        Node prevToSlow = null; // Node before the slow pointer

        while (slow != fast) {
            prevToSlow = fast; // Keep track of the previous node
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the cycle
        prevToSlow.next = null;
    }

    // Method to check if there is a cycle in the linked list
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; // Create a cycle

        System.out.println(isCycle()); // Should print true
        removeCycle();
        System.out.println(isCycle()); // Should print false
    }
}
