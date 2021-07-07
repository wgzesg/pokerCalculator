package poker.src.ui;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import poker.src.logic.*;

public class SimpleUi {

    JFrame frame;
    Container container;

    YourCardsPanel yourCards;
    CommonCardsPanel commonCards;
    JSlider playerCount;
    JPanel players;
    JPanel result;
    Form form; 

    public void initGUi() {
        frame = new JFrame();
        container = frame.getContentPane();
        container.setLayout(new GridLayout(4, 1));
        form = new Form();
        initYourCard();
        initCommonCards();
        initPlayers();
        initResult();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 750);
        frame.setVisible(true);
    }

    private void initYourCard() {
        yourCards = new YourCardsPanel();
        container.add(yourCards);
    }

    private void initCommonCards() {
        commonCards = new CommonCardsPanel();
        container.add(commonCards);
    }

    private void initPlayers() {
        players = new JPanel();
        JLabel label = new JLabel("对手个数：");
        playerCount = new JSlider(2, 10, 2);
        playerCount.setBounds(100,20,165,25);
        playerCount.setPaintLabels(true);
        playerCount.setMajorTickSpacing(1);
        players.add(label);
        players.add(playerCount);
        container.add(players);
    }

    private void initResult() {
        result = new JPanel();
        JButton confirm = new JButton("计算");
        JLabel winRate = new JLabel("Unknown");
        confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GameTable gt = new GameTable(yourCards.getHand(), commonCards.getCommons(), playerCount.getValue());
                Double chance = gt.runSimulation();
                winRate.setText(chance.toString());
                winRate.revalidate();
            }
            
        });
        result.add(confirm);
        result.add(winRate);
        container.add(result);
    }
}