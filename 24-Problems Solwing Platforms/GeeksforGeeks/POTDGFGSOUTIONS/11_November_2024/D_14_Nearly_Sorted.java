import java.util.PriorityQueue;
import java.util.Arrays;

public class D_14_Nearly_Sorted {

    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int j = 0, n = arr.length;

        // Add elements to the priority queue and maintain a window of size k
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);
            if (i >= k) {
                arr[j++] = pq.poll();
            }
        }

        // Poll remaining elements from the priority queue
        while (!pq.isEmpty()) {
            arr[j++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        D_14_Nearly_Sorted sorter = new D_14_Nearly_Sorted();
        int[] arr = {2, 6, 3, 12, 56, 8};
        int k = 3;

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        sorter.nearlySorted(arr, k);

        System.out.println("Nearly sorted array:");
        System.out.println(Arrays.toString(arr));
    }
}
