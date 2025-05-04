import java.util.*;

public class Que8 {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        // a. Add students
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("David");

        // b. Display initial list
        System.out.println("Initial List: " + students);

        // c. Update name at index 1 (Bob → Ben)
        students.set(1, "Ben");

        // d. Remove student by name
        students.remove("Charlie");

        // e. Search for student
        String searchName = "Alice";
        System.out.println(searchName + (students.contains(searchName) ? " found" : " not found"));

        // f. Display final list
        System.out.println("Final List: " + students);

        // g. Clear list
        students.clear();
        System.out.println("Cleared List: " + students);
    }
}
