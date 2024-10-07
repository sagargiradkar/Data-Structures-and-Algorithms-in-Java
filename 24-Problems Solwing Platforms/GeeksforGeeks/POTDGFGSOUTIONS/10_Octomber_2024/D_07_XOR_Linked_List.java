import java.util.*;

class Node {
    int data;
    Node npx;  // XOR of next and previous node

    Node(int x) {
        data = x;
        npx = null;
    }
}

public class D_07_XOR_Linked_List {
    // Utility function to get XOR of two Node references
    public static Node XOR(Node a, Node b) {
        return a == null ? b : (b == null ? a : xorMap.get(a) == b ? null : b); 
    }

    // Map to simulate XOR pointers
    static Map<Node, Node> xorMap = new HashMap<>();

    // Function to insert node to the front of the list
    public static Node insert(Node head, int data) {
        Node temp = new Node(data);
        temp.npx = head;

        if (head != null) {
            head.npx = XOR(temp, head.npx);
        }

        xorMap.put(temp, head); // Simulating XOR pointer by mapping nodes
        return temp;
    }

    // Function to get list of elements from the XOR linked list
    public static List<Integer> getList(Node head) {
        List<Integer> ans = new ArrayList<>();
        Node curr = head, prev = null, next;

        while (curr != null) {
            ans.add(curr.data);
            next = XOR(prev, curr.npx); // XOR to get the next node
            prev = curr;
            curr = next;
        }

        return ans;
    }

    // Main method to test the XOR linked list
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            Node head = null;
            String input = sc.nextLine();
            String[] numbers = input.split(" ");

            for (String numStr : numbers) {
                int number = Integer.parseInt(numStr);
                head = insert(head, number);
            }

            List<Integer> forwardList = getList(head);

            // Print forward list
            for (int x : forwardList) {
                System.out.print(x + " ");
            }
            System.out.println();

            // Print reverse list
            for (int i = forwardList.size() - 1; i >= 0; i--) {
                System.out.print(forwardList.get(i) + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
