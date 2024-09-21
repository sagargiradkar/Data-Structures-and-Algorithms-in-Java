public class PassingArraysAsArg {
    public static void update(int marks[], int nonhangable) {
        nonhangable = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        int marks[] = { 97, 98, 99 };
        int nonhangable = 5;
        update(marks, nonhangable);
        System.out.println(nonhangable);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Print marks ::" + marks[i] + " ");
        }
    }
}
