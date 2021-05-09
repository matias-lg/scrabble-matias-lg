package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNative;

import java.util.Objects;

/**
 * String nativo de Scrabble, almacena un String de java
 */
public class ScrabbleString extends ScrabbleNative {
    private String value;

    /**
     * Encapsula un String en una instancia de ScrabbleString
     *
     * @param str String a almacenar en el objeto
     */
    public ScrabbleString(String str) {
        this.value = str;
    }

    /**
     * Obtener el String almacenado en el objeto
     *
     * @return String almacenado en la instancia de ScrabbleString
     */
    public String getValue() {
        return value;
    }

    /**
     * Comparar dos ScrabbleString a traves del valor que guardan
     *
     * @param o objeto a comparar
     * @return true Si los dos ScrabbleString guardan el mismo string, sino, false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleString)) return false;
        ScrabbleString that = (ScrabbleString) o;
        return getValue().equals(that.getValue());
    }

    /**
     * Obtener un hash del ScrabbleString
     *
     * @return Hash representativo del ScrabbleString generado a partir del String almacenado
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    /**
     * Obtener una copia de un ScrabbleString
     *
     * @return nuevo ScrabbleString almacenando el mismo String que el almacenado en quien llamó al método
     */
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(this.value);
    }
}