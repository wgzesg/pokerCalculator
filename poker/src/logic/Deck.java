package poker.src.logic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class Deck {
    ArrayList<Card> cards = new ArrayList<>();
    int index;

    public Deck() {
        this.populate();
        this.shuffle();
    }

    private void populate() {
        for(Suit s : Suit.values()) {
            for(CardNumber n : CardNumber.values()) {
                cards.add(new Card(s, n));
            }
        }
    }

    public Card getCard() {
        return cards.get(index++);
    }

    public void remove(ArrayList<Card> commons) {
        for (Card card : commons) {
            cards.remove(card);
        }
    }

    public void remove(Hand hand) {
        cards.remove(hand.first);
        cards.remove(hand.second);
    }

    public void shuffle() {
        Collections.shuffle(cards);
        index = 0;
    }

    @Override
    public String toString() {
        return "Deck contains " + cards.size() + " cards";
    }
}
