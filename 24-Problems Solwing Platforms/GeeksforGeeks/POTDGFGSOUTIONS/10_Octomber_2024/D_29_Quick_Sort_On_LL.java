class D_29_Quick_Sort_On_LL {
    
    // Definition for a linked list node
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Partition function for quicksort on linked list
    static void partition(Node pivot, Node left[], Node right[]) {
        Node temp = pivot.next;
        while(temp != null) {
            Node nxt = temp.next;
            if(temp.data <= pivot.data) {
                temp.next = left[0];
                left[0] = temp;
            } else {
                temp.next = right[0];
                right[0] = temp;
            }
            temp = nxt;
        }
    }

    // Quicksort function for linked list
    public static Node quickSort(Node node) {
        if(node == null || node.next == null) return node;
        Node left[] = new Node[1];
        Node right[] = new Node[1];
        partition(node, left, right);
        left[0] = quickSort(left[0]);
        right[0] = quickSort(right[0]);
        
        Node traversal = left[0];
        while(traversal != null && traversal.next != null) traversal = traversal.next;
        
        if(traversal != null) traversal.next = node;
        else left[0] = node;
        
        node.next = right[0];
        return left[0];
    }

    // Utility function to print linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        // Creating linked list 3 -> 5 -> 8 -> 2 -> 1
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(8);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println("Original List:");
        printList(head);

        // Sorting the linked list
        head = quickSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
