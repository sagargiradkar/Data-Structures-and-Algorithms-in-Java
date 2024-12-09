/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* You may add any imports here, if you wish, but only from the 
   standard library */

public class Main2 {
    public static int processArray(ArrayList<Integer> array) {
        /* 
         * Modify this function to process `array` as indicated
         * in the question. At the end, return the appropriate
         * value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method
         *
         * Submit this entire program (not just this function)
         * as your answer
         */
        int count = 0;
        int consecutiveEvenCount = 0;

        for (int num : array) {
            if (num % 2 == 0) { // Check if the number is even
                consecutiveEvenCount++;
            } else {
                if (consecutiveEvenCount >= 3) {
                    count++;
                }
                consecutiveEvenCount = 0; // Reset for the next sequence
            }
        }

        // Check at the end of the loop in case the last sequence ends with even numbers
        if (consecutiveEvenCount >= 3) {
            count++;
        }

        return count;

    }

    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int num = in.nextInt();
            if (num < 0) 
                break;
            arrayList.add(new Integer(num));
        }
        int result = processArray(arrayList);
        System.out.println(result);
    }
}
