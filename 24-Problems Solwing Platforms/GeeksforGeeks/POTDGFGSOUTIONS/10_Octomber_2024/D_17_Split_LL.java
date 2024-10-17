public class D_17_Split_LL {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        
        Node[] result = solution.alternatingSplitList(head);
        
        // Print first list
        System.out.println("List 1: ");
        printList(result[0]);
        
        // Print second list
        System.out.println("List 2: ");
        printList(result[1]);
    }
    
    // Utility function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Solution {
    // Function to split linked list into two alternating lists
    Node[] alternatingSplitList(Node head) {
        Node head1 = null, head2 = null, temp1 = null, temp2 = null;
        int count = 0;
        
        while (head != null) {
            if (count % 2 == 1) {
                if (head2 == null) {
                    head2 = head;
                    temp2 = head;
                } else {
                    temp2.next = head;
                    temp2 = temp2.next;
                }
            } else {
                if (head1 == null) {
                    head1 = head;
                    temp1 = head;
                } else {
                    temp1.next = head;
                    temp1 = temp1.next;
                }
            }
            head = head.next;
            count++;
        }
        
        // Terminate the two lists
        if (temp1 != null) temp1.next = null;
        if (temp2 != null) temp2.next = null;
        
        Node ans[] = new Node[2];
        ans[0] = head1;
        ans[1] = head2;
        return ans;
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
