// Parent class (Superclass)
class Vehicle {
    String brand = "Toyota";
    
    public void honk() {
        System.out.println("Vehicle is honking!");
    }
}

// Child class (Subclass)
class Car extends Vehicle {
    String model = "Corolla";
    
    public void displayDetails() {
        System.out.println("Brand: " + brand);  // Inherited property
        System.out.println("Model: " + model);  // Specific to Car
    }
}

public class Single_Level_Inheritance {
    public static void main(String[] args) {
        // Create an object of Car
        Car myCar = new Car();
        
        // Call inherited method
        myCar.honk();
        
        // Call method specific to Car
        myCar.displayDetails();
    }
}
