public class Q_03_Queue_Using_LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueL {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmplty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmplty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;

            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public static int peek() {
            if (isEmplty()) {
                System.out.println("empty Queue");
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String[] args) {
        QueueL q = new QueueL();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmplty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
