/**
 * A0220822U
 * Tan Ming Li, Natalie
 */

import java.io.*;
import java.util.HashMap;

public class t9spelling {
    public static void main(String[] args) throws IOException {
        HashMap<Character, String> map = new HashMap<>();
        map.put('a', "2");
        map.put('b', "22");
        map.put('c', "222");
        map.put('d', "3");
        map.put('e', "33");
        map.put('f', "333");
        map.put('g', "4");
        map.put('h', "44");
        map.put('i', "444");
        map.put('j', "5");
        map.put('k', "55");
        map.put('l', "555");
        map.put('m', "6");
        map.put('n', "66");
        map.put('o', "666");
        map.put('p', "7");
        map.put('q', "77");
        map.put('r', "777");
        map.put('s', "7777");
        map.put('t', "8");
        map.put('u', "88");
        map.put('v', "888");
        map.put('w', "9");
        map.put('x', "99");
        map.put('y', "999");
        map.put('z', "9999");
        map.put(' ', "0");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            int len = input.length;
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i+1).append(": ");

            for (int j = 0; j < len; j++) {
                String val = map.get(input[j]);
                sb.append(val);
                if (j+1 < len) {
                    String next = map.get(input[j+1]);
                    if (next.charAt(0) == val.charAt(0))
                        sb.append(' ');
                }
            }
            pw.println(sb);
        }

        br.close();
        pw.close();
    }
}
