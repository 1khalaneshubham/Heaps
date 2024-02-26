import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityCode {
    static class Student implements Comparable<Student> { // Overriding
        String name;
        int rank;

        public Student(String name , int rank){
            this.name = name;
            this.rank = rank;
        }

        // Overriding code
        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
        // class  ch object assa comper karta bahi
    }
    public static void main(String args[]){
        
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("OM", 40));  // O(logn)
        pq.add(new Student("KP",50));
        pq.add(new Student("SK",20));
        pq.add(new Student("AK", 120));
      
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+"->"+pq.peek().rank); // O(1)
            pq.remove();  // O(logn)
        }
    }
}

