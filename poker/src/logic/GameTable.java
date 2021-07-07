package poker.src.logic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameTable {

    Hand myHand;
    Hand players[];
    ArrayList<Card> knownCommons;
    ArrayList<Card> commons;
    Deck cardDeck;

    private static int rounds = 10000;
    int myWin = 0;

    public GameTable() {
        cardDeck = new Deck();
    }

    public GameTable(Hand myHand, List<Card> knowncommons, int numPlayers) {
        cardDeck = new Deck();
        this.myHand = myHand;
        this.knownCommons = new ArrayList<>(knowncommons);
        knownCommons.removeAll(Collections.singleton(null));
        players = new Hand[numPlayers - 1];
    }

    public double runSimulation(){
        cardDeck.remove(knownCommons);
        cardDeck.remove(myHand);
        for(int i = 0; i < rounds; i++) {
            monteOnce();
        }
        System.out.println("win rate is " + 1.0 * myWin / rounds);
        return 1.0 * myWin / rounds;
    }

    private void monteOnce() {
        cardDeck.shuffle();
        this.dealCards();
        this.dealCommons();
        Combination myCombi = GameLogic.getBestCombi(myHand, commons);
        for (Hand player : players) {
            Combination itsCombi = GameLogic.getBestCombi(player, commons);
            if(myCombi.compareTo(itsCombi) < 0) {
                return;
            }
        }
        myWin += 1;
    }

    public void dealCards() {
        for(int i = 0; i < players.length; i++) {
            players[i] = new Hand(cardDeck.getCard(), cardDeck.getCard());
        }
    }

    public void dealCommons() {
        commons = new ArrayList<>();
        commons.addAll(knownCommons);
        while(commons.size() < 5) {
            commons.add(cardDeck.getCard());
        }

    }

    public void getGameInfo() {
        this.myHand = Parser.getAHandInput();
        int numOfPlayer = Parser.getPlayerCount();
        players = new Hand[numOfPlayer - 1];
        knownCommons = Parser.getCommonsInput();
    }

}
