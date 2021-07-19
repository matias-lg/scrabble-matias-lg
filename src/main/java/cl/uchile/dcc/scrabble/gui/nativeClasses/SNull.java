package cl.uchile.dcc.scrabble.gui.nativeClasses;

import cl.uchile.dcc.scrabble.gui.natives.AbstractNative;
import cl.uchile.dcc.scrabble.gui.natives.INative;

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
   * Result of adding a String with an Inative
   *
   * @param str String to sum with
   */
  @Override
  public SString sumWithString(SString str) {
    return null;
  }
}
