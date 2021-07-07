package poker.src.ui;

import java.util.Enumeration;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.BoxLayout;  
import java.awt.GridLayout;  
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.AbstractButton;

import poker.src.logic.*;

public class CardSelectDialog extends JDialog {
    JPanel panel;
    ButtonGroup suit;
    ButtonGroup number;
    JButton  confirm;

    CardAvatar avatar;

    public CardSelectDialog(CardAvatar cardAvatar) {
        this.avatar = cardAvatar;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        suit = new ButtonGroup();
        number = new ButtonGroup();
        JPanel suitPanel = new JPanel();
        JPanel numberPanel = new JPanel(new GridLayout(2, 7));

        for(Suit s : Suit.values()) {
            JRadioButton btn = new JRadioButton(s.toString(), false);
            if (s== Suit.Spade) {
                btn.setSelected(true);
            }
            suit.add(btn);
            suitPanel.add(btn);
        }

        for(CardNumber n : CardNumber.values()) {
            JRadioButton btn = new JRadioButton(n.toString(), false);
            if (n== CardNumber.Two) {
                btn.setSelected(true);
            }
            number.add(btn);
            numberPanel.add(btn);
        }

        confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();
                CardSelectDialog frame = (CardSelectDialog) SwingUtilities.getRoot(component);
                frame.updateButton();
                frame.setVisible(false);
            }
            
        });
        panel.add(suitPanel);
        panel.add(numberPanel);
        panel.add(confirm);
        add(panel);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(400, 250);
    }

    private void updateButton() {
        Card c = getCard();
        avatar.setCard(c);
    }

    public Card getCard() {
        String s = getSelectedButtonText(number);
        CardNumber n = CardNumber.getNumber(s);
        s = getSelectedButtonText(suit);
        Suit ss = Suit.getSuit(s);
        return new Card(ss, n);
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons =  buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}
