public class D_06_H_Index {

    // Function to find hIndex
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                freq[n]++;
            } else {
                freq[citations[i]]++;
            }
        }

        int hIndex = n;
        int num = freq[n];

        while (num < hIndex) {
            hIndex--;
            num += freq[hIndex];
        }

        return hIndex;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println("H-Index: " + hIndex(citations));
    }
}
