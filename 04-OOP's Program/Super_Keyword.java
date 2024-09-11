class Animal {
    String color;

    Animal() {
        System.out.println("Animal.Animal()");
        this.color = "unknown"; // Initialize color
    }
}

class Horse extends Animal {
    Horse() {
        super.color = "brown"; // Set the color in the Horse constructor
        System.out.println("Horse.Horse()");
    }
}

public class Super_Keyword {
    public static void main(String[] args) {
        Horse obj = new Horse();
        System.out.println(obj.color); // Now this will print "brown"
    }
}
