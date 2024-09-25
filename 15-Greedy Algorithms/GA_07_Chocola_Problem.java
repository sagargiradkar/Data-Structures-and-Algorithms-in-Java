import java.util.*;

public class GA_07_Chocola_Problem {

    public static void main(String[] args) {
        int n = 4, m = 4;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        // Sort both cost arrays in decreasing order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;  // Initially, there's 1 segment horizontally and vertically
        int cost = 0;

        // Greedily choose the most expensive cut until one of the arrays is fully used
        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) { // Choose horizontal cut
                cost += costHor[h] * vp;
                hp++; // Number of horizontal pieces increases
                h++;
            } else { // Choose vertical cut
                cost += costVer[v] * hp;
                vp++; // Number of vertical pieces increases
                v++;
            }
        }

        // Process remaining horizontal cuts
        while (h < costHor.length) {
            cost += costHor[h] * vp;
            hp++;
            h++;
        }

        // Process remaining vertical cuts
        while (v < costVer.length) {
            cost += costVer[v] * hp;
            vp++;
            v++;
        }

        // Output the final cost of making all the cuts
        System.out.println("Final Cost of Cuts :: " + cost);
    }
}
