import java.util.*;

public class ST_04_Stack_Using_Java_Collections {
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
