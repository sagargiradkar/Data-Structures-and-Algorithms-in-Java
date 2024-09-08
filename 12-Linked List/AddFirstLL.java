public class AddFirstLL
 {
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
    public static Node  head;
    public static Node  tail;
    public static int size;

    public void addFirst(int data)
    {
        //step1 = create new node 
        Node newNode = new Node(data);
        size ++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 - newNode next = head
        newNode.next = head;

        //step3 - head = newNode;
        head = newNode;

    }
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head == null)
        {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode ;
    }
    public void printLL()
    {
        if(head == null)
        {
            System.out.println("Linked List Is empty");
            return;
        }
        Node temp = head;
        while(temp !=null)
        {
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void add(int idx,int data)
    {
        if(idx == 0)
        {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head ;
        int i = 0;
        while(i < idx-1)
        {
            temp = temp.next;
            i++;
        }

        //i = idx-1 l temp-> prev
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public static void main(String[] args) {
        AddFirstLL ll = new AddFirstLL();
        ll.addFirst(19);
        ll.printLL();
        ll.addFirst(10);
        ll.printLL();
        ll.addFirst(11);
        ll.printLL();
        ll.addLast(67);
        ll.printLL();
        ll.addLast(100);
        ll.add(2, 82);
        ll.printLL();
        System.out.println(ll.size);
    }
}
