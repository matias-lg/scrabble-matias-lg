package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

/**
 * Tipo elemental int (entero)
 */
public class ScrabbleInt {
    private int value;

    public ScrabbleInt(int value) {
        this.value = value;
    }


    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleInt)) return false;
        ScrabbleInt that = (ScrabbleInt) o;
        return getValue() == that.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}
