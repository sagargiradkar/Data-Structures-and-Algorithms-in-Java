// Parent class (Superclass)
class Vehicle {
    String brand = "Generic Vehicle";
    
    public void honk() {
        System.out.println("Vehicle is honking!");
    }
}

// Interface 1
interface Electric {
    void chargeBattery();
}

// Interface 2
interface Diesel {
    void fuelUp();
}

// Child class inheriting from Vehicle and implementing two interfaces
class HybridCar extends Vehicle implements Electric, Diesel {
    String model = "Hybrid Model";
    
    public void startEngine() {
        System.out.println("Hybrid Car engine started.");
    }
    
    // Implement method from Electric interface
    public void chargeBattery() {
        System.out.println("Battery is being charged.");
    }
    
    // Implement method from Diesel interface
    public void fuelUp() {
        System.out.println("Car is being fueled with diesel.");
    }
}

public class Hybrid_Inheritance {
    public static void main(String[] args) {
        // Create an object of HybridCar
        HybridCar myHybridCar = new HybridCar();
        
        // Call inherited method from Vehicle
        myHybridCar.honk();
        
        // Call methods specific to HybridCar
        myHybridCar.startEngine();
        myHybridCar.chargeBattery();  // Implemented from Electric interface
        myHybridCar.fuelUp();         // Implemented from Diesel interface
        
        // Display inherited property
        System.out.println("Brand: " + myHybridCar.brand);
        System.out.println("Model: " + myHybridCar.model);
    }
}
