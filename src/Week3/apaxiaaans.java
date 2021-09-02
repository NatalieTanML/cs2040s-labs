/**
 * Tan Ming Li, Natalie
 * A0220822U
 */

import java.io.*;

public class apaxiaaans {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(removeDuplicates(input));
    }

    private static String removeDuplicates(String s) {
        if (s.length() <= 1)
            return s;
        if (s.charAt(0) == s.charAt(1))
            return removeDuplicates(s.substring(1));
        else
            return s.charAt(0) + removeDuplicates(s.substring(1));
    }
}
