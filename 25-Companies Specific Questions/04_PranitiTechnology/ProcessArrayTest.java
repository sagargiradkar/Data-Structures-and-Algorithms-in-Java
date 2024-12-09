import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class ProcessArrayTest {

    @Test
    public void testNoConsecutiveEvenNumbers() {
        // Given an input with no even numbers
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(3);
        input.add(5);
        
        // When calling processArray
        int result = Main.processArray(input);
        
        // Then the result should be 0
        assertEquals(0, result);
    }

    @Test
    public void testConsecutiveEvenNumbersLessThanThree() {
        // Given an input with even numbers but not enough consecutive
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(4);
        
        // When calling processArray
        int result = Main.processArray(input);
        
        // Then the result should be 0
        assertEquals(0, result);
    }

    @Test
    public void testConsecutiveEvenNumbersExactlyThree() {
        // Given an input with exactly three consecutive even numbers
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(4);
        input.add(6);
        
        // When calling processArray
        int result = Main.processArray(input);
        
        // Then the result should be 1
        assertEquals(1, result);
    }

    @Test
    public void testMultipleSequencesOfEvenNumbers() {
        // Given an input with multiple sequences of even numbers
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(4);
        input.add(6);
        input.add(1);
        input.add(8);
        input.add(10);
        
        // When calling processArray
        int result = Main.processArray(input);
        
        // Then the result should be 1 (only one sequence of 3)
        assertEquals(1, result);
    }

    @Test
    public void testMultipleSequencesWithEnoughEvens() {
        // Given an input with multiple sequences of even numbers
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(4);
        input.add(6);
        input.add(1);
        input.add(2);
        input.add(4);
        input.add(6);
        
        // When calling processArray
        int result = Main.processArray(input);
        
        // Then the result should be 2 (two sequences)
        assertEquals(2, result);
    }

    @Test
    public void testEdgeCaseStartingAndEndingWithEvens() {
        // Given an input starting and ending with even numbers
        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(4);
        input.add(6);
        input.add(1);
        input.add(2);
        input.add(4);
        input.add(6);
        input.add(8);
        
        // When calling processArray
        int result = Main.processArray(input);
        
        // Then the result should be 3 (three sequences)
        assertEquals(3, result);
    }
}