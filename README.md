# collections-in-java

[Коллекции в Java](https://java-master.com/коллекции-в-java/ "https://java-master.com/коллекции-в-java/")

## Коллекция — это объект, который хранит другие объекты.

### В чем преимущество использования коллекций:

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

<details><summary>ListExample...</summary>

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
</details>

[пример ListExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java")

**Set** — коллекция, которая не содержит повторяющихся элементов, т.е. в сет можно добавить только уникальные объекты. Методы данной структуры такие же, как и в *List*.

**HashSet** — набор, в котором элементы хранятся в *хеш-таблице*. У элементов нет строгого порядка. *HashSet* использует метод *hashCode*  для определения своих элементов и размещения их в наборе.

**LinkedHashSet** — элементы хранятся в виде *связанного списка*. Только элементы хранятся в *сортированном* виде.

**TreeSet** — хранит элементы в структуре данных *дерева*, которая также сортируется и доступна для навигации. Методы добавить, удалить и получить элемент, гарантируют работу в log(n) времени, где n — количество элементов в дереве.

<details><summary>SetExample...</summary>

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
</details>

[пример SetExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/SetExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/SetExample.java")

**Queue** — коллекция, которая хранит элементы в определенном порядке, нужном для их обработки. Помимо основных методов *Collection* в этом интерфейсе добавлены дополнительные методы вставки, проверки, извлечения. В данной коллекции элементы обычно размещаются в порядке FIFO (first-in, first-out) — первым пришел, первым ушел.  

Отличия от стандартных методов *Collection* заключаются в том, что если стандартные методы генерируют *исключения*, то методы Queue возвращают специальное значение.

**PriorityQueue** — очередь, в которой элементы упорядочиваются на основании заданного вами параметра(в отличие от параметра на основе FIFO). Эта очередь упорядочивает элементы либо по их натуральному порядку (используя интерфейс Comparable), либо с помощью интерфейса Comparator, полученному в конструкторе.

<details><summary>QueueExample...</summary>

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
</details>

[пример QueueExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/QueueExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/QueueExample.java")

**Map** — это структура данных, которая хранит данные в виде <Ключ, Значение>. Каждое значение можно найти по его ключу. 

* *Map* не может содержать дубликаты ключей;
* Каждый ключ может отображать только одно значение;
* *Map* не расширяет интерфейс *Collection*.

У интерфейса *Map* есть несколько реализаций. Самые используемые и популярные это: *HashMap<K, V>, TreeMap<K, V>*.

**HashMap** — хранит ключи в *хэш-таблицы*. Она имеет наибольшую производительность. Однако такая реализация не гарантирует порядок элементов.

**TreeMap** — хранит ключи в *отсортированном* порядке. Работает медленнее, чем *HashMap*.

**LinkedHashMap** — хранит ключи в порядке их вставки в *Map*. Работает немного медленнее, чем *HashMap*.

**WeakHashMap** — реализация интерфейса *Map* на основе *хэш-таблицы* со слабыми ключами. Запись в WeakHashMap будет автоматически удалена, если ее ключ больше не используется обычным образом.

Скорость работы *HashMap* О(1), а в худшем случае O(logn). 

### Чтобы понять, когда будет худший случай, надо разобраться, как это работает:

У каждого объекта есть метод *hashCode*, который возвращает значение *хэш-кода*. Когда мы помещаем объект в *HashMap*, то сначала определяется значение *хэш-кода* его ключа, далее выбирается место, куда поместить объект в зависимости от полученного *хэш-кода*. Если по такому ключу уже есть значение в *мапе*, то проверяется объект, который мы пытаемся добавить и если он такой же как и существующий, то идет *перезапись*. 

Если объекты *разные*, а хэш-код *одинаковый* (произошла *коллизия* или мы неправильно переопределили метод hashCode), в этом случае объект помещается в ту самую ячейку в виде связанного списка *LinkedList*. Вот откуда худший случай работы *HashMap*. Когда хэш-код ключей *одинаковый*, то эта структура начинает работать, как *LinkedList* скорость которого O(logn). 

<details><summary>Как правильно переопределить метод hashCode, чтобы он возвращал одинаковое значение для всех объектов?</summary>

```java
public class MapOverrideMethod {

    private String name;
    private double sum;

    public MapOverrideMethod(String name, double sum) {
        this.name = name;
        this.sum = sum;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public static void main(String[] args) {
        
        MapOverrideMethod example1 = new MapOverrideMethod("Some name", 34);
        MapOverrideMethod example2 = new MapOverrideMethod("Another name", 12.5);
        System.out.println(example1.hashCode());
        System.out.println(example2.hashCode());
        
    }

}

/* ------------
1
1
 */
```
</details>

[переопределить метод hashCode - MapOverrideMethod.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapOverrideMethod.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapOverrideMethod.java")

Пример в которм рассмотрены, только самые популярные методы. Они во всех реализациях одинаковы.

<details><summary>MapExample...</summary>

```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer, String> users = new HashMap<>();
        users.put(1, "Ivan");//добавление элементов
        users.put(2, "Nataliya");
        users.put(3, "Anton");
        System.out.println("Получение по ключу (2): " + users.get(2));
        System.out.println("Проверка, существует ли значение с ключем (1): " + users.containsKey(1));
        System.out.println("Удаление по ключу (1): " + users.remove(1));
        System.out.println("Проверка, существует ли значение с ключем (1): " + users.containsKey(1));
        System.out.println("Размер мапы: " + users.size());
        System.out.println("Проверка пустая ли мапа: " + users.isEmpty());
        System.out.println("Элегантный вывод... ");
        users.forEach((k, v) -> System.out.println(k + ": " + v));

    }
}

/* --------------------------------------------------
Получение по ключу (2): Nataliya
Проверка, существует ли значение с ключем (1): true
Удаление по ключу (1): Ivan
Проверка, существует ли значение с ключем (1): false
Размер мапы: 2
Проверка пустая ли мапа: false
Элегантный вывод... 
2: Nataliya
3: Anton

 */

```
</details>

[пример MapExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapExample.java")

Важно о Map в java:

* желательно не использовать ключи, которые могут изменяться. Так можно потерять доступ к объекту;
* желательно всегда переопределять методы equals и hashCode в объектов, которые вы будете сравнивать, помещать или извлекать с коллекции (не только мап);
* две мапы равны если у них один и тот же набор пары ключ-значение.