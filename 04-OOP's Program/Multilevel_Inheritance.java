
// Parent class (Superclass)
class Vehicle {
    String brand = "Generic Vehicle";
    
    public void honk() {
        System.out.println("Vehicle is honking!");
    }
}

// Child class (Subclass of Vehicle)
class Car extends Vehicle {
    String model = "Sedan";
    
    public void startEngine() {
        System.out.println("Engine started for " + model);
    }
}

// Grandchild class (Subclass of Car)
class ElectricCar extends Car {
    int batteryLevel = 100;
    
    public void chargeBattery() {
        System.out.println("Battery charged to " + batteryLevel + "%");
    }
}

public class Multilevel_Inheritance {
    public static void main(String[] args) {
        // Create an object of ElectricCar
        ElectricCar myTesla = new ElectricCar();
        
        // Call methods inherited from Vehicle
        myTesla.honk();
        
        // Call methods inherited from Car
        myTesla.startEngine();
        
        // Call method specific to ElectricCar
        myTesla.chargeBattery();
        
        // Display inherited properties
        System.out.println("Brand: " + myTesla.brand);
        System.out.println("Model: " + myTesla.model);
    }
}
