package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleFloat;
import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;

/*
 * TODO implementar en ScrabbleInt, ScrabbleFloat, ScrabbleBinary
 */
public interface INumber extends INative {
    /* Transformaciones */
    public ScrabbleString asScrabbleString();
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
