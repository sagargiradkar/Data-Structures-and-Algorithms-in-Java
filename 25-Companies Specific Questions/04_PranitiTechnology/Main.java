/* Save this in a file called Main.java to compile and test it */

import java.util.*;
import java.io.*;

public class Main {
    public static int processArray(ArrayList<Integer> array) {
        /* 
         * Do not make any changes outside this method.
         *
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the new size of the
         * array. 
         *
         * Do not print anything in this method
         *
         * Submit this entire program (not just this function)
         * as your answer
         */
         // Iterate over the array and modify based on hot and cold number conditions
         for (int i = 0; i < array.size(); i++) {
            int num = array.get(i);
            
            // Check if it's a hot number (last digit is 4)
            boolean isHot = (num % 10 == 4);
            
            // Check if it's a cold number (greater than 45)
            boolean isCold = (num > 45);
            
            // Update the array based on conditions
            if (isHot && isCold) {
                array.set(i, -2); // Both hot and cold
            } else if (isHot) {
                array.set(i, -1); // Hot number
            } else if (isCold) {
                array.set(i, -7); // Cold number
            }
        }
        
        // Return the new size of the array
        return array.size();
    }

    public static void main (String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String line = in.nextLine().trim();
            Scanner lineScanner = new Scanner(line);
            if (lineScanner.hasNextInt()) {
                int num = lineScanner.nextInt();
                if (lineScanner.hasNext()) {
                    // If line is not exactly one integer, ignore it
                    continue;
                }
                if (num == -1) 
                    break;
                arrayList.add(new Integer(num));
            }
            lineScanner.close();
        }
        int new_length = processArray(arrayList);
        for(int i=0; i<new_length; i++)
            System.out.println(arrayList.get(i));
        in.close();
    }
}
