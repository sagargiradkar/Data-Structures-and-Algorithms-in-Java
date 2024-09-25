class D_25_LL_IsPalindrome {

    public static void main(String[] args) {
        // Test Case 1: Palindrome list (odd number of nodes)
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(2);
        head1.next.next.next.next = new Node(1);
        runTestCase(head1, "Test Case 1");  // Expected output: true

        // Test Case 2: Palindrome list (even number of nodes)
        Node head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(2);
        head2.next.next.next = new Node(1);
        runTestCase(head2, "Test Case 2");  // Expected output: true

        // Test Case 3: Non-palindrome list
        Node head3 = new Node(1);
        head3.next = new Node(2);
        head3.next.next = new Node(3);
        runTestCase(head3, "Test Case 3");  // Expected output: false

        // Test Case 4: Single element list (palindrome)
        Node head4 = new Node(1);
        runTestCase(head4, "Test Case 4");  // Expected output: true

        // Test Case 5: Empty list (palindrome)
        Node head5 = null;
        runTestCase(head5, "Test Case 5");  // Expected output: true
    }

    // Helper method to run a test case
    private static void runTestCase(Node head, String testCaseName) {
        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);
        System.out.println(testCaseName + " - Is Palindrome? " + result);
    }
}

class Solution {
    // Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;  // A single node or empty list is a palindrome
        }
        
        // Step 1: Find the middle of the linked list
        Node slow = head;
        Node fast = head;
        
        // Move slow to the middle, and fast to the end
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Step 2: Reverse the second half of the linked list
        Node secondHalf = reverseList(slow);
        Node firstHalf = head;
        
        // Step 3: Compare the first half and the reversed second half
        Node secondHalfCopy = secondHalf;  // For restoring the list later (optional)
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;  // The linked list is not a palindrome
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        // Step 4: Restore the second half (optional)
        reverseList(secondHalfCopy);
        
        return true;  // The linked list is a palindrome
    }
    
    // Helper function to reverse the linked list
    Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;  // New head of the reversed list
    }
}

// Node class
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
