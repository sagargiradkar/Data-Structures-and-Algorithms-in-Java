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
    public static int size;
    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        size++;
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
        size++;
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
        size++;
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
    public int removeFirst()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast()
    {
        if(size == 0)
        {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //prev : indx = size - 2;
        Node prev = head;
        for(int i=0 ; i<size-2;i++)
        {
            prev = prev.next;
        }

        int val = prev.next.data; //tail.data
        prev.next = null;
        tail = prev;
        size --;
        return val;
    }
    public int itrSearch(int key)
    {
        Node temp = head;
        int i = 0;

        while(temp != null)
        {
            if(temp.data == key)
            {
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
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
        System.out.println("Size of LL :: "+ll.size);
        ll.printLL();
        System.out.println("removeFirst of LL :: "+ll.removeFirst());
        System.out.println("Size of LL :: "+ll.size);
        ll.printLL();
        System.out.println("removeLast of LL :: "+ll.removeLast());
        ll.printLL();
        System.out.println("Size of LL :: "+ll.size);
        if(ll.itrSearch(44) == -1){
            System.out.println("Key Not Found");
        }else{
            System.out.println("Key is found");
        }
    }
}
