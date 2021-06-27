package poker.src;
import java.util.List;

public class Combination implements Comparable<Combination> {
    List<Card> combi;
    Rank rank;

    Combination(List<Card> cards, Rank r) {
        combi = cards;
        rank = r;
    }

    @Override
    public String toString() {
        return combi.toString() + " of rank " + rank;
    }

    @Override
    public int compareTo(Combination o) {
        if(this.rank.isHigher(o.rank)) {
            return 1;
        } else if(this.rank.isLower(o.rank)) {
            return -1;
        } else {
            for(int i = 0 ; i < 5; i++) {
                if(combi.get(i).compareTo(o.combi.get(i)) != 0) {
                    return combi.get(i).compareTo(o.combi.get(i));
                }
            }
        }
        return 0;
    }



}
