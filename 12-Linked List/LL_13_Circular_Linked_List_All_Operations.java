public class LL_13_Circular_Linked_List_All_Operations {
    
    // Node class representing each element in the circular linked list
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Circular Linked List class
    public static class CircularLinkedList {
        public Node head = null;
        public Node tail = null;
        public int size = 0;

        // Method to check if the list is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Method to add a node at the beginning of the list
        public void addFirst(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = newNode;
                tail = newNode;
                tail.next = head; // Points tail to the head to form a circle
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head; // Maintain circular connection
            }
        }

        // Method to add a node at the end of the list
        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = newNode;
                tail = newNode;
                tail.next = head; // Points tail to the head to form a circle
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head; // Maintain circular connection
            }
        }

        // Method to remove the first node of the list
        public void removeFirst() {
            if (isEmpty()) {
                System.out.println("List is empty. Nothing to remove.");
                return;
            }

            size--;
            if (head == tail) { // Single element case
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // Maintain circular connection
            }
        }

        // Method to remove the last node of the list
        public void removeLast() {
            if (isEmpty()) {
                System.out.println("List is empty. Nothing to remove.");
                return;
            }

            size--;
            if (head == tail) { // Single element case
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) { // Traverse until second last element
                    temp = temp.next;
                }
                tail = temp;
                tail.next = head; // Maintain circular connection
            }
        }

        // Method to print the list
        public void print() {
            if (isEmpty()) {
                System.out.println("List is empty.");
                return;
            }

            Node temp = head;
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != head); // Loop until we come back to head
            System.out.println("(back to head)");
        }

        // Method to get the size of the list
        public int getSize() {
            return size;
        }
    }

    // Main method to demonstrate all operations
    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Adding elements at the beginning
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);

        // Print the list
        System.out.println("After adding elements at the beginning:");
        cll.print(); // Expected: 1 -> 2 -> 3 -> (back to head)

        // Adding elements at the end
        cll.addLast(4);
        cll.addLast(5);

        // Print the list
        System.out.println("After adding elements at the end:");
        cll.print(); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> (back to head)

        // Remove the first element
        cll.removeFirst();
        System.out.println("After removing the first element:");
        cll.print(); // Expected: 2 -> 3 -> 4 -> 5 -> (back to head)

        // Remove the last element
        cll.removeLast();
        System.out.println("After removing the last element:");
        cll.print(); // Expected: 2 -> 3 -> 4 -> (back to head)

        // Get the size of the list
        System.out.println("Size of the circular linked list: " + cll.getSize()); // Expected: 3
    }
}
