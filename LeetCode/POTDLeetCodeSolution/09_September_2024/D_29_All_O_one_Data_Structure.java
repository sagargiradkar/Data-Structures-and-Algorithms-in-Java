import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class Node {
    Node next;
    Node prev;
    int freq;
    HashSet<String> keys;

    Node(int f) {
        next = null;
        prev = null;
        freq = f;
        keys = new HashSet<>();
    }
}

class AllOne {
    HashMap<String, Node> map;
    Node head;
    Node tail;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }

    public void inc(String key) {
        Node curr = head;
        int newFreq = 1;

        if (map.containsKey(key)) {
            curr = map.get(key);
            newFreq = curr.freq + 1;
            curr.keys.remove(key);
        }

        if (curr.next.freq == newFreq) {
            curr.next.keys.add(key);
        } else {
            Node node = new Node(newFreq);
            node.keys.add(key);
            insertNode(curr, node);
        }

        map.put(key, curr.next);

        if (curr.keys.size() == 0 && curr != head) {
            removeNode(curr);
        }
    }

    public void dec(String key) {
        Node curr = map.get(key);
        int newFreq = curr.freq - 1;
        curr.keys.remove(key);

        if (newFreq == 0) {
            if (curr.keys.size() == 0) {
                removeNode(curr);
            }
            map.remove(key);
            return;
        }

        if (curr.prev.freq == newFreq) {
            curr.prev.keys.add(key);
        } else {
            Node node = new Node(newFreq);
            node.keys.add(key);
            insertNode(curr.prev, node);
        }

        map.put(key, curr.prev);

        if (curr.keys.size() == 0 && curr != head) {
            removeNode(curr);
        }
    }

    private void insertNode(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }

    private void removeNode(Node curr) {
        Node nextNode = curr.next;
        Node prevNode = curr.prev;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        curr.next = null;
        curr.prev = null;
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        } else {
            Iterator<String> it = tail.prev.keys.iterator();
            return it.hasNext() ? it.next() : "";
        }
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            Iterator<String> it = head.next.keys.iterator();
            return it.hasNext() ? it.next() : "";
        }
    }
}

public class D_29_All_O_one_Data_Structure {

    public static void main(String[] args) {
        AllOne allOne = new AllOne();
        
        allOne.inc("hello");
        allOne.inc("hello");
        allOne.inc("world");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("leet");

        System.out.println("Max Key: " + allOne.getMaxKey()); // Should return "hello"
        System.out.println("Min Key: " + allOne.getMinKey()); // Should return "code"

        allOne.dec("hello");
        allOne.dec("hello");

        System.out.println("Max Key: " + allOne.getMaxKey()); // Should return "leet"
        System.out.println("Min Key: " + allOne.getMinKey()); // Should return "code"
    }
}
