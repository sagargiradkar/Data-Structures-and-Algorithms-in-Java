class D_13_Delete_Alternate_Node {

    // Node class to define a linked list node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Method to delete alternate nodes from the linked list
    public void deleteAlt(Node head) {
        while (head != null && head.next != null) {
            head.next = head.next.next;
            head = head.next;
        }
    }

    // Method to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        D_13_Delete_Alternate_Node list = new D_13_Delete_Alternate_Node();

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original list:");
        list.printList(head);

        // Deleting alternate nodes
        list.deleteAlt(head);

        System.out.println("List after deleting alternate nodes:");
        list.printList(head);
    }
}
