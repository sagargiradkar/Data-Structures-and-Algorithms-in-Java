import java.util.PriorityQueue;

public class D_16_Longest_Happy_String {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int a = 1, b = 1, c = 7;
        System.out.println("Test case 1: " + solution.longestDiverseString(a, b, c)); 
        // Expected output: A string where no letter appears three consecutive times, like "ccaccbcc".

        // Test case 2
        a = 2;
        b = 2;
        c = 1;
        System.out.println("Test case 2: " + solution.longestDiverseString(a, b, c)); 
        // Expected output: A string like "aabbc" or any valid variation.

        // Test case 3
        a = 7;
        b = 1;
        c = 0;
        System.out.println("Test case 3: " + solution.longestDiverseString(a, b, c)); 
        // Expected output: A string like "aabaa" or any valid variation.
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // create a pq (decreasing order of element count)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if(a > 0){
            pq.offer(new Pair(a, 'a'));
        }
        if(b > 0){
            pq.offer(new Pair(b, 'b'));
        }
        if(c > 0){
            pq.offer(new Pair(c, 'c'));
        }

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int n = res.length(); 
            char ch = node.ch;
            int count = node.count;

            // if current element is the same as the last two then push the second highest freq element
            if(n >= 2 && res.charAt(n - 1) == ch && res.charAt(n - 2) == ch) {
                if(pq.isEmpty()) break; // if no second highest frequency element, break
                Pair sec = pq.poll();
                res.append(sec.ch);
                sec.count--;
                if(sec.count > 0){
                    pq.offer(new Pair(sec.count, sec.ch));
                }
            } else {
                res.append(node.ch);
                node.count--;
            }

            // if element count is not 0, insert in pq with updated count
            if(node.count > 0){
                pq.offer(new Pair(node.count, node.ch));
            }
        }
        return res.toString();
    }
}

class Pair implements Comparable<Pair> {
    int count;
    char ch;
    Pair(int count, char ch){
        this.count = count;
        this.ch = ch;
    }
    
    public int compareTo(Pair that) {
        return that.count - this.count; // decreasing order of count
    }
}
