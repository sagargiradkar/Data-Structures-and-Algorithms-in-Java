import java.util.*;

class Point2D {
    public int x;
    public int y;
    
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(Point2D[] points, int perimeter) {
        // If there are no points or invalid perimeter, return 0
        if (points == null || points.length == 0 || perimeter % 2 != 0) {
            return 0;
        }
        
        // Total number of points
        int N = points.length;
        
        // Set of all x and y coordinates to consider as bounds for rectangle edges
        Set<Integer> uniqueX = new HashSet<>();
        Set<Integer> uniqueY = new HashSet<>();
        
        for (Point2D point : points) {
            uniqueX.add(point.x);
            uniqueY.add(point.y);
        }
        
        // List of all unique x and y coordinates
        List<Integer> xCoordinates = new ArrayList<>(uniqueX);
        List<Integer> yCoordinates = new ArrayList<>(uniqueY);
        
        // The target half-perimeter for the sides of the rectangle
        int halfPerimeter = perimeter / 2;
        int maxCoveredPoints = 0;

        // Iterate over all possible rectangle side lengths (length + width = halfPerimeter)
        for (int length = 1; length < halfPerimeter; length++) {
            int width = halfPerimeter - length;
            
            // Try placing the rectangle at all pairs of (x1, y1) as bottom-left corners
            for (int x1 : xCoordinates) {
                for (int y1 : yCoordinates) {
                    int x2 = x1 + length;
                    int y2 = y1 + width;
                    
                    // Count how many points lie inside or on the edges of the rectangle
                    int coveredPoints = 0;
                    for (Point2D point : points) {
                        if (point.x >= x1 && point.x <= x2 && point.y >= y1 && point.y <= y2) {
                            coveredPoints++;
                        }
                    }
                    
                    // Update maximum covered points
                    maxCoveredPoints = Math.max(maxCoveredPoints, coveredPoints);
                }
            }
        }
        
        return maxCoveredPoints;
    }
}

public class B_01_Area_Point_Covered {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        Point2D[] points1 = {
            new Point2D(1, 1), new Point2D(1, 2), new Point2D(2, 2), 
            new Point2D(2, 3)
        };
        int perimeter1 = 10;
        System.out.println("Test Case 1: " + solution.solution(points1, perimeter1));  // Expected: 3

        // Test Case 2
        Point2D[] points2 = {
            new Point2D(0, 0), new Point2D(0, 1), new Point2D(1, 1), 
            new Point2D(1, 0), new Point2D(2, 2)
        };
        int perimeter2 = 8;
        System.out.println("Test Case 2: " + solution.solution(points2, perimeter2));  // Expected: 4

        // Test Case 3
        Point2D[] points3 = {
            new Point2D(3, 3), new Point2D(3, 4), new Point2D(4, 3), 
            new Point2D(5, 5)
        };
        int perimeter3 = 12;
        System.out.println("Test Case 3: " + solution.solution(points3, perimeter3));  // Expected: 3

        // Test Case 4
        Point2D[] points4 = {
            new Point2D(0, 0), new Point2D(1, 1), new Point2D(2, 2), 
            new Point2D(3, 3)
        };
        int perimeter4 = 14;
        System.out.println("Test Case 4: " + solution.solution(points4, perimeter4));  // Expected: 3

        // Test Case 5
        Point2D[] points5 = {
            new Point2D(0, 0), new Point2D(0, 1), new Point2D(1, 1), 
            new Point2D(1, 2), new Point2D(2, 1), new Point2D(2, 2)
        };
        int perimeter5 = 10;
        System.out.println("Test Case 5: " + solution.solution(points5, perimeter5));  // Expected: 5
    }
}
