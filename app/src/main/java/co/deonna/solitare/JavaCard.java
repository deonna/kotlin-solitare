package co.deonna.solitare;

/**
 * Created by deonna on 6/4/17.
 */
public class JavaCard {

    private final int value;
    private final String suit;
    private boolean faceUp ;

    public JavaCard(int value, String suit, boolean faceUp) {

        this.value = value;
        this.suit = suit;
        this.faceUp = faceUp;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }
}