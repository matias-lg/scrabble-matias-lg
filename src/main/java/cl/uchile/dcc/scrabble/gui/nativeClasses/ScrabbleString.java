package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNative;

import java.util.Objects;

/**
 * Native Scrabble String, stores a Java String
 */
public class ScrabbleString extends ScrabbleNative {
    private String value;

    /**
     * Stores a String
     *
     * @param str String to store in the object
     */
    public ScrabbleString(String str) {
        this.value = str;
    }

    /**
     * Gets the stored String
     *
     * @return String stored in the ScrabbleString
     */
    public String getValue() {
        return value;
    }

    /**
     * Compares two ScrabbleString by their stored Strings
     *
     * @param o Object to compare with
     * @return true if both are ScrabbleString and store the same String
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleString)) return false;
        ScrabbleString that = (ScrabbleString) o;
        return getValue().equals(that.getValue());
    }

    /**
     * Creates a hash from a ScrabbleString instance
     *
     * @return Representative hash of a ScrabbleString created from its stored String
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    /**
     * Creates a copy of a ScrabbleString
     *
     * @return new ScrabbleString storing the same String
     */
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(this.value);
    }
}