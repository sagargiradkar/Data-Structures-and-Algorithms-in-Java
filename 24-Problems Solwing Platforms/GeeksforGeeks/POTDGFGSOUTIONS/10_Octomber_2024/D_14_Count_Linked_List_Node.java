class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}

public class D_14_Count_Linked_List_Node {
    public static void main(String[] args) {
        // Creating the linked list with 3 nodes.
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // Creating an instance of Solution class.
        Solution solution = new Solution();

        // Calling the getCount method and printing the result.
        int count = solution.getCount(head);
        System.out.println("Count of nodes in the linked list: " + count);
    }
}
