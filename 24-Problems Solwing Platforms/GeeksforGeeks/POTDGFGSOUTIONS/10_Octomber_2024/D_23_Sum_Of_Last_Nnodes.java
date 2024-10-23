class D_23_Sum_Of_Last_Nnodes {

    // Node class representing each node in the linked list
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    // Method to calculate the sum of the last N nodes
    public int sumOfLastN_Nodes(Node head, int n) {
        Node temp = head;
        int count = 0, sum = 0;

        // Counting the total number of nodes
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Start summing from the last N nodes
        count -= n;
        temp = head;
        while (temp != null) {
            if (count == 0) sum += temp.data;
            else count--;
            temp = temp.next;
        }

        return sum;
    }

    // Main method to test the sumOfLastN_Nodes method
    public static void main(String[] args) {
        D_23_Sum_Of_Last_Nnodes list = new D_23_Sum_Of_Last_Nnodes();
        
        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 3;  // Define how many last nodes to sum
        
        // Call the method and display the result
        int result = list.sumOfLastN_Nodes(head, n);
        System.out.println("Sum of last " + n + " nodes is: " + result);
    }
}