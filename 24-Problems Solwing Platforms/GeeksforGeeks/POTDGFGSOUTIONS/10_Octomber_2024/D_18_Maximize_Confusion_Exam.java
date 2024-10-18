public class D_18_Maximize_Confusion_Exam {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    private int maxConsecutiveChar(String answerKey, int k, char ch) {
        int left = 0, maxLen = 0, count = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != ch) {
                count++;
            }
            while (count > k) {
                if (answerKey.charAt(left) != ch) {
                    count--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        D_18_Maximize_Confusion_Exam obj = new D_18_Maximize_Confusion_Exam();
        String answerKey = "TTFF";
        int k = 2;
        System.out.println(obj.maxConsecutiveAnswers(answerKey, k));  // Output: 4
    }
}