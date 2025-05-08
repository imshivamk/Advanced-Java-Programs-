package Unit2;

//2.	Demonstrate the use of ArrayList, Vector, and LinkedList, performing basic operations on list of students:
//a) Add student name to list
//b) Update the name in list to specific index
//c) Search the list by student name
//d) Remove a student by name, display the list

import java.util.*;

public class Q2 {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        set.add(22);
        set.add(22);
        set.add(22);
        set.add(24);

        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
        }


    }
}
