package cl.uchile.dcc.scrabble.gui.natives.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.interfaces.AbstractNative;
import cl.uchile.dcc.scrabble.gui.natives.interfaces.INative;

public class SNull extends AbstractNative implements INative {

  /**
   * Converts a native Scrabble type to a SString
   *
   * @return SString which encapsulates a String of the value from caller INative
   */
  @Override
  public INative toSString() {
    return null;
  }

  /**
   * @return null as a String
   */
  public String toString() {
    return "null";
  }

  /**
   * Result of adding a String with an Inative
   *
   * @param str String to sum with
   */
  @Override
  public SString sumWithString(SString str) {
    return null;
  }

  /**
   * Compares two Nulls
   *
   * @param o Object to compare with
   * @return true if its compared with a SNull
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    return o instanceof SNull;
  }
}
