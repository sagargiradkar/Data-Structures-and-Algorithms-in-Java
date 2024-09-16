public class Count_And_Say {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String say = countAndSay(n - 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < say.length(); i++) {
            char ch = say.charAt(i);
            int count = 1;

            while (i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }

            result.append(count).append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Count_And_Say solution = new Count_And_Say();
        
        int n = 5;  // Example input
        String result = solution.countAndSay(n);
        System.out.println("The " + n + "th term of the count-and-say sequence is: " + result);
    }
}
