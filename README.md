# collections-in-java

[Коллекции в Java](https://java-master.com/коллекции-в-java/ "https://java-master.com/коллекции-в-java/")

### В чем еще преимущество использования коллекций:

* удобство тестирования кода;
* структуры данных на любой вкус и потребность;
* повторное использование кода.

В Java есть два главных интерфейса от которых и наследуются все остальные классы коллекций:  

**Collection** — хранит набор объектов в виде массива: есть объект он помещается в ячейку. С ним возможны все манипуляции: удаление, вставка нового, поиск и т.д.

**Map** — хранит данные в виде пары «ключ-значение».

### От этих интерфейсов идет реализация классов:

**ArrayList** — коллекция на основе массива. Имеет свойство изменять свой размер в зависимости от того удаляются или добавляются элементы.

**LinkedList** — коллекция на основе связанного списка. Элементы помещенные в данную коллекцию сохраняют свой порядок вставки. То есть, в каком порядке был вставлен элемент, в таком порядке он будет при выводе. Каждый элемент, который хранится в *LinkedList*, содержит ссылки на «соседей». Это упрощает добавление и удаление элементов в списке.

**ArrayList** и **Vector** предпочтительнее использовать для *поиска* элементов, потому что эти классы используют *индексы* для доступа к элементам. Однако *вставка* и *удаление* элементов для них будет медленнее, чем *LinkedList*.

**Vector** — тот же самый *ArrayList* с той разницей, что методы данной коллекции синхронизированы. То есть, *потокобезобасны*.

**Stack** — список, который реализует данные *стека*. Элементы размещаются по принципу LIFO (last-in, first-out) — последний пришел, первым ушел.

```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();//создание нового списка
        stringList.add("Ivan");//добавление элементов
        stringList.add("Elena");
        stringList.add("Sergey");

        System.out.println("Размер списка: " + stringList.size());
        System.out.println("Получить элемент по индексу [1]: " + stringList.get(1));
        System.out.println("Проверка списка на пустоту: " + stringList.isEmpty());
        System.out.print("Просто вывод элементов: ");
        stringList.stream().forEach(s -> System.out.print(s + " "));//очень полезный метод стрим
        System.out.print("\nПоиск элемнта начинающегося c (I): ");
        stringList.stream().filter(s -> s.startsWith("I")).map(String::toLowerCase).forEach(System.out::println);
    }

}

/* --------------------------------------
Размер списка: 3
Получить элемент по индексу [1]: Elena
Проверка списка на пустоту: false
Просто вывод элементов: Ivan Elena Sergey
Поиск элемнта начинающегося c (I): ivan
 */
```

[пример ListExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java")

**Set** — коллекция, которая не содержит повторяющихся элементов, т.е. в сет можно добавить только уникальные объекты. Методы данной структуры такие же как в *List*.

**HashSet** — набор, в котором элементы хранятся в *хеш-таблице*. У элементов нет строгого порядка. *HashSet* использует метод *hashCode*  для определения своих элементов и размещения их в наборе.

**LinkedHashSet** — элементы хранятся в виде *связанного списка*. Только элементы хранятся в *сортированном* виде.

**TreeSet** — хранит элементы в структуре данных *дерева*, которая также сортируется и доступна для навигации. Методы добавить, удалить и получить элемент, гарантируют работу в log(n) времени, где n — количество элементов в дереве.

```java
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
```

[пример SetExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/SetExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/SetExample.java")

**Queue** — коллекция, которая хранит элементы в определенном порядке, нужном для их обработки. Помимо основных методов *Collection* в этом интерфейсе добавлены дополнительные методы вставки, проверки, извлечения. В данной коллекции элементы обычно размещаются в порядке FIFO (first-in, first-out) — первым пришел, первым ушел.  

Отличия от стандартных методов *Collection* заключаются в том, что если стандартные методы генерируют *исключения*, то методы Queue возвращают специальное значение.

**PriorityQueue** — очередь, в которой элементы упорядочиваются на основании заданного вами параметра(в отличие от параметра на основе FIFO). Эта очередь упорядочивает элементы либо по их натуральному порядку (используя интерфейс Comparable), либо с помощью интерфейса Comparator, полученному в конструкторе.

```java
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
```

[пример QueueExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/QueueExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/QueueExample.java")