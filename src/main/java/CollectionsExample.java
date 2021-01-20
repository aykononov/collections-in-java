import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsExample {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("India");
        arrayList.add("America");
        arrayList.add("Russia");
        arrayList.add("Denmark");
        arrayList.add("Great Britain");
        arrayList.add(null);

        System.out.println("arrayList: " + arrayList.toString());

        // Естевственная сортировка
        Collections.sort(arrayList);
        System.out.println("Естевственная сортировка: " + arrayList.toString());

        // Обратная сортировка
        Collections.sort(arrayList, Comparator.reverseOrder());
        System.out.println("Обратная сортировка: " + arrayList.toString());

        System.out.print("Вывод в цикле ForEach: ");
        for (String n : arrayList) {
            System.out.print(n + " ");
        }

        HashMap<Integer,String> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(i,arrayList.get(i));
        }
        System.out.println("\nhashMap: " + hashMap.toString());
        System.out.println("Вывод в цикле ForEach: ");
        for (Map.Entry<Integer,String> me : hashMap.entrySet()) {
            System.out.println(me.getKey() + " = " + me.getValue());
        }
        //hashMap.put(6,"");
        //hashMap.put(6,null);
        System.out.println(hashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));
        System.out.println("\nhashMap: " + hashMap.toString());
    }
}
