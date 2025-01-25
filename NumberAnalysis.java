import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        for (int num : numbers) {
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is positive and even.");
                } else {
                    System.out.println(num + " is positive and odd.");
                }
            } else if (num < 0) {
                System.out.println(num + " is negative.");
            } else {
                System.out.println(num + " is zero.");
            }
        }
        if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First element is greater than the last.");
        } else if (numbers[0] < numbers[numbers.length - 1]) {
            System.out.println("First element is less than the last.");
        } else {
            System.out.println("First and last elements are equal.");
        }
        sc.close();
    }
}
