import java.util.ArrayList;
import java.util.Collections;

public class GA_06_Job_Sequencing {
    static class Job {
        int deadline;
        int profit;
        int id;

        // Constructor for Job
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;  // Correct the variable name here
        }
    }

    public static void main(String[] args) {
        // Array containing job deadline and profit information
        int jobInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        // Add jobs to the ArrayList
        for (int i = 0; i < jobInfo.length; i++) {
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }

        // Sort jobs in decreasing order of profit
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;

        // Select jobs based on deadlines and profit
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        // Output the result
        System.out.println("Max Jobs = " + seq.size());
        for (int i = 0; i < seq.size(); i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}
