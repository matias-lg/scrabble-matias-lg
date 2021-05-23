package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.IScrabbleInteger;
import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNumber;

import java.util.Objects;

/**
 * Native Scrabble int, stores a Java int
 */
public class ScrabbleInt extends ScrabbleNumber implements IScrabbleInteger {
    private int value;

    /**
     * Native Scrabble int
     *
     * @param value int to store
     */
    public ScrabbleInt(int value) {
        this.value = value;
    }

    /**
     * @return encapsulated int
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Converts the stored int to a String
     *
     * @return String from the int stored in value
     */
    @Override
    public String toString() {
        return Integer.toString(getValue());
    }

    /**
     * Compares two ScrabbleInt
     *
     * @param o Object to compare with
     * @return true if its compared with a ScrabbleInt which stores the same int
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleInt)) return false;
        ScrabbleInt that = (ScrabbleInt) o;
        return getValue() == that.getValue();
    }

    /**
     * Generates Hash from a ScrabbleInt using its stored value
     *
     * @return hash created from the stored int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    /**
     * Transforms a ScrabbleInt to a ScrabbleString which stores the current int as a String
     *
     * @return ScrabbleString which stores the current int as a String
     */
    public ScrabbleString asScrabbleString() {
        String strValue = Integer.toString(this.getValue());
        return new ScrabbleString(strValue);
    }

    /**
     * Transforms a ScrabbleInt to ScrabbleFloat storing the current saved int casted as a double
     *
     * @return ScrabbleFloat which stores the current int as a double
     */
    public ScrabbleFloat asScrabbleFloat() {
        return new ScrabbleFloat(this.getValue());
    }

    /**
     * Creates a copy of a ScrabbleInt
     *
     * @return new ScrabbleInt storing the same value
     */
    public ScrabbleInt asScrabbleInt() {
        return new ScrabbleInt(this.getValue());
    }

    /*
    para entrega 2
     */
    public ScrabbleBinary asScrabbleBinary() {
        String binary = Integer.toBinaryString(this.getValue());
        return new ScrabbleBinary(binary);
    }
}
