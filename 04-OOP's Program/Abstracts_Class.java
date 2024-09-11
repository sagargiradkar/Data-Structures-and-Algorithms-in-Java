
// Abstract class
abstract class Shape {
    // Abstract method (does not have a body)
    public abstract double area();

    // Abstract method (does not have a body)
    public abstract double perimeter();

    // Regular method
    public void display() {
        System.out.println("Displaying the shape properties:");
    }
}

// Subclass (inherits from Shape)
class Circle extends Shape {
    private double radius;

    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementing the abstract method for area
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    // Implementing the abstract method for perimeter
    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}

// Subclass (inherits from Shape)
class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Implementing the abstract method for area
    @Override
    public double area() {
        return length * width;
    }

    // Implementing the abstract method for perimeter
    @Override
    public double perimeter() {
        return 2 * (length + width);
    }
}

public class Abstracts_Class {
    public static void main(String[] args) {
        // Create a Circle object
        Shape myCircle = new Circle(5.0);
        myCircle.display();
        System.out.println("Circle Area: " + myCircle.area());
        System.out.println("Circle Perimeter: " + myCircle.perimeter());

        // Create a Rectangle object
        Shape myRectangle = new Rectangle(4.0, 7.0);
        myRectangle.display();
        System.out.println("Rectangle Area: " + myRectangle.area());
        System.out.println("Rectangle Perimeter: " + myRectangle.perimeter());
    }
}
