/**
 * A0220822U
 * Tan Ming Li, Natalie
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class cardtrading {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // no. of cards Anthony has
        int t = Integer.parseInt(input[1]); // no. of card types
        int k = Integer.parseInt(input[2]); // no. of combos

        ArrayList<Card> cards = new ArrayList<>();
        for (i = 0; i < t; i++) {
            Card card = new Card();
            cards.add(card);
        }

        input = br.readLine().split(" "); // current cards in his deck

        for (i = 0; i < n; i++) {
            Card curr = cards.get(Integer.parseInt(input[i]) - 1);
            curr.setQuantity(curr.getQuantity() + 1);
        }

        for (i = 0; i < t; i++) {
            input = br.readLine().split(" ");
            Card curr = cards.get(i);
            long qty = curr.getQuantity();
            curr.setBuyPrice((2 - qty) * Integer.parseInt(input[0]));
            curr.setSellPrice(qty * Integer.parseInt(input[1]));
        }

        Collections.sort(cards);
        long profit = 0;

        for (i = 0; i < k; i++) {
            profit -= cards.get(i).getBuyPrice();
        }

        for (i = k; i < t; i++) {
            profit += cards.get(i).getSellPrice();
        }

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.println(profit);
        pw.close();
        br.close();
    }
}

class Card implements Comparable<Card> {
    private long quantity;
    private long buyPrice;
    private long sellPrice;

    public Card(long qty, long bp, long sp) {
        this.quantity = qty;
        this.buyPrice = bp;
        this.sellPrice = sp;
    }

    public Card() {
        this.quantity = 0;
        this.buyPrice = 0;
        this.sellPrice = 0;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public void setBuyPrice(long buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setSellPrice(long sellPrice) {
        this.sellPrice = sellPrice;
    }

    public long getBuyPrice() {
        return this.buyPrice;
    }

    public long getSellPrice() {
        return this.sellPrice;
    }

    public long getQuantity() {
        return this.quantity;
    }

    @Override
    public int compareTo(Card c) {
        return Long.compare(
                this.getBuyPrice() + this.getSellPrice(),
                c.getBuyPrice() + c.getSellPrice()
        );
    }
}
