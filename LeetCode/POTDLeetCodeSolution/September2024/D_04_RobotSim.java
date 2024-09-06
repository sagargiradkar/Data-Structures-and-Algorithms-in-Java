import java.util.HashSet;
import java.util.Set;

public class D_04_RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] directions   = {0, 1, 0, -1, 0}; // North, East, South, West
        int currDir = 0; // Initially facing north
        int x = 0, y = 0; // Starting coordinates
        int maxDist = 0;

        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        for (int command : commands)   
 {
            if (command == -2) { // Turn left
                currDir = (currDir + 4 - 1) % 4;
            } else if (command == -1) { // Turn right
                currDir = (currDir + 1) % 4;
            } else { // Move forward
                for (int i = 0; i < command; i++) {
                    int newX = x + directions[currDir];
                    int newY = y + directions[currDir + 1];
                    String key = newX + "," + newY;
                    if (!obstacleSet.contains(key)) {
                        x = newX;
                        y = newY;
                        maxDist = Math.max(maxDist, x * x + y * y);
                    }
                }
            }
        }

        return maxDist;
    }
}