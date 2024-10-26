import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int a) {
        data = a;
        next = null;
    }
}

class Solution {
    public static int count(Node head, int key) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                count++;
            }
            current = current.next;
        }

        return count;
    }
}

public class D_26_Count_Integer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while (t-- > 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            
            Node head = new Node(arr.get(0));
            Node tail = head;
            
            for (int i = 1; i < arr.size(); ++i) {
                tail.next = new Node(arr.get(i));
                tail = tail.next;
            }
            
            int key = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            System.out.println(ob.count(head, key));
        }
    }
}