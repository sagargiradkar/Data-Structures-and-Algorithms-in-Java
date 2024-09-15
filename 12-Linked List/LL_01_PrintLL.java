public class LL_01_PrintLL {

    public static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    } 
    public static Node head = null;
    public static Node tail = null;

    public void print()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LL_01_PrintLL ll = new LL_01_PrintLL();
        ll.print();
    }
}
