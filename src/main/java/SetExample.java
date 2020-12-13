import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(20);
        set.add(15);
        set.add(30);
        set.add(30);
        set.add(30);
        System.out.println(set);
        set.remove(20);
        System.out.println(set);
    }

}

/* ---------
[15, 20, 30]
[15, 30]
 */