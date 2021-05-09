package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNumber;

import java.util.Objects;

/**
 * Tipo elemental float, almacena un double de Java
 */
public class ScrabbleFloat extends ScrabbleNumber {
    private double value;

    /**
     * Tipo Float nativo de Scrabble
     *
     * @param value double a almacenar en el objeto
     */
    public ScrabbleFloat(double value) {
        this.value = value;
    }

    /**
     * @return double almacenado en el objeto
     */
    public double getValue() {
        return value;
    }

    /**
     * Obtener el valor almacenado por el objeto en forma de String
     *
     * @return el double almacenado en forma de String
     */
    @Override
    public String toString() {
        return Double.toString(value);
    }

    /**
     * Comparar dos ScrabbleFloat a traves del valor que guardan
     *
     * @param o Objeto a comparar, si no es un ScrabbleFloat será siempre falso
     * @return true si los ScrabbleFloat guardan el mismo double, sino, false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleFloat)) return false;
        ScrabbleFloat that = (ScrabbleFloat) o;
        return Double.compare(that.getValue(), getValue()) == 0;
    }

    /**
     * Hash representativo del ScrabbleFloat obtenido a traves del valor que guarda
     *
     * @return hash del double guardado en value
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    /**
     * Convierte un ScrabbleFloat a ScrabbleString
     *
     * @return ScrabbleString que guarda el double almacenado en value como String
     */
    @Override
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(toString());
    }

    /**
     * Retorna una copia del ScrabbleFloat
     *
     * @return nuevo ScrabbleFloat que almacena el mismo double almacenado en value
     */
    public ScrabbleFloat asScrabbleFloat() {
        return new ScrabbleFloat(this.getValue());
    }
}
