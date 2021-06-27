package poker.src;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class controller {

    @FXML
    private Slider knowCards;
    @FXML
    private Slider playerCount;
    @FXML
    private GridPane knownCardsPlaceholder;
    @FXML
    private Button calculate;

    @FXML
    private cardSelectorController card_1Controller;
    @FXML
    private cardSelectorController card_2Controller;
    @FXML
    private Text resultPlaceholder;

    private List<cardSelectorController> controllers;

    public void initialize() throws IOException {
        knowCards.valueProperty().addListener((observable, oldValue, newValue) -> {
            knownCardsPlaceholder.getChildren().clear();
            controllers = new ArrayList<>();
            for(int i = 0; i < newValue.intValue(); i++) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxml/cardSelector.fxml"));
                    Node n = loader.load();
                    knownCardsPlaceholder.add(n, 1, i);
                    controllers.add(loader.getController());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    public void buttonClicked(Event e){
        int numOfPlayers = playerCount.valueProperty().getValue().intValue();
        Hand yourHand = new Hand(card_1Controller.getCard(), card_2Controller.getCard());
        int knownCards = knowCards.valueProperty().getValue().intValue();
        List<Card> cards = new ArrayList<>();
        for(int i = 0; i < knownCards; i++){
            cards.add(controllers.get(i).getCard());
        }
        GameTable gt = new GameTable(yourHand, cards, numOfPlayers);
        Double chance = gt.runSimulation();
        resultPlaceholder.setText(chance.toString());
    }

}
