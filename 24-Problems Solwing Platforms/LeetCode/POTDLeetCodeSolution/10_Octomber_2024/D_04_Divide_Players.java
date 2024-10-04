import java.util.Arrays;

public class D_04_Divide_Players {
    public long dividePlayers(int[] skill) {
        int n = skill.length;

        Arrays.sort(skill);

        int i = 0;
        int j = n - 1;
        int s = skill[i] + skill[j];

        long chem = 0;

        while (i < j) {
            int currSkill = skill[i] + skill[j];

            if (currSkill != s) {
                return -1;
            }

            chem += (long) skill[i] * skill[j];
            i++;
            j--;
        }
        return chem;
    }

    public static void main(String[] args) {
        // Example test case
        int[] skill = {3, 2, 5, 1, 3, 4};
        
        // Create an object of the class
        D_04_Divide_Players solution = new D_04_Divide_Players();
        
        // Call the dividePlayers method and print the result
        long result = solution.dividePlayers(skill);
        
        // Output the result
        System.out.println("Chemistry: " + result);
    }
}
