/*
**Problem Statement:**

Given a square matrix `A` of size `N x N` and an integer `X`, calculate the row number `R` and column number `C` of `X` in matrix `A`. 

- If the sum of `R` and `C` is an **even** number, find the sum of all even numbers in the matrix.
- If the sum of `R` and `C` is an **odd** number, find the sum of all odd numbers in the matrix.

If `X` is not found in the matrix, return `-1`.

**Input:**
- A square matrix `A` of size `N x N`.
- An integer `X`.

**Output:**
- If the sum of `R` and `C` is even, return the sum of all even numbers in the matrix.
- If the sum of `R` and `C` is odd, return the sum of all odd numbers in the matrix.
- If `X` is not found in the matrix, return `-1`.

---

### Test Cases:

#### Test Case 1:
**Input:**
``` 
A = [
  [2, 5, 7],
  [4, 6, 8],
  [1, 9, 10]
]
X = 6
```
**Explanation:**
- `X` is at position (1, 1). The sum of row and column is 2 (even).
- The even numbers in the matrix are: 2, 4, 6, 8, 10.
- Sum of even numbers: 2 + 4 + 6 + 8 + 10 = 30.

**Output:** 
```
30
```

---

#### Test Case 2:
**Input:**
```
A = [
  [1, 3, 5],
  [7, 9, 11],
  [13, 15, 17]
]
X = 9
```
**Explanation:**
- `X` is at position (1, 1). The sum of row and column is 2 (even).
- The even numbers in the matrix: None.
- Sum of even numbers: 0.

**Output:** 
```
0
```

---

#### Test Case 3:
**Input:**
```
A = [
  [2, 5, 8],
  [7, 10, 13],
  [4, 6, 15]
]
X = 5
```
**Explanation:**
- `X` is at position (0, 1). The sum of row and column is 1 (odd).
- The odd numbers in the matrix are: 5, 7, 13, 15.
- Sum of odd numbers: 5 + 7 + 13 + 15 = 40.

**Output:** 
```
40
```

---

#### Test Case 4:
**Input:**
```
A = [
  [11, 22, 33],
  [44, 55, 66],
  [77, 88, 99]
]
X = 88
```
**Explanation:**
- `X` is at position (2, 1). The sum of row and column is 3 (odd).
- The odd numbers in the matrix are: 11, 33, 55, 77, 99.
- Sum of odd numbers: 11 + 33 + 55 + 77 + 99 = 275.

**Output:** 
```
275
```

---

#### Test Case 5:
**Input:**
```
A = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
X = 12
```
**Explanation:**
- `X` is not present in the matrix.

**Output:** 
```
-1
```
*/
public class MatrixSumCalculator {

    public static int getSum(int n, int[][] a, int t) {
        int R = -1, C = -1;
        
        // Step 1: Find the row (R) and column (C) of the number t in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == t) {
                    R = i;
                    C = j;
                    break;
                }
            }
            if (R != -1) break;  // exit outer loop once t is found
        }
        
        if (R == -1 || C == -1) {
            // If t is not found in the matrix, return 0 or some error value
            return 0;
        }
        
        // Step 2: Calculate the sum of R and C
        int sumOfRC = R + C;

        // Step 3: Initialize the sums for even and odd numbers
        int evenSum = 0;
        int oddSum = 0;

        // Step 4: Traverse the matrix and calculate the sum of even and odd numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] % 2 == 0) {
                    evenSum += a[i][j];
                } else {
                    oddSum += a[i][j];
                }
            }
        }

        // Step 5: Return based on whether sumOfRC is even or odd
        if (sumOfRC % 2 == 0) {
            return evenSum;  // If R + C is even, return sum of even numbers
        } else {
            return oddSum;   // If R + C is odd, return sum of odd numbers
        }
    }

    public static void main(String[] args) {
        // Example test case
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int n = 3;  // Size of the matrix
        int t = 5;  // The target number to find in the matrix

        int result = getSum(n, matrix, t);
        System.out.println("Result: " + result);  // Output should be the sum of odd numbers, since R + C is odd (1 + 1 = 2).
    }
}
