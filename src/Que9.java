import java.util.*;

public class Que9 {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>();

        // Add elements
        v.add("Apple");
        v.add("Banana");
        v.add("Cherry");

        // Access element
        System.out.println("First: " + v.get(0));

        // Update element
        v.set(1, "Blueberry");

        // Search element
        System.out.println("Has Cherry? " + v.contains("Cherry"));

        // Remove element
        v.remove("Apple");

        // Display final vector
        System.out.println("Vector: " + v);
    }
}
