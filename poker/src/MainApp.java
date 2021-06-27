package poker.src;

import javax.swing.*;
import javax.swing.event.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainApp extends Application {

    JFrame frame;
    Container container;

    JPanel yourCards;
    JPanel commonCards;
    JPanel players;
    JPanel result;
    Form form; 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/fxml_example.fxml"));
    
        Scene scene = new Scene(root, 800, 500);
        stage.setTitle("FXML Welcome");
        stage.setScene(scene);
        stage.show();
    }


    // public void initGUi() {
    //     frame = new JFrame();
    //     container = frame.getContentPane();
    //     container.setLayout(new GridLayout(4, 1));
    //     form = new Form();
    //     initYourCard();
    //     initCommonCards();
    //     initPlayers();
    //     initResult();
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(300, 300);
    //     frame.setVisible(true);
    // }

    // private void initYourCard() {
    //     yourCards = new JPanel();
    //     JLabel l1 = new JLabel("你的手牌:");
    //     yourCards.add(l1);
    //     yourCards.add(cardSelectPanel("hand", 0));
    //     yourCards.add(cardSelectPanel("hand", 1));
    //     container.add(yourCards);
    // }

    // private void initCommonCards() {
    //     commonCards = new JPanel();
    //     commonCards.setLayout(new GridLayout());
    //     JLabel label = new JLabel("已知公共牌张数:");
    //     JSlider commonCardCount = new JSlider(0, 5, 0);
    //     commonCardCount.setBounds(100,20,165,25);
    //     commonCardCount.setPaintLabels(true);
    //     commonCardCount.setMajorTickSpacing(1);
    //     commonCardCount.addChangeListener(new ChangeListener(){
    //         JPanel cardSelect;

    //         @Override
    //         public void stateChanged(ChangeEvent e) {
    //             Integer newValue = ((JSlider) e.getSource()).getValue();
    //             if(cardSelect != null) {
    //                 commonCards.remove(cardSelect);
    //             }
    //             cardSelect = new JPanel();
    //             cardSelect.setLayout(new GridLayout(5, 1));
    //             for(int i = 0; i < newValue; i++) {
    //                 cardSelect.add(cardSelectPanel("commons", i));
    //             }
    //             commonCards.add(cardSelect);
    //             commonCards.revalidate();
    //         }
    //     });
        
    //     commonCards.add(label);
    //     commonCards.add(commonCardCount);
    //     container.add(commonCards);
    // }

    // private void initPlayers() {
    //     players = new JPanel();
    //     JLabel label = new JLabel("对手个数：");
    //     JSlider playerCount = new JSlider(2, 10, 2);
    //     playerCount.setBounds(100,20,165,25);
    //     playerCount.setPaintLabels(true);
    //     playerCount.setMajorTickSpacing(1);
    //     playerCount.addChangeListener(new ChangeListener(){

    //         @Override
    //         public void stateChanged(ChangeEvent e) {
    //             int value = ((JSlider)e.getSource()).getValue();
    //             form.numOfPlayers = value;
    //         } 

    //     });
    //     players.add(label);
    //     players.add(playerCount);
    //     container.add(players);
    // }

    // private void initResult() {
    //     result = new JPanel();
    //     JButton confirm = new JButton("计算");
    //     JLabel winRate = new JLabel("Unknown");
    //     confirm.addActionListener(new ActionListener() {

    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             GameTable gt = new GameTable(form.yourHand, Arrays.asList(form.commons), form.numOfPlayers);
    //             Double chance = gt.runSimulation();
    //             winRate.setText(chance.toString());
    //             winRate.revalidate();
    //         }
            
    //     });
    //     result.add(confirm);
    //     result.add(winRate);
    //     container.add(result);
    // }

    // private JPanel cardSelectPanel(String loc, int count) {
    //     JPanel panel = new JPanel();
    //     JComboBox<Suit> c1 = new JComboBox<Suit>();
    //     for (Suit s : Suit.values()) {
    //         c1.addItem(s);
    //     }
    //     JComboBox<CardNumber> c2 = new JComboBox<CardNumber>();
    //     for (CardNumber s : CardNumber.values()) {
    //         c2.addItem(s);
    //     }
    //     ActionListener l;
    //     if(loc.equals("hand")) {
    //         l = new ActionListener() {

    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //                 Suit s = (Suit) c1.getSelectedItem();
    //                 CardNumber n = (CardNumber) c2.getSelectedItem();
    //                 Card c = new Card(s,n);
    //                 if(count == 0) {
    //                     form.yourHand.first = c;
    //                 } else {
    //                     form.yourHand.second = c;
    //                 }
                    
    //             }
    //         };
    //     } else {
    //         l = new ActionListener() {
    //             @Override
    //             public void actionPerformed(ActionEvent e) {
    //                 Suit s = (Suit) c1.getSelectedItem();
    //                 CardNumber n = (CardNumber) c2.getSelectedItem();
    //                 Card c = new Card(s,n);
    //                 form.commons[count] = c;
                    
    //             }
    //         };
    //     }
    //     c1.addActionListener(l);
    //     c2.addActionListener(l);
    //     panel.add(c1);
    //     panel.add(c2);
    //     return panel;
    // }

}