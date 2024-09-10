class Student {
    private String name;
    private int age;
    private String grade;
    private String major;

    // Non-parameterized Constructor
    public Student() {
        System.out.println("Student object created with default values");
        this.name = "Unknown";
        this.age = 0;
        this.grade = "N/A";
        this.major = "Undeclared";
    }

    // Parameterized Constructor
    public Student(String name, int age, String grade, String major) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.major = major;
    }

    // Copy Constructor
    public Student(Student s) {
        this.name = s.name;
        this.age = s.age;
        this.grade = s.grade;
        this.major = s.major;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getMajor() {
        return major;
    }

    // Display student information
    public void displayInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Grade: " + this.grade);
        System.out.println("Major: " + this.major);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        // Non-parameterized constructor call
        Student student1 = new Student();
        student1.displayInfo();  // Displaying default values

        System.out.println("------------------------");

        // Parameterized constructor call
        Student student2 = new Student("John Doe", 20, "Sophomore", "Computer Science");
        student2.displayInfo();  // Displaying initialized values

        System.out.println("------------------------");

        // Copy constructor call
        Student student3 = new Student(student2);
        student3.displayInfo();  // Displaying copied values
    }
}
