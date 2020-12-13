import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Comparator<Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer comp1, Integer comp2) {
            //настроим метод таким образом, что элементы будут добавляться в обратном порядке
                if( comp1 > comp2 ){
                    return -1;
                }
                if( comp1 < comp2 ){
                    return 1;
                }
                return 0;
            }
        };

        Queue<Integer> priorityQueue = new PriorityQueue<>(10, comparator);
        priorityQueue.add(7);
        priorityQueue.add(4);
        priorityQueue.add(9);
        priorityQueue.add(1);
        priorityQueue.add(80);
        System.out.println(priorityQueue);
        System.out.println(priorityQueue.poll());//удаление сверху
        System.out.println(priorityQueue.peek());//получить верхний
        System.out.println(priorityQueue);
    }

}

/* -------------
[80, 9, 7, 1, 4]
80
9
[9, 4, 7, 1]

 */