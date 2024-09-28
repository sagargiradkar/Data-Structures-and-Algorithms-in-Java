import java.util.PriorityQueue;

public class HP_04_Nearest_Cars {

    static class Point implements Comparable<Point> {

        int x;
        int y;
        int distSq;
        int idx;

        public Point(int distSq, int idx, int x, int y) {
            this.distSq = distSq;
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p2) {
            return this.distSq - p2.distSq; // ascending
        }
    }

    public static void main(String[] args) {
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1]; // Corrected this line
            pq.add(new Point(distSq, i, pts[i][0], pts[i][1]));
        }

        // Nearest K cars
        for (int i = 0; i < k; i++) {
            Point nearestCar = pq.remove();
            System.out.println("Car index -> " + nearestCar.idx + " located at (" + nearestCar.x + "," + nearestCar.y + ")");
        }
    }
}
