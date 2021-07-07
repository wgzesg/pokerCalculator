package poker.src.ui;
import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

import poker.src.logic.Card;

public class CommonCardsPanel extends JPanel {

    List<CardSelectPanel> clist = new ArrayList<>();

    public CommonCardsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JPanel sliderPanel = new JPanel(new GridLayout(1, 2));
        JLabel label = new JLabel("已知公共牌张数:");
        JSlider commonCardCount = new JSlider(0, 5, 0);
        commonCardCount.setBounds(100,20,165,25);
        commonCardCount.setPaintLabels(true);
        commonCardCount.setMajorTickSpacing(1);
        sliderPanel.add(label);
        sliderPanel.add(commonCardCount);
        this.add(sliderPanel);
        commonCardCount.addChangeListener(new ChangeListener(){
            JPanel cardSelect;

            @Override
            public void stateChanged(ChangeEvent e) {
                JPanel panel = (JPanel) ((JSlider) e.getSource()).getParent().getParent();
                Integer newValue = ((JSlider) e.getSource()).getValue();
                if(cardSelect == null) {
                    cardSelect = new JPanel();
                    cardSelect.setLayout(new GridLayout(1, 5));
                    clist = new ArrayList<>();
                    panel.add(cardSelect);
                }
                while(clist.size() <= newValue) {
                    CardSelectPanel c = new CardSelectPanel();
                    clist.add(c);
                    cardSelect.add(c);
                }
                while(clist.size() > newValue) {
                    cardSelect.remove(clist.get(clist.size() - 1));
                    clist.remove(clist.size() - 1);
                }
                panel.revalidate();
            }
        });
    }

    public List<Card> getCommons() {
        List<Card> ls = new ArrayList<>();
        for(CardSelectPanel p: clist) {
            ls.add(p.getCard());
        }
        return ls;
    }
}
