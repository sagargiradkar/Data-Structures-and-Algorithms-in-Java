import java.util.*;

public class Solution {
    /**
     * Method to find temperature closest to zero
     * @param ts List of temperatures
     * @return temperature closest to zero
     */
    public static double closestToZero(List<Double> ts) {
        // Handle empty or null list
        if (ts == null || ts.isEmpty()) {
            return 0;
        }
        
        double closest = Double.MAX_VALUE;
        
        // Iterate through all temperatures to find closest to zero
        for (double temp : ts) {
            double currentAbs = Math.abs(temp);
            double closestAbs = Math.abs(closest);
            
            // Update if current temperature is closer to zero
            if (currentAbs < closestAbs) {
                closest = temp;
            }
            // If equally close to zero, prefer positive value
            else if (currentAbs == closestAbs) {
                if (temp > 0 || (temp < 0 && closest < 0)) {
                    closest = temp;
                }
            }
        }
        
        return closest == Double.MAX_VALUE ? 0 : closest;
    }

    public static void main(String[] args) {
        // Test Case 1: Simple test
        List<Double> test1 = Arrays.asList(7.2, 2.4, 9.6, -5.7, 4.0);
        System.out.println("Test 1 - Simple test:");
        System.out.println("Input: " + test1);
        System.out.println("Output: " + closestToZero(test1));
        System.out.println();

        // Test Case 2: Equal distance numbers
        List<Double> test2 = Arrays.asList(15.0, -7.1, 9.2, 14.3, 7.1, 12.9);
        System.out.println("Test 2 - Equal distance numbers:");
        System.out.println("Input: " + test2);
        System.out.println("Output: " + closestToZero(test2));
        System.out.println();

        // Test Case 3: Maximum temperature
        List<Double> test3 = Arrays.asList(5526.0);
        System.out.println("Test 3 - Maximum temperature:");
        System.out.println("Input: " + test3);
        System.out.println("Output: " + closestToZero(test3));
        System.out.println();

        // Test Case 4: Ultra-frozen
        List<Double> test4 = Arrays.asList(-273.0);
        System.out.println("Test 4 - Ultra-frozen:");
        System.out.println("Input: " + test4);
        System.out.println("Output: " + closestToZero(test4));
        System.out.println();

        // Test Case 5: Only negative values
        List<Double> test5 = Arrays.asList(-15.8, -58.7, -9.6, -14.5, -9.7);
        System.out.println("Test 5 - Only negative values:");
        System.out.println("Input: " + test5);
        System.out.println("Output: " + closestToZero(test5));
        System.out.println();

        // Test Case 6: Duplicate values
        List<Double> test6 = Arrays.asList(-10.0, -10.0);
        System.out.println("Test 6 - Duplicate values:");
        System.out.println("Input: " + test6);
        System.out.println("Output: " + closestToZero(test6));
        System.out.println();

        // Test Case 7: Zero in array
        List<Double> test7 = Arrays.asList(10.5, -10.5, 20.1, -20.1, 0.0);
        System.out.println("Test 7 - Zero in array:");
        System.out.println("Input: " + test7);
        System.out.println("Output: " + closestToZero(test7));
        System.out.println();

        // Test Case 8: Empty array
        List<Double> test8 = new ArrayList<>();
        System.out.println("Test 8 - Empty array:");
        System.out.println("Input: " + test8);
        System.out.println("Output: " + closestToZero(test8));
    }
}
/*
Problem Statement:
```
Your company builds temperature sensors for freezers. These sensors record temperature periodically and store the values in a list. You need to develop an algorithm that displays the temperature closest to zero from these values [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game).

Given:
- The input is a list of temperatures (can be positive or negative decimals)
- Temperature range: -273.0 to 5526.0
- List length: 0 to 20 elements
- If two numbers are equally close to zero, prefer the positive number
- If the list is empty, return 0
```

Solution with Test Cases:
```java
public static double closestToZero(List<Double> ts) {
    if (ts == null || ts.isEmpty()) {
        return 0;
    }
    
    double closest = Double.MAX_VALUE;
    
    for (double temp : ts) {
        double currentAbs = Math.abs(temp);
        double closestAbs = Math.abs(closest);
        
        if (currentAbs < closestAbs) {
            closest = temp;
        }
        else if (currentAbs == closestAbs) {
            if (temp > 0 || (temp < 0 && closest < 0)) {
                closest = temp;
            }
        }
    }
    
    return closest == Double.MAX_VALUE ? 0 : closest;
}
```

Test Cases and Explanations:

1. Simple Test [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: [7.2, 2.4, 9.6, -5.7, 4]
Output: 2.4
Explanation: 2.4 has smallest absolute value
```

2. Equal Distance Selection [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)[Closest to zero degree centegrade temperature.java - GitHub](https://github.com/Akki-T/Java_Practise/blob/master/Closest%20to%20zero%20degree%20centegrade%20temperature.java)
```
Input: [15, -7.1, 9.2, 14.3, 7.1, 12.9]
Output: 7.1
Explanation: Both -7.1 and 7.1 are equally close to zero, but positive value 7.1 is chosen
```

3. Maximum Temperature [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: [5526]
Output: 5526
Explanation: Single value case at upper limit
```

4. Ultra-frozen Temperature [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: [-273]
Output: -273
Explanation: Single value case at lower limit
```

5. Only Negative Values [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: [-15.8, -58.7, -9.6, -14.5, -9.7]
Output: -9.6
Explanation: -9.6 is closest to zero among negative numbers
```

6. Duplicate Values [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: [-10, -10]
Output: -10
Explanation: Same value repeated
```

7. Zero in Array [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: [10.5, -10.5, 20.1, -20.1, 0]
Output: 0
Explanation: Zero is present, which is exactly at zero
```

8. Empty Array [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
```
Input: []
Output: 0
Explanation: Empty list returns 0
```

Key Implementation Points:

1. Empty List Handling [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
- Check for null or empty list at start
- Return 0 as specified

2. Finding Closest Value [Find the temperature closest to 0 - Code Golf Stack Exchange](https://codegolf.stackexchange.com/questions/112021/find-the-temperature-closest-to-0)[A function to find temperatures closest to zero](https://codereview.stackexchange.com/questions/199492/a-function-to-find-temperatures-closest-to-zero)
- Use Math.abs() to compare distances from zero
- Keep track of closest value found so far
- Update when finding closer value

3. Equal Distance Resolution [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)[Closest to zero degree centegrade temperature.java - GitHub](https://github.com/Akki-T/Java_Practise/blob/master/Closest%20to%20zero%20degree%20centegrade%20temperature.java)
- When distances are equal (currentAbs == closestAbs)
- Choose positive number over negative
- Update only if current temperature is positive or both are negative

4. Edge Cases [Prints the temp closest to 0 among input data - Coding Game](https://stackoverflow.com/questions/65498045/prints-the-temp-closest-to-0-among-input-data-coding-game)
- Handles single element lists
- Works with temperature range limits (-273 to 5526)
- Properly processes duplicate values
- Correctly identifies zero when present

This solution has O(n) time complexity where n is the number of temperatures, and O(1) space complexity as it only uses a few variables regardless of input size. 





*/