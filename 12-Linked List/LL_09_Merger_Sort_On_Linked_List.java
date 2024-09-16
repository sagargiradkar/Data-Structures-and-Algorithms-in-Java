public class LL_09_Merge_Sort_On_Linked_List {

    // Define the Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // LinkedList class
    public static class LinkedList {
        public Node head = null;

        // Method to add elements at the beginning
        public void addFirst(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }

        // Method to print the linked list
        public void print() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }

        // Method to get the middle node for merge sort
        private Node getMid(Node head) {
            Node slow = head;
            Node fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        // Method to merge two sorted linked lists
        private Node merge(Node head1, Node head2) {
            Node mergedLL = new Node(-1); // Dummy node
            Node temp = mergedLL;

            while (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    temp.next = head1;
                    head1 = head1.next;
                } else {
                    temp.next = head2;
                    head2 = head2.next;
                }
                temp = temp.next;
            }

            while (head1 != null) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }

            while (head2 != null) {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }

            return mergedLL.next; // Skip the dummy node
        }

        // Method to perform merge sort on linked list
        public Node mergeSort(Node head) {
            if (head == null || head.next == null) {
                return head;
            }

            Node mid = getMid(head);
            Node rightHead = mid.next;
            mid.next = null;

            Node newLeft = mergeSort(head);
            Node newRight = mergeSort(rightHead);

            return merge(newLeft, newRight);
        }
    }

    // Main method to test the linked list and merge sort
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        System.out.println("Original List:");
        ll.print();

        ll.head = ll.mergeSort(ll.head);

        System.out.println("Sorted List:");
        ll.print();
    }
}
