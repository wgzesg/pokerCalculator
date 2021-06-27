package poker.src;
public enum Suit {
    Spade("♠️"),
    Heart("♥️"),
    Diamond("♦️"),
    Club("♣️");

    private String name;

    public static Suit getSuit(String in) throws NullPointerException {
        if(in.equals("S") || in.equals("s") || in.equals("spade") || in.equals("Spade")) {
            return Spade;
        }
        if(in.equals("H") || in.equals("h") || in.equals("heart") || in.equals("Heart")) {
            return Heart;
        }
        if(in.equals("D") || in.equals("d") || in.equals("diamond") || in.equals("Diamond")) {
            return Diamond;
        }
        if(in.equals("C") || in.equals("c") || in.equals("club") || in.equals("Club")) {
            return Club;
        }
        throw new NullPointerException();
    }

    private Suit(String name) {  
        this.name = name;
    } 

    @Override
    public String toString() {
        return this.name;
    }
}
