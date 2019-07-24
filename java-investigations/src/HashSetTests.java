import java.util.HashSet;
import java.util.Set;

public class HashSetTests {
    private static HashSet<String> hSet = new HashSet<>();
    private static Set<String> set;

    public static void main(String[] args) {
        String s = "Hello";
        String ss = "Hello";
        System.out.println(hSet.add(s)); // True
        System.out.println(hSet.add(ss)); // False
    }
}
