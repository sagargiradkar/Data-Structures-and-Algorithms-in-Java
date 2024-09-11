class Student {
    String name;
    int roll;

    static int returnPercentatge(int math, int phy, int chem) {
        return (math + phy + chem) / 3;
    }

    static String schoolName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

}

public class Static_Keyword {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "JNV";

        Student s2 = new Student();

        System.out.println(s2.schoolName);
    }
}