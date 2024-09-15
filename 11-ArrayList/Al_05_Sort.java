
import java.util.ArrayList;
import java.util.Collections;

public class Al_05_Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);

        System.out.println(list);
        Collections.sort(list);//ascending 
        System.out.println(list);

        //descending 
        Collections.sort(list,Collections.reverseOrder());

        System.out.println(list);


    }
}
