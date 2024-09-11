class Person {
    int weight;
    int age;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    int marks;
    String name;
    int rollNo;
    int stdId;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }
}

public class OOPS_Practice_Questions {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Sagar");
        System.out.println("Name: " + s.getName());

        s.setAge(20);
        s.setMarks(100);
        s.setStdId(1);

        System.out.println("Age: " + s.getAge());
        System.out.println("Marks: " + s.getMarks());
        System.out.println("Student ID: " + s.getStdId());
    }
}
