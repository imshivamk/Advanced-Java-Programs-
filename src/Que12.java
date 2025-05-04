import java.util.*;

public class Que12 {
    static Set<Integer> unique_Numbers = new HashSet<>();

    public static void main(String[] args) {
        Random r = new Random();
        while (unique_Numbers.size() < 10)
            unique_Numbers.add(r.nextInt(20) + 1);

        System.out.println("Original: " + unique_Numbers);
        removeMultiples(5);
        System.out.println("After removing multiples of 5: " + unique_Numbers);
    }

    static void removeMultiples(int num) {
        unique_Numbers.removeIf(n -> n % num == 0);
    }
}
