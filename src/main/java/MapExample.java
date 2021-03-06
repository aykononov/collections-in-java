import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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