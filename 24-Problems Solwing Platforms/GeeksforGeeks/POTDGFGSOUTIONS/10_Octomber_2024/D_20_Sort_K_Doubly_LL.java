import java.util.PriorityQueue;

class D_20_Sort_K_Doubly_LL {
    
    // Node class representing the doubly linked list node
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            next = prev = null;
        }
    }

    // Method to sort a k-sorted doubly linked list
    public Node sortKSortedDLL(Node head, int k) {
        if (head == null) {
            return null;
        }

        // Priority queue to store the nodes and sort them by value (min-heap)
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        Node newHead = null, last = null;

        // Add the first k+1 elements to the priority queue
        Node curr = head;
        for (int i = 0; i <= k && curr != null; i++) {
            pq.add(curr);
            curr = curr.next;
        }

        // Process the priority queue and rearrange the nodes
        while (!pq.isEmpty()) {
            // Extract the smallest node from the heap
            if (newHead == null) {
                newHead = pq.poll();
                newHead.prev = null;
                last = newHead;
            } else {
                last.next = pq.poll();
                last.next.prev = last;
                last = last.next;
            }

            // Add the next element to the priority queue, if it exists
            if (curr != null) {
                pq.add(curr);
                curr = curr.next;
            }
        }

        last.next = null; // Mark the end of the sorted doubly linked list
        return newHead;
    }

    // Utility method to print the doubly linked list
    public void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        D_20_Sort_K_Doubly_LL list = new D_20_Sort_K_Doubly_LL();

        // Example: create a k-sorted doubly linked list
        Node head = new Node(3);
        head.next = new Node(6);
        head.next.prev = head;
        head.next.next = new Node(2);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(12);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(56);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        int k = 2; // Example: k-sorted with k = 2

        System.out.println("Original Doubly Linked List:");
        list.printList(head);

        Node sortedHead = list.sortKSortedDLL(head, k);

        System.out.println("Sorted Doubly Linked List:");
        list.printList(sortedHead);
    }
}
