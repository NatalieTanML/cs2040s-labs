/**
 * A0220822U
 * Tan Ming Li, Natalie
 */

import java.io.*;
import java.util.*;

public class cardtrading2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]); // no. of cards Anthony has
        int t = Integer.parseInt(input[1]); // no. of card types
        int k = Integer.parseInt(input[2]); // no. of combos

        input = br.readLine().split(" ");
        HashMap<Integer, Integer> cards = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(input[i]);
            if (cards.containsKey(card)) {
                cards.replace(card, cards.get(card) + 1);
            } else {
                cards.put(card, 1);
            }
        }

        List<CardPrice> cardPrices = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            input = br.readLine().split(" ");
            cardPrices.add(i, new CardPrice(
                    (2 - cards.get(i+1)) * Long.parseLong(input[0]),
                    cards.get(i+1) * Long.parseLong(input[1]))
            );
        }

        Collections.sort(cardPrices);
        long profit = 0;

        for (int i = 0; i < k; i++) {
            profit -= cardPrices.get(i).buyPrice;
        }
        for (int i = k; i < t; i++) {
            profit += cardPrices.get(i).sellPrice;
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.println(profit);
        pw.close();
        br.close();
    }
}

/**
 * Class to keep track of a card's buying & selling price
 */
class CardPrice implements Comparable<CardPrice> {
    public long buyPrice;
    public long sellPrice;

    public CardPrice(long buy, long sell) {
        this.buyPrice = buy;
        this.sellPrice = sell;
    }

    @Override
    public int compareTo(CardPrice o) {
        return Long.compare(this.buyPrice + this.sellPrice, o.buyPrice + o.sellPrice);
    }
}
