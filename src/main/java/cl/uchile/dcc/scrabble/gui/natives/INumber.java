package cl.uchile.dcc.scrabble.gui.natives;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleFloat;

/**
 * This interface implements every operation which a native Scrabble number should be able to do
 * TODO implementar en ScrabbleInt, ScrabbleFloat, ScrabbleBinary
 */
public interface INumber extends INative {
    /* Transformaciones */

    /**
     * Converts a Number to float
     *
     * @return new ScrabbleFloat containing caller Number's value as a double
     */
    public INumber asScrabbleFloat();
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
