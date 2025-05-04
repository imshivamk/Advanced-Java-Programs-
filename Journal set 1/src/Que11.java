import java.util.*;

public class Que11 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Alex", "Charlie"));
        Iterator<String> it = list.iterator();

        System.out.print("All: ");
        while (it.hasNext()) {
            String s = it.next();
            System.out.print(s + " ");
        }

        it = list.iterator(); // reset iterator
        while (it.hasNext())
            if (it.next().startsWith("A")) it.remove();

        System.out.println("\nAfter removal: " + list);
    }
}
