public class CharAt_Function {
    public static void printString(String str){
        for(int i=0; i<str.length(); i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String fullName = "Sagar Giradkar";
        System.out.println(fullName.charAt(1));
        printString(fullName);
    }
}
