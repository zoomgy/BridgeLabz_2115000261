import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr, int max) {
        int[] count = new int[max + 1];
        for (int num : arr)
            count[num]++;
        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i]-- > 0)
                arr[index++] = i;
        }
    }

    public static void main(String[] args) {
        int[] ages = { 12, 15, 10, 14, 18, 13, 17 };
        countingSort(ages, 18);
        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }
}
