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