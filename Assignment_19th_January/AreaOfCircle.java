package Assignment_01_19thJanuary;

import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        double area = Math.PI * radius * radius;
        System.out.println(area);
        scanner.close();
    }
}
