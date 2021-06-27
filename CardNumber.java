public enum CardNumber {
    Two("2", 1),
    Three("3", 2),
    Four("4", 3),
    Five ("5", 4),
    Six("6", 5),
    Seven("7", 6),
    Eight("8", 7),
    Nine("9", 8),
    Ten("T",9),
    Eleven("J", 10),
    Twelve("Q", 11),
    Thirteen("K", 12),
    One("A", 13);

    public String name;
    public int index;

    CardNumber(String name, int index) {  
        this.name = name;  
        this.index = index;  
    } 

    public static CardNumber getNumber(int in) {
        for (CardNumber c : CardNumber.values()) {  
            if (c.index == in) {  
                return c;  
            }  
        }
        throw new NullPointerException();
    }

    public int isMoreThan(CardNumber c) {
        return this.index - c.index;
    }

    @Override 
    public String toString() { 
        return this.name; 
    } 

}
