package utils.io;

import java.util.Scanner;

public class StdDemo {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        double v1 = scanner.nextDouble();
        double v2 = scanner.nextDouble();
        scanner.nextLine();
        String line = scanner.nextLine();
        System.out.println(v1 + v2 + line);

    }
}

