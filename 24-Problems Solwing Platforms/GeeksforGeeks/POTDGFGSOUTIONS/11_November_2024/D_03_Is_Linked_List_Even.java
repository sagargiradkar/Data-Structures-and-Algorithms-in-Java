import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public boolean isLengthEven(Node head) {
        Node current = head;
        boolean isEven = true; // Assume list length starts as even

        while (current != null) {
            isEven = !isEven; // Toggle even/odd
            current = current.next;
        }

        return isEven;
    }
}

public class D_03_Is_Linked_List_Even {
    static Node insert(Node head, int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
        return head;
    }

    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of test cases: ");
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            Node head = null;
            System.out.print("Enter elements of linked list: ");
            String[] str = read.readLine().trim().split(" ");
            int listSize = str.length;
            for (int i = 0; i < listSize; i++) {
                head = insert(head, Integer.parseInt(str[i]));
            }

            boolean isEven = new Solution().isLengthEven(head);
            System.out.println(isEven ? "true" : "false");
        }
    }
}
