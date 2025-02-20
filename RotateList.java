import java.util.*;

public class RotateList {
    public static <T> void rotateList(List<T> list, int k) {
        int n = list.size();
        Collections.rotate(list, -k);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        rotateList(list, 2);
        System.out.println(list);
    }
}
