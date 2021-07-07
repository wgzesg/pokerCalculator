package poker.src.logic;
public class Hand {
    Card first;
    Card second;

    Hand() {
        this.first = null;
        this.second = null;
    }
    public Hand(Suit first, Suit second, CardNumber fst, CardNumber scd) {
        this.first = new Card(first, fst);
        this.second = new Card(second, scd);
    }

    public Hand(Card c1, Card c2) {
        this.first = c1;
        this.second = c2;
    }

    @Override
    public String toString() {
        return first + ", " + second;
    }
}
