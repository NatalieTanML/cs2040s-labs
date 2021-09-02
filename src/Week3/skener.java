package Week3;

import java.util.Arrays;
import java.util.Scanner;

public class skener {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int zr = scanner.nextInt();
        int zc = scanner.nextInt();

        scanner.nextLine();

        for (int i = 0; i < r; i++) {
            char[] line = scanner.nextLine().toCharArray();
            int len = line.length;
            char[] newLine = new char[len * zc];
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < zc; k++) {
                    newLine[(j * zc) + k] = line[j];
                }
            }
            for (int j = 0; j < zr; j++) {
                System.out.println(String.valueOf(newLine));
            }
        }
        scanner.close();
    }
}
