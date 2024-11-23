class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class D_13_Intersect_Point {

    static int findLength(Node head) {
        Node temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    // Function to find intersection point in Y-shaped Linked Lists.
    int intersectPoint(Node head1, Node head2) {
        int len1 = findLength(head1);
        int len2 = findLength(head2);

        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }
        while (len2 > len1) {
            head2 = head2.next;
            len2--;
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Create two linked lists that intersect
        Node common = new Node(15);
        common.next = new Node(30);

        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = common;

        Node head2 = new Node(5);
        head2.next = common;

        D_13_Intersect_Point solution = new D_13_Intersect_Point();
        int intersectionPoint = solution.intersectPoint(head1, head2);

        if (intersectionPoint != -1) {
            System.out.println("The intersection point is: " + intersectionPoint);
        } else {
            System.out.println("There is no intersection point.");
        }
    }
}