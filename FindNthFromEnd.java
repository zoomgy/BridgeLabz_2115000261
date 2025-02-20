import java.util.*;

public class FindNthFromEnd {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> slow = list.iterator();
        Iterator<T> fast = list.iterator();

        for (int i = 0; i < n; i++) {
            if (fast.hasNext())
                fast.next();
            else
                return null;
        }

        while (fast.hasNext()) {
            slow.next();
            fast.next();
        }
        return slow.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        System.out.println(findNthFromEnd(list, 2));
    }
}
