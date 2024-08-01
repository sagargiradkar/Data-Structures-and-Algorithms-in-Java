



Candidate’s Profile
Name: Sagar Prakash Giradkar
Email Id: spgiradkar2002@gmail.com
Mobile No: 9168801192

Programming Test

This paper has been designed to test your programming abilities – it is meant to be a starting point for further discussion and provides you an opportunity to highlight your skills. You can take the test in the programming language of your choice. Your code doesn’t have to compile exactly but it should be reasonably close (pseudo-code is not OK).
If you are unsure about something, or make an assumption, write the assumption as part of your answer. Good luck ☺

Test duration is 60 minutes.



A-1: Write a function that takes an input parameter as a String. The function should replace the alternate words in it with “xyz” and print it. Words are separated by dots. (Avoid using inbuilt functions)

If input is “i.like.this.program.very.much”
Output will be “i.xyz.this.xyz.very.xyz”

Program :: 
===================================
public class WordReplacer {
    private String input;
    public WordReplacer(String input) {
        this.input = input;
    }
    public String replaceAlternateWords() {
        String[] words = splitByDot(input);
        for (int i = 1; i < words.length; i += 2) {
            words[i] = "xyz";
        }
        
             return joinWithDot(words);
    }
       private String[] splitByDot(String str) {
        int count = countDots(str);
        String[] result = new String[count + 1];
        int start = 0, index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                result[index++] = str.substring(start, i);
                start = i + 1;
            }
        }
        result[index] = str.substring(start);
        return result;
    }
       private int countDots(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                count++;
            }
        }
        return count;
    }
      private String joinWithDot(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        WordReplacer replacer = new WordReplacer("i.like.this.program.very.much");
        String result = replacer.replaceAlternateWords();
        System.out.println(result); 
    }
}

================================
If input is “i.like.this.program.very.much”
Output will be “i.xyz.this.xyz.very.xyz”
================================




A-2: Given a binary string (string containing only 0’s and 1’s) “str” that contains at least a single occurrence of a numeric value: '1'.
You have to rearrange the characters in the string in such a way that the resulting binary string is the maximum odd binary number that can be created from this combination.
Note that the resulting string can have leading zeros.
Examples:
1. Input: str = "010"
Output: "001"
2. Input: str = "01010"
Output: "10001"

Program :
====================================
public class MaxOddBinaryNumber {
    private String binaryString;
    public MaxOddBinaryNumber(String binaryString) {
        this.binaryString = binaryString;
    }
    public String getMaxOddBinaryNumber() {
        int count1 = 0;
        int count0 = 0;
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count1++;
            } else if (c == '0') {
                count0++;
            }
        }
        if (count1 == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count1 - 1; i++) {
            result.append('1');
        }
        for (int i = 0; i < count0; i++) {
            result.append('0');
        }
        result.append('1');
        return result.toString();
    }

    public static void main(String[] args) {
        MaxOddBinaryNumber number1 = new MaxOddBinaryNumber("010");
        System.out.println(number1.getMaxOddBinaryNumber()); 

        MaxOddBinaryNumber number2 = new MaxOddBinaryNumber("01010");
        System.out.println(number2.getMaxOddBinaryNumber());
    }
}
=====================================================
1. Input: str = "010"
Output: "001"
2. Input: str = "01010"
Output: "10001"
=====================================================




































A-3: Write a program to find the equilibrium element from an integer array. An equilibrium element is defined as the number for which the sum of left side elements is equal to sum of right side elements. 


Note: If no possible combination exists return 0.


Examples:
1. Input: [1,7, 5, 2, 6]
Output: 5 (since 1 + 7 = 8 and 2 + 6 = 8)


2. Input: [10, 1, 1, 9] 
Output: 1 (since 1 + 9 = 10 and first element is 10)

