package poker.src.ui;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Arrays;

import poker.src.logic.Card;
import poker.src.logic.CardNumber;
import poker.src.logic.Suit;

public class CardSelectPanel extends JPanel {

    CardAvatar cardAvatar;
    IconMap iconMap;

    public CardSelectPanel() {

        iconMap = IconMap.getInstance();

        cardAvatar = new CardAvatar();

        cardAvatar.addActionListener(new ActionListener() {

            CardSelectDialog dialog = new CardSelectDialog(cardAvatar);
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
            
        });

        this.add(cardAvatar);
    }

    public Card getCard() {
        return cardAvatar.getCard();
    }
}
