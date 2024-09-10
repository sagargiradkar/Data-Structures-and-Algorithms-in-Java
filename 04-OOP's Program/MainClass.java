class Pen{
    private String color;
    private int tip;

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getTip() {
        return tip;
    }
    public void setTip(int tip) {
        this.tip = tip;
    }

    
}

public class MainClass {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Pink");
        p1.setTip(5);
        System.out.println(p1.getColor());
        System.out.println(p1.getTip());

    }
}
