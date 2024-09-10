class Pen{
    //properties + functions
    String color;
    int tip;

    public void setColor(String newColor){
        color = newColor;
    }
    public void setTip(int newTip){
        tip = newTip;
    }
}
class Student{
    String name;
    int age;
    float percentage;

    public void calculatePerce(int phy,int chem,int math){
        percentage = (phy + chem + math)/3;
    }
}
class BankAccount{
    public String userName;
    private String password;

    public void setPassword(String pwd){
        password = pwd;
    }
    public String getPassword(){
        return password;
    }
}
public class OOPS{
    public static void main(String[] args) {
        Pen obj = new Pen(); // created a object of pen class
        obj.setColor("blue");
        System.out.println(obj.color);
        obj.setTip(50);
        System.out.println(obj.tip);

        obj.setColor("yellow");
        System.out.println(obj.color);
        obj.setTip(100);
        System.out.println(obj.tip);

        BankAccount myAccount = new BankAccount();
        myAccount.userName = "SagarGiradkar";
        myAccount.setPassword("Sagar Password");
        System.out.println(myAccount.getPassword());
        
    }
}
