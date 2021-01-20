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
        System.out.println("arrList вставка: " + (System.currentTimeMillis() - arrListTime));

        arrListTime = System.currentTimeMillis();
        arrList.get(900000);
        System.out.println("arrList поиск: " + (System.currentTimeMillis() - arrListTime));

        arrListTime = System.currentTimeMillis();
        arrList.remove(5000);
        System.out.println("arrList удаление: " + (System.currentTimeMillis() - arrListTime));

        long linkedListTime = System.currentTimeMillis();
        linkedList.add(5000, 1111);
        System.out.println("\nlinkedList вставка: " + (System.currentTimeMillis() - linkedListTime));

        linkedListTime = System.currentTimeMillis();
        linkedList.get(900000);
        System.out.println("linkedList поиск: " + (System.currentTimeMillis() - linkedListTime));

        linkedListTime = System.currentTimeMillis();
        linkedList.remove(5000);
        System.out.println("linkedList удаление: " + (System.currentTimeMillis() - linkedListTime));
    }
}

/*-----------------------
arrList вставка: 1
arrList поиск: 0
arrList удаление: 4

linkedList вставка: 0
linkedList поиск: 6
linkedList удаление: 0
 */