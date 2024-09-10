class Pen1 {
    private String color;
    private int tipSize;
    private float price;

    // Non-parameterized Constructor
    public Pen1() {
        System.out.println("Pen1.Pen1() - Non-parameterized constructor called");
    }

    // Parameterized Constructor
    public Pen1(String color, int tipSize, float price) {
        this.color = color;
        this.tipSize = tipSize;
        this.price = price;
    }

    // Copy Constructor
    public Pen1(Pen1 p1) {
        this.color = p1.color;
        this.tipSize = p1.tipSize;
        this.price = p1.price;
    }

    public String getColor() {
        return color;
    }

    public int getTipSize() {
        return tipSize;
    }

    public float getPrice() {
        return price;
    }
}

public class Constructor1 {
    public static void main(String[] args) {
        // Non-parameterized constructor call
        Pen1 p2 = new Pen1();
        
        // Parameterized constructor call
        Pen1 p1 = new Pen1("Pink", 32, 52.3f);
        System.out.println("Color: " + p1.getColor());
        System.out.println("Tip Size: " + p1.getTipSize());
        System.out.println("Price: " + p1.getPrice());

        // Copy constructor call
        Pen1 p3 = new Pen1(p1);
        System.out.println("Copied Pen Color: " + p3.getColor());
        System.out.println("Copied Pen Tip Size: " + p3.getTipSize());
        System.out.println("Copied Pen Price: " + p3.getPrice());
    }
}
