import java.util.Scanner;

public class D_22_K_th_Smallest_Lexicographical {
    
    // This function counts how many numbers are there in the range [prefix, n]
    private long countSteps(long n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
    
    public int findKthNumber(int n, int k) {
        long current = 1; // Start at 1
        k -= 1; // Since we start at 1, we need to find the (k-1)-th step
        
        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            
            if (steps <= k) {
                // If the number of steps under this prefix is less than or equal to k,
                // move to the next sibling (increment the current number)
                current += 1;
                k -= steps; // Reduce k by the number of steps skipped
            } else {
                // If steps is greater than k, go deeper into the current prefix
                current *= 10;
                k -= 1; // We've moved one step forward in this deeper prefix
            }
        }
        
        return (int) current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt(); // Input n

        System.out.print("Enter k: ");
        int k = scanner.nextInt(); // Input k

        D_22_K_th_Smallest_Lexicographical solution = new D_22_K_th_Smallest_Lexicographical();
        int result = solution.findKthNumber(n, k);
        
        System.out.println("The " + k + "-th lexicographically smallest number is: " + result);
        
        scanner.close();
    }
}
