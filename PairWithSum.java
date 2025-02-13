import java.util.*;

public class PairWithSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 15, 3, 7 };
        int target = 17;
        System.out.println(hasPairWithSum(arr, target)); // true
    }
}
