import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;


public class EmployeeList {
    public static void main(String[] args) {
        String[] employees = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                              "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                              "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                              "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                              "Петр Петин", "Иван Ежов"};

        Map<String, Integer> namesCount = new HashMap<>();

        for (String employee : employees) {
            Integer count = namesCount.get(employee);
            if (count == null) {
                count = 0;
            }
            namesCount.put(employee, count + 1);
        }

        TreeMap<Integer, List<String>> sortedNamesCount = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : namesCount.entrySet()) {
            String name = entry.getKey();
            Integer count = entry.getValue();

            List<String> names = sortedNamesCount.get(count);
            if (names == null) {
                names = new ArrayList<>();
                sortedNamesCount.put(count, names);
            }
            names.add(name);
        }

        for (Map.Entry<Integer, List<String>> entry : sortedNamesCount.entrySet()) {
            Integer count = entry.getKey();
            List<String> names = entry.getValue();

            for (String name : names) {
                System.out.println(name + ": " + count);
            }
        }
    }
}
