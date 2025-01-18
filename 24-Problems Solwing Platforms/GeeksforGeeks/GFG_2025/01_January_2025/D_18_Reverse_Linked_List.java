// D_18_Reverse_Linked_List.java

class D_18_Reverse_Linked_List {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = createLinkedList(new int[]{1, 2, 3, 4, 5});

        System.out.println("Original Linked List:");
        printLinkedList(head);

        // Reverse the linked list
        Node reversedHead = solution.reverseList(head);

        System.out.println("Reversed Linked List:");
        printLinkedList(reversedHead);
    }

    // Utility function to create a linked list from an array
    public static Node createLinkedList(int[] values) {
        if (values.length == 0) return null;

        Node head = new Node(values[0]);
        Node current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }

        return head;
    }

    // Utility function to print a linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Definition for singly-linked list node
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Solution class containing the reverseList method
class Solution {
    Node reverseList(Node head) {
        Node prev = null; // To store the previous node
        Node curr = head; // Start with the head of the list
        
        while (curr != null) {
            Node next = curr.next; // Temporarily store the next node
            curr.next = prev;      // Reverse the current node's pointer
            prev = curr;           // Move 'prev' one step forward
            curr = next;           // Move 'curr' one step forward
        }
        
        return prev; // 'prev' is the new head of the reversed list
    }
}
