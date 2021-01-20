## collections-in-java

[Коллекции в Java](https://java-master.com/коллекции-в-java/ "https://java-master.com/коллекции-в-java/")

## Вопросы с собеседований:

### 29.12.2020 УБРР (Кирилл Полькин)

- EntityGrace/Group
- SOLID  
- HashMap и HashSet(внутри использует HashMap) , как работает внутри HashMap
- Что такое hashcode() - в каком виде он представлен
- Типы классов(локальные, вложенные)
- Лямбда-выражения , это функция которая определеяет только один метод
- Функциональный интерфейс - имеет только один метод.  
- StreamAPI, что будет если вызвать из коллекции.strem.sorted.filter , но не использовать .collect(Collectors.toList())
- .collect(Collectors.toList()) - коллект передает поток в виде коллекции
- Почему при создании Класса, он имеет уже некотррые методы, которые мы не определяли?.(класс Object, от него наследуются все классы)
- Какие аннотации в Spinge

### 23.12.2020 Систематика Консалтинг (Алексей скайп)

Модификаторы доступа:

- **public**: Публичный класс. Поля и методы, его видны другим классам из текущего пакета и из внешних пакетов.

- **private**: Закрытый класс или член класса, доступен только из кода в том же классе.

- **protected**: такой класс или член класса доступен из любого места в текущем классе или пакете или в производных классах, даже если они находятся в других пакетах

- **модификатор по умолчанию**. Отсутствие модификатора у поля или метода класса предполагает применение к нему модификатора по умолчанию. Такие поля или методы видны всем классам в текущем пакете.

- **модификатор static** При создании объектов класса для каждого объекта создается своя копия нестатических обычных полей. А статические поля являются общими для всего класса. Поэтому они могут использоваться без создания объектов класса.

**Инкапсуляция** – сокрытие данных внутри объекта и обеспечение доступа к ним с помощью общедоступных методов.

**Наследование или расширение** – приобретение одним классом (подклассом) свойств другого класса (суперкласса).

**Полиморфизм** – возможность единообразно обрабатывать объекты разных типов. 
Различают полиморфизм включения (или полиморфизм подтипов), который позволяет обращаться с помощью единого интерфейса к классу и к любым его потомкам, 
и параметрический полиморфизм, который определяет обобщенный интерфейс с одинаковой реализацией.

<details><summary>пример Полиморфизма...</summary>

```java
// Объявления классов
public class Shape {  
    abstract void draw(); 
}

public class Rectangle extends Shape {  
    void draw() {
    } 
} 

public class Circle extends Shape {
    void draw() {
    } 
}

//Использование полиморфизма 
public class Figures {
    public static void main(String[] args) {
        Shape rect;
        Shape circ;
        
        rect = new Rectangle();
        circ = new Circle();
        
        rect.draw();
        circ.draw();
    }
}
```

</details>

Есть объект ключ - значение, отсортировать по значению (HashMAP сортировка)

Thread, deamon.

Коллекции – это классы для сохранения, получения, манипулирования множеством объектов.

### В чем преимущество использования коллекций:

* удобство тестирования кода;
* структуры данных на любой вкус и потребность;
* повторное использование кода.

В Java есть два главных интерфейса от которых и наследуются все остальные классы коллекций:  

**Collection** — хранит набор объектов в виде массива: есть объект он помещается в ячейку. С ним возможны все манипуляции: удаление, вставка нового, поиск и т.д.

**Map** — хранит данные в виде пары «ключ-значение».

### От этих интерфейсов идет реализация классов:

**ArrayList** — коллекция построена на основе *массива*. Имеет свойство изменять свой размер в зависимости от того удаляются или добавляются элементы.  
Его предпочтительнее использовать для *поиска* и *изменения* элементов, так как этот класс использует *индексы* для доступа к соответствующему элементу.  
Однако *вставка* и *удаление* элементов для него будет выполняться медленнее, так как сначала нужно *сдвигать* на один все элементы, только потом в освободившееся место вставлять новый элемент.

**LinkedList** — коллекция реализована в виде *связанного списка*: набора отдельных элементов, каждый из которых хранит ссылку на следующий и предыдущий элементы.  
Чтобы *вставить* элемент в середину такого списка, достаточно поменять ссылки его будущих соседей. А вот чтобы *получить* элемент напрмиер с номером 130, то нужно пройтись последовательно по всем объектам от 0 до 130.   
Поэтому если мы собираемся *вставлять* или *удалять* много элементов в середину коллекции, то лучше использовать *LinkedList*.  
Во всех остальных случаях предпочтительнее будет *ArrayList*.

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

[пример ListExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java")

</details>

### тест скорости работы колллекций ArrayList и LinkedList

<details><summary>CollectionSpeedTest...</summary>

```java
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
```
[пример CollectionSpeedTest.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/CollectionSpeedTest.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/CollectionSpeedTest.java")

</details>

**Set** — коллекция, которая не содержит повторяющихся элементов, т.е. в сет можно добавить только уникальные объекты. Методы данной структуры такие же, как и в *List*.

**HashSet** — набор, в котором элементы хранятся в *хеш-таблице*. У элементов нет строгого порядка. *HashSet* использует метод *hashCode*  для определения своих элементов и размещения их в наборе.

**LinkedHashSet** — элементы хранятся в виде *связанного списка*. Только элементы хранятся в *отсортированном* виде.

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

[пример SetExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/SetExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/SetExample.java")

</details>

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

[пример QueueExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/QueueExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/QueueExample.java")

</details>

**Map** — это структура данных, которая хранит данные в виде <Ключ, Значение>, каждое значение можно найти по его ключу. 

* *Map* не может содержать дубликаты ключей;
* Каждый ключ может отображать только одно значение;

**HashMap** — хранит ключи в *хэш-таблице*. Она имеет наибольшую производительность. Однако такая реализация не гарантирует порядок элементов.

**TreeMap** — хранит ключи в *отсортированном* порядке. Работает медленнее, чем *HashMap*.

**LinkedHashMap** — хранит ключи в порядке их вставки в *Map*. Работает немного медленнее, чем *HashMap*.

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

[переопределить метод hashCode - MapOverrideMethod.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapOverrideMethod.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapOverrideMethod.java")

</details>

Пример в которм рассмотрены, только самые популярные методы. Они во всех реализациях одинаковы.

<details><summary>MapExample...</summary>

```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer, String> users = new HashMap<>();
        users.put(1, "Ivan"); //добавление элементов
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

        System.out.println("Отобразить множество элементов: " + users.entrySet());
        System.out.println("Получить ключи: " + users.keySet());
        System.out.println("Получить значения: " + users.values());

    }
}

/* --------------------------------------------------
Получение по ключу (2): Nataliya
Проверка, существует ли значение с ключем (1): true
Удаление по ключу (1): Ivan
Проверка, существует ли значение с ключем (1): false
Размер мапы: 2
Проверка пустая ли мапа: false

Элегантный вывод: 
 2: Nataliya
 3: Anton

Отобразить множество элементов: [2=Nataliya, 3=Anton]
Получить ключи: [2, 3]
Получить значения: [Nataliya, Anton]

 */

```

[пример MapExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/MapExample.java")

</details>

Важно о Map в java:

* желательно не использовать ключи, которые могут изменяться. Так можно потерять доступ к объекту;
* желательно всегда переопределять методы equals и hashCode в объектов, которые вы будете сравнивать, помещать или извлекать с коллекции (не только мап);
* две мапы равны если у них один и тот же набор пары ключ-значение.