public class Card {
    private final Color color;
    private final Type type;
    private final int value;


    public enum Color{BLUE,GREEN,YELLOW,RED,WILD};
    public enum Type{NUMBER,REVERSE, SKIP, WILD, WILD_DRAW_TWO};

    public Card(Color color, Type type, int value) {
        this.color = color;
        this.type = type;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }
    public Type getType() {
        return type;
    }
    public int getValue() {
        return value;
    }


}
