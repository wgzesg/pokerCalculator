package poker.src;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class cardSelectorController {

    @FXML
    private ComboBox<Suit> suit;
    @FXML
    private ComboBox<CardNumber> number;
    
    public void initialize() {
        suit.getItems().addAll(Suit.values());
        suit.setValue(Suit.Spade);
        number.getItems().addAll(CardNumber.values());
        number.setValue(CardNumber.Two);
    }

    public Card getCard() {
        Suit s = suit.valueProperty().getValue();
        CardNumber num = number.valueProperty().getValue();
        return new Card(s,num);
    }
}
