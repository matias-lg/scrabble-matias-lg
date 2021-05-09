package cl.uchile.dcc.scrabble.gui.natives;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;

/**
 * Esta interfaz la implementan todas las clases nativas de Scrabble: String, numeros y boolean
 */
public interface INative {

    /**
     * Este metodo retorna el valor que la clase encapsule en forma de String
     *
     * @return valor almacenado en el objeto en forma de String
     */
    String toString();

    /**
     * Convierte una clase nativa de Scrabble a un ScrabbleString
     *
     * @return Un ScrabbleString que encapsula un String representativo al valor contenido en el objeto que
     * llamó a este método
     */
    ScrabbleString asScrabbleString();
}
