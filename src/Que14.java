import java.util.*;

public class Que14 {
    public static void main(String[] args) {
        Dictionary<String, String> dict = new Hashtable<>();

        dict.put("Java", "A high-level programming language");
        dict.put("Python", "An interpreted, high-level language");
        dict.put("HTML", "Markup language for web pages");

        Enumeration<String> keys = dict.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println(key + " : " + dict.get(key));
        }
    }
}
