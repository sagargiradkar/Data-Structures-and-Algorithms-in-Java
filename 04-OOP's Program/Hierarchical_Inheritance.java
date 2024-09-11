// Parent class (Superclass)
class Vehicle {
    String brand = "Generic Vehicle";
    
    public void honk() {
        System.out.println("Vehicle is honking!");
    }
}

// First child class (Subclass of Vehicle)
class Car extends Vehicle {
    String model = "Sedan";
    
    public void startEngine() {
        System.out.println("Car engine started for " + model);
    }
}

// Second child class (Subclass of Vehicle)
class Bike extends Vehicle {
    String type = "Sports Bike";
    
    public void kickStart() {
        System.out.println("Bike is kick-started: " + type);
    }
}

public class Hierarchical_Inheritance {
    public static void main(String[] args) {
        // Create an object of Car
        Car myCar = new Car();
        myCar.honk();  // Inherited from Vehicle
        myCar.startEngine();  // Specific to Car
        System.out.println("Car Brand: " + myCar.brand);
        
        // Create an object of Bike
        Bike myBike = new Bike();
        myBike.honk();  // Inherited from Vehicle
        myBike.kickStart();  // Specific to Bike
        System.out.println("Bike Brand: " + myBike.brand);
    }
}
