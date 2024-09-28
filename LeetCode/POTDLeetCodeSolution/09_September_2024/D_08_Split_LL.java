
public class D_08_Split_LL {
    // Method to split linked list into k parts
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the total length of the linked list
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        // Step 2: Determine the size of each part
        int baseSize = length / k; // Minimum number of nodes in each part
        int extraNodes = length % k; // The number of parts that will have one extra node

        ListNode[] result = new ListNode[k]; // Array to store the resulting parts
        current = head;

        // Step 3: Split the linked list into parts
        for (int i = 0; i < k; i++) {
            ListNode partHead = current;
            ListNode prev = null;
            int partSize = baseSize + (extraNodes > 0 ? 1 : 0); // Extra node for the first 'extraNodes' parts

            // Traverse the current part and disconnect from the rest of the list
            for (int j = 0; j < partSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }

            // If there is a previous node, disconnect this part from the next
            if (prev != null) {
                prev.next = null;
            }

            // Assign this part to the result array
            result[i] = partHead;

            // Decrease the number of extra nodes after assigning one
            if (extraNodes > 0) {
                extraNodes--;
            }
        }

        return result;
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Example 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        int k1 = 5;
        D_08_Split_LL solution1 = new D_08_Split_LL();
        ListNode[] result1 = solution1.splitListToParts(head1, k1);
        System.out.println("Example 1:");
        for (ListNode part : result1) {
            solution1.printList(part); // Print each part of the split list
        }

        // Example 2
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10))))))))));
        int k2 = 3;
        D_08_Split_LL solution2 = new D_08_Split_LL();
        ListNode[] result2 = solution2.splitListToParts(head2, k2);
        System.out.println("Example 2:");
        for (ListNode part : result2) {
            solution2.printList(part); // Print each part of the split list
        }
    }
}

// Definition of the ListNode class
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
