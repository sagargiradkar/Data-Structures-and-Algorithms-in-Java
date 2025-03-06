/*
Problem Statement:
Given three sides of a triangle, calculate and print its perimeter.

Solution Explanation:
The perimeter of a triangle is the sum of its three sides. 
Given three integer values representing the sides of a triangle, we add them together and print the result.

Time Complexity Analysis:
- The solution executes a few arithmetic operations (addition) and a print statement.
- Time Complexity: O(1) (Constant time)
- Space Complexity: O(1) (Only a few integer variables are used)

Test Cases:
1. Input: a = 10, b = 20, c = 30   -> Output: 60
2. Input: a = 5, b = 5, c = 5       -> Output: 15
3. Input: a = 3, b = 4, c = 5       -> Output: 12
4. Input: a = 7, b = 8, c = 9       -> Output: 24
5. Input: a = 15, b = 25, c = 35    -> Output: 75
*/

public class Perimeter {
    public static void main(String[] args) {
        // Your Original Code
        int a = 10;
        int b = 20;
        int c = 30;
        int p = a + b + c;
        System.out.println(p);
    }

    // Optimized Method
    public static int calculatePerimeter(int a, int b, int c) {
        return a + b + c; 
    }

    /*
    Optimized Code:
    public static int calculatePerimeter(int a, int b, int c) {
        return a + b + c;
    }
    */
    
}
