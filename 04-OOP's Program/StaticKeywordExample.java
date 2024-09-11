class Example {
    // Static variable
    static int count = 0;

    // Instance variable
    int id;

    // Static block
    static {
        System.out.println("Static block executed.");
        count = 100;  // Initialize static variable in static block
    }

    // Constructor
    public Example(int id) {
        this.id = id;
        count++;  // Increment static variable
        System.out.println("Constructor executed. Object ID: " + this.id);
    }

    // Static method
    public static void showCount() {
        System.out.println("Total objects created (including static initialization): " + count);
    }

    // Instance method
    public void showID() {
        System.out.println("Object ID: " + this.id);
    }

    // Static nested class
    static class StaticNestedClass {
        public void display() {
            System.out.println("Inside static nested class.");
        }
    }
}

public class StaticKeywordExample {
    // Static main method
    public static void main(String[] args) {
        System.out.println("Main method started.");
        
        // Access static method without creating an object
        Example.showCount();
        
        // Create objects
        Example obj1 = new Example(1);
        Example obj2 = new Example(2);
        
        // Access instance method using objects
        obj1.showID();
        obj2.showID();
        
        // Access static method to show count
        Example.showCount();
        
        // Create an object of the static nested class
        Example.StaticNestedClass nestedObj = new Example.StaticNestedClass();
        nestedObj.display();
        
        System.out.println("Main method ended.");
    }
}