Program :
=============================================================
public class EquilibriumFinder {
       public int findEquilibriumElement(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
     
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - arr[i] - leftSum;
            if (leftSum == rightSum) {
                return arr[i];
            }
            leftSum += arr[i];
        }
        return 0;
    }
    
    public static void main(String[] args) {
        EquilibriumFinder finder = new EquilibriumFinder();

        int[] array1 = {1, 7, 5, 2, 6};
        int equilibrium1 = finder.findEquilibriumElement(array1);
        System.out.println("Equilibrium element in array1: " + equilibrium1); 
        
        int[] array2 = {10, 1, 1, 9};
        int equilibrium2 = finder.findEquilibriumElement(array2);
        System.out.println("Equilibrium element in array2: " + equilibrium2);     
   
        int[] array3 = {1, 2, 3, 4, 5};
        int equilibrium3 = finder.findEquilibriumElement(array3);
        System.out.println("Equilibrium element in array3: " + equilibrium3);

    }
}




===================================
1. Input: [1,7, 5, 2, 6]
Output: 5 (since 1 + 7 = 8 and 2 + 6 = 8)


2. Input: [10, 1, 1, 9] 
Output: 1 (since 1 + 9 = 10 and first element is 10)
====================================















































A-4: Given an encoded string, return its decoded string.
The encoding rule is ‘k[encoded_string]’, where the ‘encoded_string’ inside the square brackets is being repeated exactly ‘k’ times.

You may assume that ‘encoded_string’ will only consist of lower case alphabets and ‘k’ will always be greater than 0.
Note: The ‘encoded_string’ can be nested as well. Refer example 2 for clarification.
Examples:
1. Input: s = "3[a]2[bc]"
Output: "aaabcbc"

2. Input: s = "3[a2[c]]"
Output: "accaccacc”
Program ::
==========================================
import java.util.Stack;

public class StringDecoder {
    
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int index = 0;
        
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            
            if (Character.isDigit(currentChar)) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (currentChar == '[') {
                resultStack.push(currentString);
                currentString = new StringBuilder();
                index++;
            } else if (currentChar == ']') {
                StringBuilder decodedString = resultStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
                index++;
            } else {
                currentString.append(currentChar);
                index++;
            }
        }
        
        return currentString.toString();
    }
    
    public static void main(String[] args) {
        StringDecoder decoder = new StringDecoder();
        
        String input1 = "3[a]2[bc]";
        String output1 = decoder.decodeString(input1);
        System.out.println("Decoded string: " + output1);         
        String input2 = "3[a2[c]]";
        String output2 = decoder.decodeString(input2);
        System.out.println("Decoded string: " + output2); 
    }
}

=========================================
























A-5: Given a string ‘s’ consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
1. Pick a non-empty prefix from the string ‘s’ where all the characters in the prefix are the same.
2. Pick a non-empty suffix from the string ‘s’ where all the characters in this suffix are the same.
3. The prefix and the suffix should not intersect at any index.
4. The characters from the prefix and suffix must be the same.
5. Delete both the prefix and the suffix.
6. Return the minimum length of ‘s’ after performing the above operation any number of times (possibly zero times).

Examples:

1. Input: s = "ca"	
Output: 2
Explanation: You can't remove any characters, so the string stays as is.

2. Input: s = "aabccabba"
Output: 3
Explanation: An optimal sequence of operations is:
- Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
- Take prefix = "b" and suffix = "bb" and remove them, s = "cca".




Program :: 
===================================================
public class StringReducer {


     public int minimizeLength(String s) {
        int left = 0;
        int right = s.length() - 1;


        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);
            
            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }
            
            while (right >= left && s.charAt(right) == currentChar) {
                right--;
            }
        }


          return right - left + 1;
    }


    public static void main(String[] args) {
        StringReducer reducer = new StringReducer();
        
        String input1 = "ca";
        int result1 = reducer.minimizeLength(input1);
        System.out.println("Minimum length of string 'ca': " + result1); 
        
        String input2 = "aabccabba";
        int result2 = reducer.minimizeLength(input2);
        System.out.println("Minimum length of string 'aabccabba': " + result2);


    }
}


=============================================================
1. Input: s = "ca"	
Output: 2
Explanation: You can't remove any characters, so the string stays as is.

2. Input: s = "aabccabba"
Output: 3
Explanation: An optimal sequence of operations is:
- Take prefix = "aa" and suffix = "a" and remove them, s = "bccabb".
- Take prefix = "b" and suffix = "bb" and remove them, s = "cca".


