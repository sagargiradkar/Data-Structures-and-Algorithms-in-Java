import java.util.*;

public class D_12_Pick_Gifts {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] gifts = {25, 64, 9, 4};
        int k = 4;
        System.out.println("Maximum remaining gifts: " + solution.pickGifts(gifts, k));
    }
}

class Solution {

    public long pickGifts(int[] gifts, int k) {
        
        List<Integer> giftsList = new ArrayList<>();
        for (int gift : gifts) {
            giftsList.add(-gift);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(giftsList);
        while(k-- > 0) {
            
            int maxElement = -pq.poll();

            pq.offer(-(int) Math.sqrt(maxElement));
        }

        // Accumulate the sum of the elements in the heap
        long numberOfRemainingGifts = 0;
        while (!pq.isEmpty()) {
            numberOfRemainingGifts -= pq.poll(); //since it's negative, it will become positive with -ve sign
        }

        return numberOfRemainingGifts;
    }
}
