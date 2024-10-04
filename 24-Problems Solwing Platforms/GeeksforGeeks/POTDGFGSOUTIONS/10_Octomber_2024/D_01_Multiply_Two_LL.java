class D_01_Multiply_Two_LL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public long multiplyTwoLists(Node first, Node second) {
        long num1 = 0, num2 = 0;
        int mod = 1000000007;

        Node temp = first;
        while (temp != null) {
            num1 = (num1 * 10 + temp.data) % mod;
            temp = temp.next;
        }

        temp = second;
        while (temp != null) {
            num2 = (num2 * 10 + temp.data) % mod;
            temp = temp.next;
        }

        return (num1 * num2) % mod;
    }

    public static void main(String[] args) {
        // Creating first linked list: 1 -> 0 -> 0
        Node first = new Node(1);
        first.next = new Node(0);
        first.next.next = new Node(0);

        // Creating second linked list: 1 -> 0
        Node second = new Node(1);
        second.next = new Node(0);

        // Creating an object of the class
        D_01_Multiply_Two_LL obj = new D_01_Multiply_Two_LL();

        // Calling the multiplyTwoLists method
        long result = obj.multiplyTwoLists(first, second);

        // Printing the result
        System.out.println(result);
    }
}
