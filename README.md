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

[пример ListExample.java](https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java "https://github.com/aykononov/collections-in-java/blob/main/src/main/java/ListExample.java")

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