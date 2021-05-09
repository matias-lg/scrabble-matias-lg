package cl.uchile.dcc.scrabble.gui.natives;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleFloat;

/**
 * Esta interfaz implementa las operaciones matemáticas básicas que los numeros nativos de Scrabble deberian ser capaces
 * de realizar
 * TODO implementar en ScrabbleInt, ScrabbleFloat, ScrabbleBinary
 */
public interface INumber extends INative {
    /* Transformaciones */

    /**
     * Convierte un Número en float
     *
     * @return un nuevo ScrabbleFloat que almacena el valor encapsulado por el objeto que llamó al metodo
     * convertido a float
     */
    public ScrabbleFloat asScrabbleFloat();
    /* Suma */
//    public ScrabbleNumber sumWithInt();
//    public ScrabbleNumber sumWithBinary();
    /* Resta */
//    public ScrabbleNumber subsWithInt();
//    public ScrabbleNumber subsWithBinary();
    /* Producto */
//    public ScrabbleNumber prodWithInt();
//    public ScrabbleNumber prodWithBinary();
    /* division */
//    public ScrabbleNumber divWithInt();
//    public ScrabbleNumber divWithBinary();
}
