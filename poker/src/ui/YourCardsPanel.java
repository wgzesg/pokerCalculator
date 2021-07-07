package poker.src.ui;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import poker.src.logic.Hand;

public class YourCardsPanel extends JPanel {

    CardSelectPanel c1;
    CardSelectPanel c2;

    public YourCardsPanel() {
        JLabel l1 = new JLabel("你的手牌:");
        this.add(l1);
        c1 = new CardSelectPanel();
        c2 = new CardSelectPanel();
        this.add(c1);
        this.add(c2);
    }

    public Hand getHand() {
        return new Hand(c1.getCard(), c2.getCard());
    }
}
