public class LinkedLists {
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

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
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
    public void printLL()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void add(int indx,int data)
    {
        if(indx == 0)
        {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        while(i < indx-1)
        {
            temp = temp.next;
            i++;
        }
        //i=idx-1; temp -< prev
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();
        ll.addFirst(1);
        ll.printLL();
        ll.addFirst(2);
        ll.printLL();
        ll.addFirst(3);
        ll.printLL();
        ll.addLast(4);
        ll.printLL();
        ll.addLast(13);
        ll.printLL();
        ll.addFirst(123);
        ll.printLL();
        ll.add(3, 134);
        ll.printLL();
    }
}
