package cl.uchile.dcc.scrabble.gui.natives;

import cl.uchile.dcc.scrabble.gui.nativeClasses.ScrabbleString;

/**
 * This interface is implemented by every Native Scrabble Class: String, Number and Boolean
 */
public interface INative {

    /**
     * Returns the stored value as a String
     * @return Stored value as a String
     */
    String toString();

    /**
     * Converts a native Scrabble type to a ScrabbleString
     *
     * @return  ScrabbleString which encapsulates a String of the value from caller INative
     */
    INative asScrabbleString();
}
