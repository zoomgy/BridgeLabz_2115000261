package Assignment04;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int count = 0;

        while (number != 0) {
            number /= 10; // Remove last digit
            count++;
        }

        System.out.println("The number of digits is: " + count);
        sc.close();
    }
}
