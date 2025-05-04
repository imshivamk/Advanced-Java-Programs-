import java.util.*;

public class Que10 {
    static LinkedList<String> list = new LinkedList<>();

    static void insertBegin(String val) { list.addFirst(val); }
    static void insertEnd(String val) { list.addLast(val); }
    static void deleteBegin() { if (!list.isEmpty()) list.removeFirst(); }
    static void deleteEnd() { if (!list.isEmpty()) list.removeLast(); }
    static int search(String val) { return list.indexOf(val); }
    static void display() { System.out.println("List: " + list); }

    public static void main(String[] args) {
        insertEnd("Alice");
        insertBegin("Bob");
        insertEnd("Charlie");
        display();                     // [Bob, Alice, Charlie]
        deleteBegin();
        deleteEnd();
        display();                     // [Alice]
        System.out.println("Index of Alice: " + search("Alice"));
    }
}
