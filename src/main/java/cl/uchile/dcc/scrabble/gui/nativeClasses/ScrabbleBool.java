package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNative;

import java.util.Objects;

/**
 * Native Scrabble Boolean type
 */
public class ScrabbleBool extends ScrabbleNative {
    boolean value;

    /**
     * Stores a Java bool
     *
     * @param value bool to store
     */
    public ScrabbleBool(boolean value) {
        this.value = value;
    }

    /**
     * Gets stored bool
     *
     * @return bool stored
     */
    public boolean getValue() {
        return this.value;
    }

    /**
     * Gets the stored bool as a String
     *
     * @return String "true" if bool: true is stored. "false" if storing a false bool
     */
    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    /**
     * Compare two ScrabbleBool by their stored bools
     *
     * @param o Object to compare, if its a ScrabbleBool it should store the same value
     * @return true if both store the same bool
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleBool)) return false;
        ScrabbleBool that = (ScrabbleBool) o;
        return value == that.value;
    }

    /**
     * Representative Hash of a ScrabbleBool
     *
     * @return hash created using the stored bool
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Creates a new ScrabbleString which contains the stored bool as a String
     *
     * @return new ScrabbleString storing a bool as a String "true" or "false"
     */
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(toString());
    }
}
