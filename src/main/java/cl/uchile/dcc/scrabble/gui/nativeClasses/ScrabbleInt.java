package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.INative;

import java.util.Objects;

/**
 * Tipo elemental int (entero), almacena un int de Java en value
 */
public class ScrabbleInt implements INative {
    private int value;

    public ScrabbleInt(int value) {
       this.value = value;
    }


    public int getValue() {
        return this.value;
    }

    @Override
    public String toString(){
        return Integer.toString(getValue());
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
