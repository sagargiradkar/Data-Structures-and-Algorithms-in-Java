import java.util.HashMap;
import java.util.Map;

public class CharacterFrequency {

    public static void main(String[] args) {
        String input1 = "rajasoftwarelabs";
        String input2 = "Buffet";
        
        System.out.println(frequencyOfCharacters(input1));
        System.out.println(frequencyOfCharacters(input2));
    }
    
    public static String frequencyOfCharacters(String input) {
        // Convert input string to lowercase to ignore case
        input = input.toLowerCase();
        
        // Characters to count
        char[] charsToCount = {'b', 'f', 'j', 'p', 'v'};
        
        // HashMap to store the frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Initialize the frequency map
        for (char c : charsToCount) {
            frequencyMap.put(c, 0);
        }
        
        // Calculate the frequencies
        int total = 0;
        for (char c : input.toCharArray()) {
            if (frequencyMap.containsKey(c)) {
                frequencyMap.put(c, frequencyMap.get(c) + 1);
                total++;
            }
        }
        
        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char c : charsToCount) {
            result.append(c).append("=").append(frequencyMap.get(c)).append(", ");
        }
        result.append("Total=").append(total);
        
        return result.toString();
    }
}
