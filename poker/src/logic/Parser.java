package poker.src.logic;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    public static Hand getAHandInput() throws NullPointerException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Key in your hand: ");
        String input = sc.nextLine();
        String[] terms = input.split(" ");
        Hand hand = new Hand(parseSuit(terms[0]), parseSuit(terms[2]), parseNumber(terms[1]), parseNumber(terms[3]));
        return hand;
    }

    public static ArrayList<Card> getCommonsInput() throws NullPointerException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Key in known common cards: ");
        String input = sc.nextLine();
        String[] terms = input.split(" ");
        ArrayList<Card> commons = new ArrayList<>();
        if (terms.length == 1) {
            return commons;
        }
        for(int i = 0; i < terms.length / 2; i++) {
            commons.add(new Card(parseSuit(terms[2*i]), parseNumber(terms[2 * i + 1])));
        }
        return commons;
    }

    public static int getPlayerCount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of players: ");
        String input = sc.nextLine();
        System.out.println(input);
        return Integer.parseInt(input);
    }

    private static CardNumber parseNumber(String input) throws NullPointerException{
        int number = Integer.parseInt(input);
        number -= 1;
        if(number == 0) {
            number = 13;
        }
        return CardNumber.getNumber(number);
    }

    private static Suit parseSuit(String input) throws NullPointerException{
        return Suit.getSuit(input);
    }
}
