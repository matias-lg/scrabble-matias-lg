package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNative;

import java.util.Objects;

/**
 * Tipo booleano nativo de Scrabble
 */
public class ScrabbleBool extends ScrabbleNative {
    boolean value;

    /**
     * Almacena un bool de java en una instancia de ScrabbleBool
     *
     * @param value bool de Java a almacenar
     */
    public ScrabbleBool(boolean value) {
        this.value = value;
    }

    /**
     * Obtener el bool guardado en el objeto
     *
     * @return bool almacenado
     */
    public boolean getValue() {
        return this.value;
    }

    /**
     * Obtener el bool guardado en el objeto en forma de String
     *
     * @return String "true" si se almacena un bool: true. "false" si se almacena un bool false
     */
    @Override
    public String toString() {
        return Boolean.toString(value);
    }

    /**
     * Comparar dos ScrabbleBool a traves del valor que almacenan
     *
     * @param o Objeto a comparar, si es un ScrabbleBool debera almacenar el mismo valor
     * @return true si ambos ScrabbleBool guardan el mismo bool, sino, false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleBool)) return false;
        ScrabbleBool that = (ScrabbleBool) o;
        return value == that.value;
    }

    /**
     * Hash representativo del ScrabbleBool
     *
     * @return hash generado a partir del bool almacenado en el ScrabbleBool
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Genera un ScrabbleString a partir de un ScrabbleBool, este almacena el bool convertido a String
     *
     * @return nuevo ScrabbleString que contiene el bool almacenado en String
     */
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(toString());
    }
}
