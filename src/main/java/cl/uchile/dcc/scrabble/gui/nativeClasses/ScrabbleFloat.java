package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

/**
 * Tipo elemental float, almacena un double de Java
 */
public class ScrabbleFloat implements INative {
    private double value;

    public ScrabbleFloat(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String toString(){
        return Double.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleFloat)) return false;
        ScrabbleFloat that = (ScrabbleFloat) o;
        return Double.compare(that.getValue(), getValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
