interface ChessPlayr{
    void moves();

}
class Queen implements ChessPlayr{
    public void moves(){
        System.out.println("up,dow,left,right,diaonal(in all 4 diarection)");
    }
}

class Rook implements ChessPlayr{
    public void moves(){
        System.out.println("up,dow,left,right,");
    }
}

class King implements ChessPlayr{
    public void moves(){
        System.out.println("up,dow,left,right,diaonal(in all diarection)");
    }
}
public class Interfaces_Main {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
    }
}
