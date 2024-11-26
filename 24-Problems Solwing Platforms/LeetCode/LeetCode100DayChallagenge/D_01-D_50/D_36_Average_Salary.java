public class D_36_Average_Salary {

    public static void main(String[] args) {

        // Example usage:
        int[] salary1 = { 40000, 30000, 100000 };
        double average1 = average(salary1);
        System.out.println("Average salary (excluding highest and lowest): $" + average1); // Output: $50000.0

        int[] salary2 = { 60000, 50000, 70000 };
        double average2 = average(salary2);
        System.out.println("Average salary (excluding highest and lowest): $" + average2); // Output: $60000.0
    }

    public static double average(int[] salary) {
        if (salary.length < 2) {
            return 0.0; // Handle cases with less than 2 elements
        }

        int max = salary[0];
        int min = salary[0];
        int sum = salary[0];

        for (int i = 1; i < salary.length; i++) {
            if (max < salary[i]) {
                max = salary[i];
            }

            if (min > salary[i]) {
                min = salary[i];
            }

            sum += salary[i];
        }

        sum = sum - min - max;
        double ans = (double) sum / (salary.length - 2);
        return ans;
    }
}