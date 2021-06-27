public class Card implements Comparable<Card> {
    public Suit suit;
    public CardNumber number;

    public Card(Suit s, CardNumber n) {
        this.suit = s;
        this.number = n;
    }

    public int getNumber() {
        return number.index;
    }

    public Suit getSuit() {
        return this.suit;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card)) {
            return false;
        }
        return this.getSuit() == ((Card) obj).getSuit() && this.getNumber() == ((Card) obj).getNumber();
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(getNumber(), o.getNumber());
    }

    @Override
    public String toString() {
        return suit + "" + number;
    }
}
