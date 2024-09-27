
import java.util.*;

public class HP_01_PriorityQueue_JCF {

    static class Student implements Comparable<Student> {//overriding

        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        pq.add(10);
        pq.add(-11);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        PriorityQueue<Student> pq1 = new PriorityQueue<>();
        pq1.add(new Student("E", 13));
        pq1.add(new Student("F", 76));
        pq1.add(new Student("E", 13));
        pq1.add(new Student("F", 76));
        pq1.add(new Student("E", 13));
        pq1.add(new Student("F", 76));
        pq1.add(new Student("A", 4));
        pq1.add(new Student("B", 5));
        pq1.add(new Student("C", 2));
        pq1.add(new Student("D", 6));
        pq1.add(new Student("E", 13));
        pq1.add(new Student("F", 76));

        while(!pq1.isEmpty()){
            System.out.println(pq1.peek().name+" -> "+ pq1.peek().rank);
            pq1.remove();
        }
    }

}
