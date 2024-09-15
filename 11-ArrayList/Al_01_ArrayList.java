import java.util.ArrayList;
public class Al_01_ArrayList{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<Boolean> list3 = new ArrayList<>();

        list.add(1);//O(1)
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(1,9);
        System.out.println(list);

        //get Operation - O(1)
        int element = list.get(2);
        System.out.println(element);


        //Delete Remove Element - O(n)
        list.remove(2);
        System.out.println(list);

        // Set element at perticular index

        list.set(1, 10);
        System.out.println(list);

        //Containes
        System.out.println(list.contains(10));

        int listElemet = list.get(4);
        System.out.println(listElemet);
        System.out.println("size of array list : "+list.size());

        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i) +" ");
        }
        System.out.println();
    }
}