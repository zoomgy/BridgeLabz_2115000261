import java.util.*;

public class MyHashMap<K, V> {
    private static final int SIZE = 1000;
    private List<Entry<K, V>>[] buckets;

    public MyHashMap() {
        buckets = new ArrayList[SIZE];
    }

    private int getBucketIndex(K key) {
        return key.hashCode() % SIZE;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null)
            buckets[index] = new ArrayList<>();

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key))
                    return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            buckets[index].removeIf(entry -> entry.key.equals(key));
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        System.out.println(map.get("one")); // 1
        map.remove("one");
        System.out.println(map.get("one")); // null
    }
}
