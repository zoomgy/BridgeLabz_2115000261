import java.util.*;

public class MapExamples {

    // 1. Word Frequency Counter
    public static Map<String, Integer> wordFrequency(String text) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    // 2. Invert a Map<K, V> to Map<V, List<K>>
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return invertedMap;
    }

    // 3. Find the Key with the Highest Value
    public static <K> K findMaxValueKey(Map<K, Integer> map) {
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    // 4. Merge Two Maps
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return mergedMap;
    }

    // 5. Group Employees by Department
    static class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee emp : employees) {
            departmentMap.computeIfAbsent(emp.department, k -> new ArrayList<>()).add(emp);
        }
        return departmentMap;
    }

    public static void main(String[] args) {
        // 1. Word Frequency Counter
        String text = "Hello world, hello Java!";
        System.out.println("Word Frequency: " + wordFrequency(text));

        // 2. Invert a Map
        Map<String, Integer> mapToInvert = Map.of("A", 1, "B", 2, "C", 1);
        System.out.println("Inverted Map: " + invertMap(mapToInvert));

        // 3. Find Key with Highest Value
        Map<String, Integer> scoreMap = Map.of("A", 10, "B", 20, "C", 15);
        System.out.println("Key with Max Value: " + findMaxValueKey(scoreMap));

        // 4. Merge Two Maps
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);
        System.out.println("Merged Map: " + mergeMaps(map1, map2));

        // 5. Group Employees by Department
        List<Employee> employees = List.of(new Employee("Alice", "HR"), new Employee("Bob", "IT"),
                new Employee("Carol", "HR"));
        System.out.println("Grouped Employees: " + groupByDepartment(employees));
    }
}
