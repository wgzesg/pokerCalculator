package poker.src.ui;

import javax.swing.Icon;
import javax.swing.JButton;

import poker.src.logic.Card;
import poker.src.logic.CardNumber;
import poker.src.logic.Suit;

public class CardAvatar extends JButton {
    Card card;
    private static IconMap iconMap = IconMap.getInstance();

    public CardAvatar() {
        super("Click to choose a card");
        card = null;
    }
    
    public CardAvatar(Icon ic, Card c) {
        super(ic);
        card = c;
    }

    public void setCard(Card c) {
        card = c;
        setIcon(iconMap.get(c.toString()));
        setText("");
    }

    public Card getCard() {
        return card;
    }
}
