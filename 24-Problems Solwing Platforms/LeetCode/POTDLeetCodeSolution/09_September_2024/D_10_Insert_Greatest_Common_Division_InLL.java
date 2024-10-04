public class D_10_Insert_Greatest_Common_Division_InLL {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        // Default constructor
        public ListNode() {}

        // Constructor with value only
        public ListNode(int val) {
            this.val = val;
        }

        // Constructor with value and next node
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // Function to print the linked list
        public void printList() {
            ListNode temp = this;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Solution class containing the logic to insert GCD nodes
    public static class Solution {

        // Function to find GCD of two numbers
        public int findGCD(int a, int b) {
            if (b == 0) return a;
            return findGCD(b, a % b);
        }

        // Function to insert GCD nodes between every pair of consecutive nodes
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode cur = head;

            while (cur.next != null) {
                int max = Math.max(cur.val, cur.next.val);
                int min = Math.min(cur.val, cur.next.val);
                int gcd = findGCD(max, min);

                // Insert a new node with the GCD value between cur and cur.next
                ListNode gcdNode = new ListNode(gcd);
                gcdNode.next = cur.next;
                cur.next = gcdNode;
                cur = gcdNode.next;  // Move cur to the next pair of nodes
            }

            return head;
        }
    }

    // Main method to test the logic
    public static void main(String[] args) {
        // Creating a linked list: 18 -> 12 -> 30 -> 24
        ListNode head = new ListNode(18);
        head.next = new ListNode(12);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(24);

        System.out.print("Original List: ");
        head.printList();

        // Applying the solution
        Solution solution = new Solution();
        ListNode modifiedHead = solution.insertGreatestCommonDivisors(head);

        System.out.print("Modified List with GCDs: ");
        modifiedHead.printList();  // Expected output: 18 -> 6 -> 12 -> 6 -> 30 -> 6 -> 24
    }
}
