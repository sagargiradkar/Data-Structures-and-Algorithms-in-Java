public class AddDataLL
{
    public static class Node {
        int data ;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null;
    public void addData(int data )
    {
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;

        head = newNode;
    }
   

  public static void main(String[] args) {
    AddDataLL ll = new AddDataLL();
    ll.addData(1);
    ll.addData(2);
    ll.addData(3);
  }
}