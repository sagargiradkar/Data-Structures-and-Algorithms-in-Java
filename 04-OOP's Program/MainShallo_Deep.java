class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Shallow copy constructor
    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Deep copy constructor
    Person(Person other, boolean deepCopy) {
        this.name = other.name; // Shallow copy of name (String is immutable)
        if (deepCopy) {
            this.age = other.age; // Deep copy of age
        } else {
            this.age = other.age; // Shallow copy of age
        }
    }
}

public class MainShallo_Deep {
    public static void main(String[] args) {
        Person original = new Person("Alice", 30);

        // Shallow copy
        Person shallowCopy = new Person(original);
        original.age = 35;
        System.out.println("Shallow copy age: " + shallowCopy.age); // Output: 35

        // Deep copy
        Person deepCopy = new Person(original, true);
        original.age = 40;
        System.out.println("Deep copy age: " + deepCopy.age); // Output: 30
    }
}

