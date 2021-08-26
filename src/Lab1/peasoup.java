package Lab1;

/**
 * Tan Ming Li, Natalie
 * A0220822U
 */

import java.util.*;

public class peasoup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); // no. of restaurants
        boolean found = false;
        String name = "";

        while (n-- > 0 && !found) {
            int k = Integer.parseInt(sc.nextLine()); // no. of menu items
            String input = sc.nextLine(); // name of restaurant;
            boolean ps = false, pc = false;
            while (k-- > 0) {
                String item = sc.nextLine();
                if (item.equals("pea soup"))
                    ps = true;
                else if (item.equals("pancakes"))
                    pc = true;
            }
            if (ps && pc) {
                found = true;
                name = input;
            }
        }

        if (found)
            System.out.println(name);
        else
            System.out.println("Anywhere is fine I guess");

    }
}
