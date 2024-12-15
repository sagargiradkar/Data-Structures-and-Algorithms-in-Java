public class D_15_Max_Average_Ratio {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        System.out.println("Maximum Average Pass Ratio: " + solution.maxAverageRatio(classes1, extraStudents1));
        // Expected output: 0.78333

        // Example 2
        int[][] classes2 = {{2, 4}, {3, 9}, {4, 5}};
        int extraStudents2 = 1;
        System.out.println("Maximum Average Pass Ratio: " + solution.maxAverageRatio(classes2, extraStudents2));
        // Expected output: 0.63492

        // Example 3
        int[][] classes3 = {{5, 7}, {3, 4}, {6, 10}};
        int extraStudents3 = 3;
        System.out.println("Maximum Average Pass Ratio: " + solution.maxAverageRatio(classes3, extraStudents3));
        // Expected output: varies based on allocation.
    }
}

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Priority queue to act as a max-heap, storing pairs of {max-delta, index}
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Initialize the priority queue with the delta values and indices
        for (int i = 0; i < n; i++) {
            double currentPR = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0] + 1) / (classes[i][1] + 1);
            double delta = newPR - currentPR;
            pq.offer(new double[]{delta, i});
        }

        // Allocate extra students
        while (extraStudents-- > 0) {
            // Extract the class with the maximum delta
            double[] curr = pq.poll();
            int idx = (int) curr[1];

            // Update the class with an extra student
            classes[idx][0]++;
            classes[idx][1]++;

            // Recalculate the delta for this class
            double currentPR = (double) classes[idx][0] / classes[idx][1];
            double newPR = (double) (classes[idx][0] + 1) / (classes[idx][1] + 1);
            double delta = newPR - currentPR;

            // Push the updated delta and index back into the priority queue
            pq.offer(new double[]{delta, idx});
        }

        // Calculate the final average pass ratio
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += (double) classes[i][0] / classes[i][1];
        }

        return result / n;
    }
}
