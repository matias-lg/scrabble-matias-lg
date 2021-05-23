package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.IScrabbleInteger;
import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNumber;

import java.util.Objects;

/**
 * Native Scrabble Binary
 */
public class ScrabbleBinary extends ScrabbleNumber implements IScrabbleInteger {
    private String value;

    /**
     * Stores a string which represents a binary number, ej: "0101010101"
     *
     * @param value String of only "1"s and "0"s
     */
    public ScrabbleBinary(String value) {
        this.value = value;
    }

    /**
     * Gets the stored binary as a String
     *
     * @return String of the stored binary
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the stored binary as a string
     *
     * @return String of the stored binary
     */
    public String toString() {
        return this.value;
    }

    /**
     * Compare two ScrabbleBinary by their encapsulated String
     *
     * @param o Object to compare
     * @return true if both are ScrabbleBinary and store the same string, else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleBinary)) return false;
        ScrabbleBinary that = (ScrabbleBinary) o;
        return Objects.equals(value, that.value);
    }

    /**
     * Hash that represents the object, created using the stored String
     *
     * @return hash of stored binary String
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Creates a new ScrabbleString that stores the binary contained in *this*
     *
     * @return new ScrabbleString that stores the currently stored binary String
     */
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(this.value);
    }

    /* TODO 2*/
    public ScrabbleFloat asScrabbleFloat() {
        return null;
    }
}
