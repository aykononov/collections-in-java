import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CollectionSpeedTest {
    public static void main(String[] args) {
        List<Integer> arrList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // заполняем колллекции
        for (int i = 0; i < 1000000; i++) {
            arrList.add(i);
            linkedList.add(i);
        }

        long arrListTime = System.currentTimeMillis();
        arrList.add(5000, 1111);
        System.out.println("arrList на вставку: " + (System.currentTimeMillis() - arrListTime));

        arrListTime = System.currentTimeMillis();
        arrList.get(500000);
        System.out.println("arrList на поиск: " + (System.currentTimeMillis() - arrListTime));

        long linkedListTime = System.currentTimeMillis();
        linkedList.add(5000, 1111);
        System.out.println("\nlinkedList на вставку: " + (System.currentTimeMillis() - linkedListTime));

        linkedListTime = System.currentTimeMillis();
        linkedList.get(500000);
        System.out.println("linkedList на поиск: " + (System.currentTimeMillis() - linkedListTime));
    }
}

/*-----------------------
arrList на вставку: 2
arrList на поиск: 0

linkedList на вставку: 0
linkedList на поиск: 9
 */