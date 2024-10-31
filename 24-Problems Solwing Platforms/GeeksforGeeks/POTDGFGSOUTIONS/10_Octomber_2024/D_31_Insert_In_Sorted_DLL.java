import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class D_31_Insert_In_Sorted_DLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases
        sc.nextLine(); // Consume newline

        while (t-- > 0) {
            String input = sc.nextLine(); // Read the entire line for the DLL elements
            String[] values = input.split(" ");

            Node head = null, tail = null;
            for (String value : values) {
                int x = Integer.parseInt(value);
                if (head == null) {
                    head = new Node(x);
                    tail = head;
                } else {
                    tail.next = new Node(x);
                    tail.next.prev = tail;
                    tail = tail.next;
                }
            }

            int valueToInsert = sc.nextInt();
            if (sc.hasNextLine()) {
                sc.nextLine(); // Consume newline after reading the value
            }

            Solution obj = new Solution();
            head = obj.sortedInsert(head, valueToInsert);
            printList(head);
        }
        
        sc.close();
    }

    // Method to print the doubly linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Solution {
    public Node sortedInsert(Node head, int x) {
        Node newNode = new Node(x);

        // Case 1: Empty list
        if (head == null) {
            return newNode;
        }

        // Case 2: Insert at the beginning if x is smaller than the head's data
        if (x <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        // Case 3: Traverse the list to find the correct position
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        // Case 4: Insert in between or at the end
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;

        return head;
    }
}
