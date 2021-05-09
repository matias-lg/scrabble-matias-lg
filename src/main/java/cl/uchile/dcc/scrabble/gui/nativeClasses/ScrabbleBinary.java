package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.IScrabbleInteger;
import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNumber;

import java.util.Objects;

/**
 * Binario nativo de Scrabble
 */
public class ScrabbleBinary extends ScrabbleNumber implements IScrabbleInteger {
    private String value;

    /**
     * Guarda un String de numeros binarios, ej: "0101010101"
     *
     * @param value String que contiene solamente 0 o 1, representa un numero binario
     */
    public ScrabbleBinary(String value) {
        this.value = value;
    }

    /**
     * Obtener el binario almacenado en forma de String
     *
     * @return String del numero binario guardado
     */
    public String getValue() {
        return value;
    }

    /**
     * Obtiene el binario almacenado en forma de String
     *
     * @return String del numero binario guardado
     */
    public String toString() {
        return this.value;
    }

    /**
     * Comparar dos ScrabbleBinary a traves del String que guardan
     *
     * @param o Objeto a comparar
     * @return true si se compara con un ScrabbleBinary que guarde el mismo String binario, sino, false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleBinary)) return false;
        ScrabbleBinary that = (ScrabbleBinary) o;
        return Objects.equals(value, that.value);
    }

    /**
     * Hash representativo del ScrabbleBinary generado a traves del string que guarda
     *
     * @return hash del string almacenado
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    /**
     * Genera un ScrabbleString a partir del valor almacenado en el ScrabbleBinary
     *
     * @return nuevo ScrabbleString que guarda el String de numero binario
     */
    public ScrabbleString asScrabbleString() {
        return new ScrabbleString(this.value);
    }

    /* Para entrega 2*/
    public ScrabbleFloat asScrabbleFloat() {
        return null;
    }
}
