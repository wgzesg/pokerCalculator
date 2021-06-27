public enum Rank {

    HighCard(0),
    OnePair(1),
    TwoPair(2),
    ThreeOfAKind(3),
    Straight(4),
    Flush(5),
    FullHouse(6),
    FourOfAKind(7),
    StraightFlush(8);

    private Integer ranking;

    Rank(int rank) {
        this.ranking = rank;
    }

    boolean isHigher(Rank r) {
        return this.ranking > r.ranking;
    }
    
    boolean isLower(Rank r) {
        return this.ranking < r.ranking;
    }

}
