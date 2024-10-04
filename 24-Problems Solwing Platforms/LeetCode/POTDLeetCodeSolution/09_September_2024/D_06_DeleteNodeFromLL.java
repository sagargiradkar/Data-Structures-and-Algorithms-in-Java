import java.util.HashSet;
import java.util.Scanner;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    
    // Constructors for ListNode
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class D_06_DeleteNodeFromLL {

    // Solution class containing the method to modify the list
    static class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {
            // Step 1: Store all nums in a HashSet for O(1) lookup
            HashSet<Integer> toDelete = new HashSet<>();
            for (int num : nums) {
                toDelete.add(num);
            }

            // Step 2: Create a dummy node to handle cases where head is to be removed
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // Step 3: Initialize pointers
            ListNode current = head;
            ListNode prev = dummy;

            // Step 4: Traverse the linked list
            while (current != null) {
                if (toDelete.contains(current.val)) {
                    // Skip the current node if it should be deleted
                    prev.next = current.next;
                } else {
                    // Move the prev pointer
                    prev = current;
                }
                // Move to the next node
                current = current.next;
            }

            // Return the modified list's head (dummy.next skips over the dummy node)
            return dummy.next;
        }
    }

    // Helper method to create a linked list from an array
    public static ListNode createLinkedList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print the linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the linked list values
        System.out.print("Enter the number of elements in the linked list: ");
        int n = sc.nextInt();
        int[] linkedListValues = new int[n];
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            linkedListValues[i] = sc.nextInt();
        }

        // Create the linked list
        ListNode head = createLinkedList(linkedListValues);

        // Input the values to delete
        System.out.print("Enter the number of elements to delete: ");
        int m = sc.nextInt();
        int[] deleteValues = new int[m];
        System.out.println("Enter the elements to delete:");
        for (int i = 0; i < m; i++) {
            deleteValues[i] = sc.nextInt();
        }

        // Modify the list
        Solution solution = new Solution();
        ListNode modifiedHead = solution.modifiedList(deleteValues, head);

        // Output the modified list
        System.out.println("Modified linked list:");
        printLinkedList(modifiedHead);

        sc.close();
    }
}
