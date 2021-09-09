/**
 * A0220822U
 * Tan Ming Li, Natalie
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class sortofsorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            ArrayList<String> listNames = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String name = br.readLine();
                listNames.add(name);
            }
            listNames.sort(new ComparatorTwo());
            listNames.sort(new ComparatorOne());
            for (String name : listNames) {
                pw.println(name);
            }
            pw.println();
            n = Integer.parseInt(br.readLine());
        }
        pw.close();
        br.close();
    }
}

class ComparatorOne implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Character.compare(o1.charAt(0), o2.charAt(0));
    }
}

class ComparatorTwo implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Character.compare(o1.charAt(1), o2.charAt(1));
    }
}

/*
Pseudocode

comparatorOne = { ... return Character.compare(o1.charAt(0), o2.charAt(0)) }
comparatorTwo = { ... return Character.compare(o1.charAt(1), o2.charAt(1)) }

n = no. of last names

while (n != 0)
    listNames = new ArrayList of size n
    for i=0 to n-1 do
        name = read line
        listNames.add(name)
    end for
    sort(listNames, comparatorOne)
    sort(listNames, comparatorTwo)
    print listNames
    print blank line
end while


 */
