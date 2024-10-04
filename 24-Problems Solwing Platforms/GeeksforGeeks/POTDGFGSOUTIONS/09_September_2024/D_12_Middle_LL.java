/* Node of a linked list */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    // Function to find the middle of the linked list
    int getMiddle(Node head) {
        if (head == null) {
            return -1;  // Return -1 for an empty list (edge case)
        }
        
        // Initialize two pointers slow and fast
        Node slow = head;
        Node fast = head;

        // Traverse the list
        while (fast != null && fast.next != null) {
            slow = slow.next;       // slow moves by one step
            fast = fast.next.next;  // fast moves by two steps
        }

        // When the loop ends, slow will be at the middle
        return slow.data;
    }
}

public class D_12_Middle_LL {
    public static void main(String[] args) {
        // Create the linked list: 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a solution instance and get the middle element
        Solution solution = new Solution();
        int middle = solution.getMiddle(head);
        
        // Output the middle element
        System.out.println("Middle element is: " + middle);  // Output: 3

        // Example with even number of nodes: 2->4->6->7->5->1
        Node head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(1);
        
        int middle2 = solution.getMiddle(head2);
        System.out.println("Middle element is: " + middle2);  // Output: 7
    }
}
