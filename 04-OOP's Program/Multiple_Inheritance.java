// Define interface A
interface A {
    void displayA();
}

// Define interface B
interface B {
    void displayB();
}

// Implement both interfaces in a single class
class C implements A, B {
    // Implement method from interface A
    public void displayA() {
        System.out.println("Display from Interface A");
    }

    // Implement method from interface B
    public void displayB() {
        System.out.println("Display from Interface B");
    }
}

public class Multiple_Inheritance {
    public static void main(String[] args) {
        // Create an object of class C
        C obj = new C();
        
        // Call methods from both interfaces
        obj.displayA();
        obj.displayB();
    }
}
