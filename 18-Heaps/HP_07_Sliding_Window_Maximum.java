import java.util.PriorityQueue;

public class HP_07_Sliding_Window_Maximum {
    static class Pair implements Comparable<Pair>{
        int val;
        int idx;

        public Pair(int val, int idx) {  // Fixed order here
            this.idx = idx;
            this.val = val;
        }
        @Override
        public int compareTo(Pair p2){
            // Descending order
            return p2.val - this.val;
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Add first 'k' elements
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // Add the maximum of the first window
        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            // Remove elements not in the sliding window
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                pq.remove();
            }

            // Add the current element
            pq.add(new Pair(arr[i], i));

            // The top element is the max of the current window
            res[i - k + 1] = pq.peek().val;
        }

        // Print the result array
        for (int i = 0; i < res.length; i++) {
            System.out.print(" " + res[i] + " ");
        }
    }
}
