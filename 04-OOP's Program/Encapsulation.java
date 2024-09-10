class Encap{
    private int id;
    private int marks;
    private String name;
    private String classNAme;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMarks() {
        return marks;
    }
    public void setMarks(int marks) {
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClassNAme() {
        return classNAme;
    }
    public void setClassNAme(String classNAme) {
        this.classNAme = classNAme;
    }
    
}

public class Encapsulation {
    public static void main(String[] args) {
        Encap obj = new Encap();
        obj.setId(1);
        obj.setMarks(100);
        obj.setName("Sagar");
        obj.setClassNAme("BE IT");
        System.out.println(obj.getId());
        System.out.println(obj.getMarks());
        System.out.println(obj.getName());
        System.out.println(obj.getClass());
    }
}
