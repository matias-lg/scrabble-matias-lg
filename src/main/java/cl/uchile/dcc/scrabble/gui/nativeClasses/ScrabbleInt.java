package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.IScrabbleInteger;
import cl.uchile.dcc.scrabble.gui.natives.ScrabbleNumber;

import java.util.Objects;

/**
 * Tipo elemental int (entero), almacena un int de Java en value
 */
public class ScrabbleInt extends ScrabbleNumber implements IScrabbleInteger {
    private int value;

    /**
     * Tipo entero nativo de Scrabble
     *
     * @param value numero entero a almacenar
     */
    public ScrabbleInt(int value) {
        this.value = value;
    }

    /**
     * @return el valor encapsulado en la clase
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Convierte el entero encapsulado por la clase a un String nativo de Java
     *
     * @return String del entero almacenado en value
     */
    @Override
    public String toString() {
        return Integer.toString(getValue());
    }

    /**
     * Metodo para comparar dos ScrabbleInt
     *
     * @param o objeto a comparar con el ScrabbleInt que llamó al método
     * @return true si se recibe un ScrabbleInt con el mismo valor almacenado, false si no
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScrabbleInt)) return false;
        ScrabbleInt that = (ScrabbleInt) o;
        return getValue() == that.getValue();
    }

    /**
     * obtener Hash del objeto considerando el valor que almacena
     *
     * @return hash generado a través del valor almacenado por el objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    /**
     * Transforma un ScrabbleInt a un ScrabbleString que almacena un String representativo del int almacenado.
     *
     * @return ScrabbleString que contiene el numero entero encapsulado en String
     */
    public ScrabbleString asScrabbleString() {
        String strValue = Integer.toString(this.getValue());
        return new ScrabbleString(strValue);
    }

    /**
     * Transforma ScrabbleInt a ScrabbleFloat guardando un float equivalente al numero entero
     *
     * @return ScrabbleFloat que guarda el entero transformado a double
     */
    public ScrabbleFloat asScrabbleFloat() {
        return new ScrabbleFloat(this.getValue());
    }

    /**
     * Devuelve una copia del ScrabbleInt
     *
     * @return nuevo ScrabbleInt almacenando el mismo valor
     */
    public ScrabbleInt asScrabbleInt() {
        return new ScrabbleInt(this.getValue());
    }

    /*
    para entrega 2
     */
    public ScrabbleBinary asScrabbleBinary() {
        String binary = Integer.toBinaryString(this.getValue());
        return new ScrabbleBinary(binary);
    }
}
