public class LL_04_AddLastLL {
    public static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static Node head = null;
    public static Node tail = null;

    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;

        tail = newNode;
    }
    public static void main(String[] args) {
        LL_04_AddLastLL ll = new LL_04_AddLastLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
    }
}
