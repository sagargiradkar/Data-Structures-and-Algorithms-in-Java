public class D_04_Reverse_Curcular_LL {

    // Definition of the Node class
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Class containing the solution methods
    static class Solution {
        // Function to reverse a circular linked list
        Node reverse(Node head) {
            if (head == null || head.next == head) {
                return head;  // List is empty or has only one node
            }

            Node prev = null;
            Node current = head;
            Node next = null;
            Node tail = head;  // Track the current head (which will become the tail after reversing)

            do {
                next = current.next;  // Store the next node
                current.next = prev;  // Reverse the current node's pointer
                prev = current;       // Move prev forward
                current = next;       // Move current forward
            } while (current != head); // Continue until we come back to the head

            // At this point, prev is the new head. We need to reconnect the tail.
            tail.next = prev;  // Old head's next becomes new head

            return prev;  // prev is the new head of the reversed list
        }

        // Function to delete a node from the circular linked list
        Node deleteNode(Node head, int key) {
            if (head == null) {
                return null;  // List is empty
            }

            // Special case: Deleting the head node
            if (head.data == key) {
                // If there's only one node in the list
                if (head.next == head) {
                    return null;  // Deleting the only node
                }

                // Find the last node to reconnect after deleting the head
                Node last = head;
                while (last.next != head) {
                    last = last.next;
                }

                // Update the last node's next pointer to the second node
                last.next = head.next;
                head = head.next;  // Move head to the next node

                return head;
            }

            // General case: Deleting a node that's not the head
            Node current = head;
            Node prev = null;

            do {
                prev = current;
                current = current.next;

                if (current.data == key) {
                    prev.next = current.next;  // Remove current node
                    return head;  // Return the updated head
                }

            } while (current != head);

            return head;  // Key not found, return original head
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a circular linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head;  // Make it circular

        // Reverse the circular linked list
        head = solution.reverse(head);

        // Print the reversed circular linked list
        Node temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
        System.out.println();

        // Delete a node from the circular linked list
        head = solution.deleteNode(head, 2);

        // Print the list after deletion
        temp = head;
        if (head != null) {
            do {
                System.out.print(temp.data + " ");
                temp = temp.next;
            } while (temp != head);
        }
    }
}