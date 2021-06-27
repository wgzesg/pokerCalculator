import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameLogic {
    public static Combination getBestCombi(Hand myHand, ArrayList<Card> commons) {

        Combination bestCombi = new Combination(commons, Rank.HighCard);
        ArrayList<Card> ls = new ArrayList<>(commons);
        ls.add(myHand.first);
        ls.add(myHand.second);
        // System.out.println("cards are" + ls);
        Collections.sort(ls, Collections.reverseOrder());
        if((bestCombi = hasStraightFlush(ls)) != null) {

        } else if((bestCombi =hasFourOfAKind(ls)) != null) {

        } else if((bestCombi =hasFullHouse(ls)) != null) {

        } else if((bestCombi = hasFlush(ls)) != null) {

        } else if((bestCombi = hasStraight(ls)) != null) {

        } else if((bestCombi = hasThreeOfAKind(ls)) != null) {

        } else if((bestCombi = hasTwoPairs(ls)) != null) {

        } else if((bestCombi = hasOnePair(ls)) != null) {

        } else if((bestCombi = hasHighCard(ls)) != null) {

        }
        // System.out.println("we get" + bestCombi);
        return bestCombi;
    }

    private static Combination hasStraightFlush(List<Card> ls) {

        for(Suit s : Suit.values()) {
            List<Card> cardsOfTheSuit = findSameSuit(ls, s);
            if(cardsOfTheSuit.size() < 5) {
                continue;
            } else {
                List<Card> potenialCombi = findStraight(cardsOfTheSuit);
                if(potenialCombi != null) {
                    return new Combination(potenialCombi, Rank.StraightFlush);
                }
            }
        }
        return null;
    }

    private static Combination hasFourOfAKind(List<Card> ls) {
        List<Card> fours = getXOfAKind(ls, 4);
        if(fours == null) {
            return null;
        }
        List<Card> newLs = removeUsed(ls, fours);

        fours.add(newLs.get(0));
        return new Combination(fours, Rank.FourOfAKind);
    }

    private static Combination hasFullHouse(List<Card> ls) {
        List<Card> threes = getXOfAKind(ls, 3);
        if(threes == null) {
            return null;
        }
        List<Card> newLs = removeUsed(ls, threes);
        List<Card> pair = getXOfAKind(newLs, 2);
        if(pair == null) {
            return null;
        }
        threes.addAll(pair);
        return new Combination(threes, Rank.FullHouse);
    }

    private static Combination hasFlush(List<Card> ls) {
        for(Suit s : Suit.values()) {
            List<Card> sameSuit = findSameSuit(ls, s);
            if(sameSuit != null && sameSuit.size() == 5) {
                return new Combination(sameSuit, Rank.Flush);
            }
        }
        return null;
    }

    private static Combination hasStraight(List<Card> ls) {

        List<Card> cardsWithNoRepeats = removeRepeats(ls);
        if(cardsWithNoRepeats.size() < 5) {
            return null;
        }
        List<Card> potenialCombi = findStraight(cardsWithNoRepeats);
        if(potenialCombi != null) {
            return new Combination(potenialCombi, Rank.Straight);
        }
        return null;
    }

    private static Combination hasThreeOfAKind(List<Card> ls) {
        List<Card> threes = getXOfAKind(ls, 3);
        if(threes == null) {
            return null;
        }
        List<Card> newLs = removeUsed(ls, threes);

        threes.add(newLs.get(0));
        threes.add(newLs.get(1));
        return new Combination(threes, Rank.ThreeOfAKind);
    }
    
    private static Combination hasTwoPairs(List<Card> ls) {
        List<Card> twos = getXOfAKind(ls, 2);
        if(twos == null) {
            return null;
        }
        List<Card> newLs = removeUsed(ls, twos);
        List<Card> pair = getXOfAKind(newLs, 2);
        if(pair == null) {
            return null;
        }
        newLs = removeUsed(newLs, pair);
        twos.addAll(pair);
        twos.add(newLs.get(0));
        return new Combination(twos, Rank.TwoPair);
    }

    private static Combination hasOnePair(List<Card> ls) {
        List<Card> twos = getXOfAKind(ls, 2);
        if(twos == null) {
            return null;
        }
        List<Card> newLs = removeUsed(ls, twos);

        for(int i = 0; i < 3; i++) {
            twos.add(newLs.get(i));
        }
        return new Combination(twos, Rank.OnePair);
    }

    private static Combination hasHighCard(List<Card> ls) {
        List<Card> newLs = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            newLs.add(ls.get(i));
        }
        return new Combination(newLs, Rank.HighCard);
    }

    private static List<Card> findSameSuit(List<Card> ls, Suit s) {
        List<Card> cards = new ArrayList<>();
        for(Card c :ls) {
            if(c.getSuit() == s) {
                cards.add(c);
            }
        }
        return cards;
    }

    private static List<Card> findStraight(List<Card> cardsOfTheSuit) {
        for(int i = 0; i < cardsOfTheSuit.size() - 4; i++) {
            Card thisCard = cardsOfTheSuit.get(i);
            int num = thisCard.getNumber();
            ArrayList<Card> cards = new ArrayList<>();
            cards.add(thisCard);
            for(int j = 1; j < 5; j++) {
                if(num - cardsOfTheSuit.get(i + j).getNumber() == j) {
                    cards.add(cardsOfTheSuit.get(i + j));
                    if(j == 4) {
                        return cards;
                    }
                } else {
                    break;
                }
            }
        }
        if(cardsOfTheSuit.get(0).getNumber() == 13) {
            ArrayList<Card> cards = new ArrayList<>();
            for(int i = 4; i > 0; i--) {
                if(cardsOfTheSuit.get(cardsOfTheSuit.size() - i).getNumber() == i) {
                    cards.add(cardsOfTheSuit.get(cardsOfTheSuit.size() - i));
                } else {
                    return null;
                }
            }
            cards.add(cardsOfTheSuit.get(0));
            return cards;
        }
        return null;
    }

    private static List<Card> removeRepeats(List<Card> ls) {
        List<Card> newList = new ArrayList<>();
        newList.add(ls.get(0));
        for(int i = 1; i < ls.size(); i++) {
            if(ls.get(i).getNumber() != ls.get(i-1).getNumber()) {
                newList.add(ls.get(i));
            }
        }
        return newList;
    }

    private static List<Card> getXOfAKind(List<Card> ls, int count) {
        for(Card cd : ls) {
            List<Card> cards = new ArrayList<>();
            for(Card d : ls) {
                if(cd.getNumber() == d.getNumber()){
                    cards.add(d);
                }
            }
            if(count == cards.size()) {
                return cards;
            }
        }
        return null;
    }

    private static List<Card> removeUsed(List<Card> ls, List<Card> removing) {
        List<Card> newLs = new ArrayList<>(ls);
        for(Card c : removing) {
            newLs.remove(c);
        }
        return newLs;

    }
}