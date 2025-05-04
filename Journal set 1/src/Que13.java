import java.util.*;

public class Que13 {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        Collections.addAll(set, 10, 20, 30, 40, 50); // a. & b.

        set.remove(30); // c.

        for (int n : set) // d.
            System.out.println(n);
    }
}
