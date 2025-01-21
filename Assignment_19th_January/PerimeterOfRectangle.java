package Assignment_01_19thJanuary;

import java.util.Scanner;

public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double perimeter = 2 * (length + width);
        System.out.println(perimeter);
        scanner.close();
    }
}
