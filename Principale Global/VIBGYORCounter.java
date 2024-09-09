/*
 
**Problem Statement:**

Given a string `str` containing the characters 'V', 'I', 'B', 'G', 'Y', 'O', and 'R', find the maximum number of complete occurrences of the word "VIBGYOR" that can be formed using the characters from the string `str`.

**Input:**
- A string `str` containing only the characters 'V', 'I', 'B', 'G', 'Y', 'O', 'R'.

**Output:**
- An integer representing the maximum number of times the word "VIBGYOR" can be formed using the characters from `str`.

---

### Test Cases:

#### Test Case 1:
**Input:**
```
str = "VIBGYORVIBGYORVIBGYOR"
```
**Explanation:**
- Each character of "VIBGYOR" appears 3 times, so we can form the word "VIBGYOR" exactly 3 times.

**Output:** 
```
3
```

---

#### Test Case 2:
**Input:**
```
str = "VIBGYOVIBGYVIBGYOR"
```
**Explanation:**
- The string contains:
  - 3 'V's, 
  - 3 'I's, 
  - 3 'B's, 
  - 3 'G's, 
  - 3 'Y's, 
  - 2 'O's, 
  - 3 'R's.
- Since 'O' only appears 2 times, the word "VIBGYOR" can only be formed 2 times.

**Output:** 
```
2
```

---

#### Test Case 3:
**Input:**
```
str = "VIBGY"
```
**Explanation:**
- The string does not contain all the letters necessary to form the word "VIBGYOR".
- Since 'O' and 'R' are missing, the word cannot be formed even once.

**Output:** 
```
0
```

---

#### Test Case 4:
**Input:**
```
str = "VVVVIIIBBBGGGYYYOOORRR"
```
**Explanation:**
- The string contains:
  - 4 'V's, 
  - 4 'I's, 
  - 3 'B's, 
  - 3 'G's, 
  - 3 'Y's, 
  - 3 'O's, 
  - 3 'R's.
- The minimum count of any character is 3, so the word "VIBGYOR" can be formed 3 times.

**Output:** 
```
3
```

---

#### Test Case 5:
**Input:**
```
str = "VIBGYORVIBGYOR"
```
**Explanation:**
- The string contains exactly 2 occurrences of each letter needed to form "VIBGYOR".
- Therefore, the word "VIBGYOR" can be formed 2 times.

**Output:** 
```
2
```
 */

import java.util.HashMap;

public class VIBGYORCounter {

    public static int COUNTVIBGYOR(String str) {
        // Create a frequency map for the characters in "VIBGYOR"
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        String target = "VIBGYOR";

        // Initialize frequency map with target characters
        for (char c : target.toCharArray()) {
            frequencyMap.put(c, 0);
        }

        // Count the occurrences of each character in the input string
        for (char c : str.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            }
        }

        // Calculate the maximum number of times we can form "VIBGYOR"
        int maxCount = Integer.MAX_VALUE;

        for (char c : target.toCharArray()) {
            maxCount = Math.min(maxCount, frequencyMap.get(c));
        }

        // If maxCount is still Integer.MAX_VALUE, it means no characters were found
        return maxCount == Integer.MAX_VALUE ? 0 : maxCount;
    }

    public static void main(String[] args) {
        // Example test cases
        String input1 = "VIBGYORVIBGYOR";
        String input2 = "VIBG";
        String input3 = "VIIBBGGYOORR";

        System.out.println("Max occurrences in input1: " + COUNTVIBGYOR(input1)); // Output: 2
        System.out.println("Max occurrences in input2: " + COUNTVIBGYOR(input2)); // Output: 0
        System.out.println("Max occurrences in input3: " + COUNTVIBGYOR(input3)); // Output: 1
    }
}
